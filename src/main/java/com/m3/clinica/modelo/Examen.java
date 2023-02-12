package com.m3.clinica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="examen")
public class Examen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idExamen;
	private String nombreExamen;
	private String lectura;
	
	public Examen() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public String getNombreExamen() {
		return nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}
	
	
}
