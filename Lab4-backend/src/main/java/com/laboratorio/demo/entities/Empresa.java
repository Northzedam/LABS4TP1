package com.laboratorio.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 1, max = 128)
	private String denominacion;
	@Size(min = 1, max = 50)
	private String telefono;
	@Size(min = 1, max = 256)
	private String horario_de_atencion;
	@Size(min = 1, max = 1024)
	private String quienes_somos;
	private double latitud;
	private double longitud;
	@Size(min = 1, max = 256)
	private String domicilio;
	@Size(min = 1, max = 75)
	private String email;

	public Empresa() {
	}

	public Empresa(int id, String denominacion, String telefono, String horario_de_atencion, String quienes_somos,
			double latitud, double longitud, String domicilio, String email) {

		this.id = id;
		this.denominacion = denominacion;
		this.telefono = telefono;
		this.horario_de_atencion = horario_de_atencion;
		this.quienes_somos = quienes_somos;
		this.latitud = latitud;
		this.longitud = longitud;
		this.domicilio = domicilio;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getHorario_de_atencion() {
		return horario_de_atencion;
	}

	public void setHorario_de_atencion(String horario_de_atencion) {
		this.horario_de_atencion = horario_de_atencion;
	}

	public String getQuienes_somos() {
		return quienes_somos;
	}

	public void setQuienes_somos(String quienes_somos) {
		this.quienes_somos = quienes_somos;
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
