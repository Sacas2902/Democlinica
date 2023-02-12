package com.m3.clinica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="medico")
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMedico;
	private String nombreMedico;
	private String apellidoMedico;
	private String jvpm;
	private String foto;
	
	public Medico() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Medico(Integer idMedico, String nombreMedico, String apellidoMedico, String jvpm, String foto) {
		super();
		this.idMedico = idMedico;
		this.nombreMedico = nombreMedico;
		this.apellidoMedico = apellidoMedico;
		this.jvpm = jvpm;
		this.foto = foto;
		
	}



	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getApellidoMedico() {
		return apellidoMedico;
	}

	public void setApellidoMedico(String apellidoMedico) {
		this.apellidoMedico = apellidoMedico;
	}

	public String getJvpm() {
		return jvpm;
	}

	public void setJvpm(String jvpm) {
		this.jvpm = jvpm;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
}
