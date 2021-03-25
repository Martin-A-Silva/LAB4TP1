package com.lab4.tp1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab4.tp1.models.entity.Empresa;
import com.lab4.tp1.models.repository.EmpresaRepository;


@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;

  
	public List<Empresa> getAllEmpresa() {
		List<Empresa> empresa = new ArrayList<Empresa>();
		empresaRepository.findAll().forEach(empresa1 -> empresa.add(empresa1));
		return empresa;
	}

  
	public Empresa getEmpresaById(Long id) {
		return empresaRepository.findById(id).get();
	}

  
	public void saveOrUpdate(Empresa empresa) {
		empresaRepository.save(empresa);
	}

  
	public void delete(Long id) {
		empresaRepository.deleteById(id);
	}

  
	public void update(Empresa empresa, Long empresaId) {
		empresaRepository.save(empresa);
	}
}
