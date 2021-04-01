package com.lab4.tp1.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lab4.tp1.models.entity.Noticia;

public interface NoticiaRepository extends CrudRepository<Noticia, Long> {

	@Query(value = "SELECT * FROM Noticia n WHERE n.id_empresa=?1", nativeQuery = true)
	public List<Noticia> getNoticiaByEmpresaId(Long id);
}
