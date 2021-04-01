package com.lab4.tp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/noticia-by-empresaid/{empresaId}")
	public List<Noticia> getNoticiaByEmpresaId(@PathVariable Long empresaId) {
		return noticiaService.getNoticiaByEmpresaId(empresaId);
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

	@PutMapping("/noticia/{noticiaId}")
	public ResponseEntity<?> update(@RequestBody Noticia noticia, @PathVariable Long noticiaId){
		Noticia noticiaDb =noticiaService.getNoticiaById(noticiaId);
		if(noticiaDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		noticiaDb.setTituloDeLaNoticia(noticia.getTituloDeLaNoticia());
		noticiaDb.setResumenDeLaNoticia(noticia.getResumenDeLaNoticia());
		noticiaDb.setImagenNoticia(noticia.getImagenNoticia());
		noticiaDb.setContenidoHTML(noticia.getContenidoHTML());
		noticiaDb.setFechaPublicacion(noticia.getFechaPublicacion());
		noticiaDb.setEmpresa(noticia.getEmpresa());
		noticiaDb.setPublicada(noticia.getPublicada());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.saveOrUpdate(noticiaDb));
}
		
}
