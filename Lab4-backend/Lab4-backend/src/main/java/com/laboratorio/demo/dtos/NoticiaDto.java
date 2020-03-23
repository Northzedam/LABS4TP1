package com.laboratorio.demo.dtos;

import java.util.Date;

public class NoticiaDto {

	private int id;
	private String titulo_de_la_noticia;
	private String resumen_de_la_noticia;
	private String imagen_noticia;
	private String contenido_html;
	private char publicada;
	private Date fecha_publicacion;
	private int idEmpresa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo_de_la_noticia() {
		return titulo_de_la_noticia;
	}

	public void setTitulo_de_la_noticia(String titulo_de_la_noticia) {
		this.titulo_de_la_noticia = titulo_de_la_noticia;
	}

	public String getResumen_de_la_noticia() {
		return resumen_de_la_noticia;
	}

	public void setResumen_de_la_noticia(String resumen_de_la_noticia) {
		this.resumen_de_la_noticia = resumen_de_la_noticia;
	}

	public String getImagen_noticia() {
		return imagen_noticia;
	}

	public void setImagen_noticia(String imagen_noticia) {
		this.imagen_noticia = imagen_noticia;
	}

	public String getContenido_html() {
		return contenido_html;
	}

	public void setContenido_html(String contenido_html) {
		this.contenido_html = contenido_html;
	}

	public char getPublicada() {
		return publicada;
	}

	public void setPublicada(char publicada) {
		this.publicada = publicada;
	}

	public Date getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(Date fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

}
