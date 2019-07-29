package com.proyecto.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="imagenes")
public class Imagenes implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo")
	private String tipoArchivo;
	
	@Column(name="nombre")
	private String nombreArchivo;
	
	@Column(name="adjunto")
	private String adjuntoArchivo;

	public Imagenes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imagenes(String tipo, String nombre, String adjunto) {
		super();
		this.tipoArchivo = tipo;
		this.nombreArchivo = nombre;
		this.adjuntoArchivo = adjunto;
	}

	public Long getId() {
		return id;
	}

	public void setIdj(Long id) {
		this.id = id;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getAdjuntoArchivo() {
		return adjuntoArchivo;
	}

	public void setAdjuntoArchivo(String adjuntoArchivo) {
		this.adjuntoArchivo = adjuntoArchivo;
	}
	
	
	

}