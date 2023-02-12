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

public class PacienteValidDTO extends RepresentationModel<PacienteValidDTO> {
	private Integer idPaciente;	
	@NotNull
	private String nombrePaciente;	
	private String apellidoPaciente;
	@Size(min=1, max=8)
	private String identPaciente;		
	private String direccionPaciente;	
	@SuppressWarnings("deprecation")
	@NotBlank(message="sin espacios en blanco")
	private String telefonoPaciente;
	@Email(message="debe ingresar un correo valido")
	private String emailPaciente;
	@AssertTrue
	private boolean tieneExpediente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Past
	private LocalDate fechaNacimiento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private LocalDate fechaVencimientoDui;
	
	
	public PacienteValidDTO() {
		// TODO Auto-generated constructor stub
	}


	public PacienteValidDTO(Integer idPaciente, @NotNull String nombrePaciente, String apellidoPaciente,
			@Size(min = 1, max = 8) String identPaciente, String direccionPaciente,
			@NotBlank(message = "sin espacios en blanco") String telefonoPaciente,
			@Email(message = "debe ingresar un correo valido") String emailPaciente,
			@AssertTrue boolean tieneExpediente, @Past LocalDate fechaNacimiento,
			@FutureOrPresent LocalDate fechaVencimientoDui) {
		super();
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.apellidoPaciente = apellidoPaciente;
		this.identPaciente = identPaciente;
		this.direccionPaciente = direccionPaciente;
		this.telefonoPaciente = telefonoPaciente;
		this.emailPaciente = emailPaciente;
		this.tieneExpediente = tieneExpediente;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaVencimientoDui = fechaVencimientoDui;
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


	public boolean isTieneExpediente() {
		return tieneExpediente;
	}


	public void setTieneExpediente(boolean tieneExpediente) {
		this.tieneExpediente = tieneExpediente;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public LocalDate getFechaVencimientoDui() {
		return fechaVencimientoDui;
	}


	public void setFechaVencimientoDui(LocalDate fechaVencimientoDui) {
		this.fechaVencimientoDui = fechaVencimientoDui;
	}
	
	
	
}
