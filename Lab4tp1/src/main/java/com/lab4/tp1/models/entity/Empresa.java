package com.lab4.tp1.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String denominacion;
	
	@NotEmpty
	private String telefono;
	
	@NotEmpty
	@Column(name = "horario_de_atencion")
	private String horarioDeAtencion;
	
	@NotEmpty
	@Column(name = "quienes_somos") 
	private String quienesSomos;
	
	private double latitud;
	
	private double longitud;
	
	@NotEmpty
	private String domicilio;
	
	@NotEmpty
	@Email
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getHorariosDeAtencion() {
		return horarioDeAtencion;
	}
	public void setHorariosDeAtencion(String horariosDeAtencion) {
		this.horarioDeAtencion = horariosDeAtencion;
	}
	public String getQuienesSomos() {
		return quienesSomos;
	}
	public void setQuienesSomos(String quienesSomos) {
		this.quienesSomos = quienesSomos;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
