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

import com.lab4.tp1.models.entity.Empresa;
import com.lab4.tp1.service.EmpresaService;

  
@RestController
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

   
	@GetMapping("/empresa")
	public List<Empresa> getAllEmpresa() {
		return empresaService.getAllEmpresa();
	}

  
	@GetMapping("/empresa/{empresaid}")
	public Empresa getEmpresa(@PathVariable("empresaid") Long empresaId) {
		return empresaService.getEmpresaById(empresaId);
	}

  
	@DeleteMapping("/empresa/{empresaid}")
	public void deleteEmpresa(@PathVariable("empresaid") Long empresaId) {
		empresaService.delete(empresaId);
	}

  
	@PostMapping("/empresa")
	public Long saveEmpresa(@RequestBody Empresa empresa) {
		empresaService.saveOrUpdate(empresa);
		return empresa.getId();
	}

   
	@PutMapping("/empresa/{empresaId}")
	public ResponseEntity<?> update(@RequestBody Empresa empresa, @PathVariable Long empresaId){
		Empresa empresaDb = empresaService.getEmpresaById(empresaId);
		if(empresaDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		empresaDb.setDenominacion(empresa.getDenominacion());
		empresaDb.setTelefono(empresa.getTelefono());
		empresaDb.setHorariosDeAtencion(empresa.getHorariosDeAtencion());
		empresaDb.setQuienesSomos(empresa.getQuienesSomos());
		empresaDb.setLatitud(empresa.getLatitud());
		empresaDb.setLongitud(empresa.getLongitud());
		empresaDb.setDomicilio(empresa.getDomicilio());
		empresaDb.setEmail(empresa.getEmail());	
	
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.saveOrUpdate(empresaDb));
}
}