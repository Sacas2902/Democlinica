package com.m3.clinica.dtos;
import java.time.LocalDate;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;

import org.springframework.hateoas.RepresentationModel;


import com.fasterxml.jackson.annotation.JsonFormat;

public class PacienteDTO extends RepresentationModel<PacienteDTO> {
	private Integer idPaciente;	
	private String nombrePaciente;	
	private String apellidoPaciente;
	private String identPaciente;		
	private String direccionPaciente;	
	private String telefonoPaciente;
	private String emailPaciente;		
	
	public PacienteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PacienteDTO(Integer idPaciente, String nombrePaciente, String apellidoPaciente, String identPaciente,
			String direccionPaciente, String telefonoPaciente, String emailPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.apellidoPaciente = apellidoPaciente;
		this.identPaciente = identPaciente;
		this.direccionPaciente = direccionPaciente;
		this.telefonoPaciente = telefonoPaciente;
		this.emailPaciente = emailPaciente;
	}



	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidoPaciente() {
		return apellidoPaciente;
	}

	public void setApellidoPaciente(String apellidoPaciente) {
		this.apellidoPaciente = apellidoPaciente;
	}

	public String getIdentPaciente() {
		return identPaciente;
	}

	public void setIdentPaciente(String identPaciente) {
		this.identPaciente = identPaciente;
	}

	public String getDireccionPaciente() {
		return direccionPaciente;
	}

	public void setDireccionPaciente(String direccionPaciente) {
		this.direccionPaciente = direccionPaciente;
	}

	public String getTelefonoPaciente() {
		return telefonoPaciente;
	}

	public void setTelefonoPaciente(String telefonoPaciente) {
		this.telefonoPaciente = telefonoPaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	

	
	
	
}
