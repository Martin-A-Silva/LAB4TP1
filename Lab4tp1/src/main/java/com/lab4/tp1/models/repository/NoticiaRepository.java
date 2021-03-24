package com.lab4.tp1.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.lab4.tp1.models.entity.Noticia;

public interface NoticiaRepository extends CrudRepository<Noticia, Long> {

}
