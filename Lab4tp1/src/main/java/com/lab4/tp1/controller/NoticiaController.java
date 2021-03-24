package com.lab4.tp1.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lab4.tp1.models.entity.Noticia;
import com.lab4.tp1.service.NoticiaService;

@RestController
public class NoticiaController {
	@Autowired
	private NoticiaService noticiaService;

	@GetMapping("/{noticia}")
	public List<Noticia> getAllNoticia() {
		return noticiaService.getAllNoticia();
	}

	@GetMapping("/noticia/{noticiaId}")
	public Noticia getNoticia(@PathVariable("noticiaId") Long noticiaId) {
		return noticiaService.getNoticiaById(noticiaId);
	}

	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id){
		Noticia o = noticiaService.getNoticiaById(id);
		
		if(o.getImagenNoticia() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(o.getImagenNoticia());
		
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(imagen);
	}
	
	@DeleteMapping("/noticia/{noticiaId}")
	public void deleteNoticia(@PathVariable("noticiaId") Long noticiaId) {
		noticiaService.delete(noticiaId);
	}

	@PostMapping("/noticia")
	public Long saveNoticia(@RequestBody Noticia noticia) {
		noticiaService.saveOrUpdate(noticia);
		return noticia.getId();
	}

	@PutMapping("/noticia")
	public Noticia update(@RequestBody Noticia noticia) {
		noticiaService.saveOrUpdate(noticia);
		return noticia;
	}
	
	@PostMapping("/noticia-con-foto")
	public void saveNoticiaConFoto(@Valid Noticia noticia, @RequestParam MultipartFile archivo) throws IOException{
		if(!archivo.isEmpty()) {
			noticia.setImagenNoticia(archivo.getBytes());
		}
		noticiaService.saveOrUpdate(noticia);
		
	}
}
