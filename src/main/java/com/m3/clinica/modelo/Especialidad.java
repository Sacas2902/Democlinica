package com.m3.clinica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEspecialidad;
	private String nombreEspeciadad;
	
	public Especialidad() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Especialidad(Integer idEspecialidad, String nombreEspeciadad) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombreEspeciadad = nombreEspeciadad;
	}



	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspeciadad() {
		return nombreEspeciadad;
	}

	public void setNombreEspeciadad(String nombreEspeciadad) {
		this.nombreEspeciadad = nombreEspeciadad;
	}
	
	
}
