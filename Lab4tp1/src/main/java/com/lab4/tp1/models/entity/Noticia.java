package com.lab4.tp1.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Lob
	@JsonIgnore
	@Column(name = "imagen_noticia")
	private byte[] imagenNoticia;

	@NotEmpty
	@Column(name = "contenido_html")
	private String contenidoHTML;

	private char publicada;
	
	@Column(name = "fecha_publicacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_empresa")
	@Transient
	private int idEmpresa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	public Integer getFotoHashCode() {
		return (this.imagenNoticia != null) ? this.imagenNoticia.hashCode(): null;
	}
	
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

	public byte[] getImagenNoticia() {
		return imagenNoticia;
	}

	public void setImagenNoticia(byte[] imagenNoticia) {
		this.imagenNoticia = imagenNoticia;
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

	public Date getFechaPublicada() {
		return fechaPublicacion;
	}

	public void setFechaPublicada(Date fechaPublicada) {
		this.fechaPublicacion = fechaPublicada;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
}
