package com.lab4.tp1.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "titulo_de_la_noticia")
	private String tituloDeLaNoticia;

	@NotEmpty
	@Column(name = "resumen_de_la_noticia")
	private String resumenDeLaNoticia;

	@NotEmpty
	@Column(name = "imagen_noticia")
	private String imagenNoticia;

	@NotEmpty
	@Column(name = "contenido_html")
	private String contenidoHTML;
	
	private char publicada;
	
	@Column(name = "fecha_publicacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;
		
	
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloDeLaNoticia() {
		return tituloDeLaNoticia;
	}

	public void setTituloDeLaNoticia(String tituloDeLaNoticia) {
		this.tituloDeLaNoticia = tituloDeLaNoticia;
	}

	public String getResumenDeLaNoticia() {
		return resumenDeLaNoticia;
	}

	public void setResumenDeLaNoticia(String resumenDeLaNoticia) {
		this.resumenDeLaNoticia = resumenDeLaNoticia;
	}	

	public String getContenidoHTML() {
		return contenidoHTML;
	}

	public void setContenidoHTML(String contenidoHTLM) {
		this.contenidoHTML = contenidoHTLM;
	}

	public char getPublicada() {
		return publicada;
	}

	public void setPublicada(char publicada) {
		this.publicada = publicada;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getImagenNoticia() {
		return imagenNoticia;
	}

	public void setImagenNoticia(String imagenNoticia) {
		this.imagenNoticia = imagenNoticia;
	}

	
	
	
}
