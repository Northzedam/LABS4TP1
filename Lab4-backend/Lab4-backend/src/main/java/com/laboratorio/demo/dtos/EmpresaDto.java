package com.laboratorio.demo.dtos;

public class EmpresaDto {

	private int id;
	private String denominacion;
	private String telefono;
	private String horario_de_atencion;
	private String quienes_somos;
	private double latitud;
	private double longitud;
	private String domicilio;
	private String email;

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
