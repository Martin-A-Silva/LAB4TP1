package com.lab4.tp1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab4.tp1.models.entity.Noticia;
import com.lab4.tp1.models.repository.NoticiaRepository;

@Service
public class NoticiaService {
	@Autowired
	NoticiaRepository noticiaRepository;

	public List<Noticia> getAllNoticia() {
		List<Noticia> noticia = new ArrayList<Noticia>();
		noticiaRepository.findAll().forEach(noticia1 -> noticia.add(noticia1));
		return noticia;
	}

	public Noticia getNoticiaById(Long Id) {
		return noticiaRepository.findById(Id).get();
	}

	public Noticia saveOrUpdate(Noticia noticia) {
		return noticiaRepository.save(noticia);
	}

	public void delete(Long Id) {
		noticiaRepository.deleteById(Id);
	}

	public void update(Noticia noticia, int noticiaId) {
		noticiaRepository.save(noticia);
	}
}
