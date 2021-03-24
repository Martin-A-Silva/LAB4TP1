package com.lab4.tp1.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.lab4.tp1.models.entity.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
