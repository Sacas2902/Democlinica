package com.m3.clinica.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import static org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport.*;
public class ConsultaDTO extends RepresentationModel<ConsultaDTO>{
	private Integer idConsulta;
	private Integer paciente;	
	private Integer medico;
	private Integer especialidad;
	private String numConsultorio;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime fechaConsulta;
	
	public ConsultaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ConsultaDTO(Integer idConsulta, Integer paciente, Integer medico, Integer especialidad,
			String numConsultorio, LocalDateTime fechaConsulta) {
		super();
		this.idConsulta = idConsulta;
		this.paciente = paciente;
		this.medico = medico;
		this.especialidad = especialidad;
		this.numConsultorio = numConsultorio;
		this.fechaConsulta = fechaConsulta;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public Integer getMedico() {
		return medico;
	}

	public void setMedico(Integer medico) {
		this.medico = medico;
	}

	public Integer getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Integer especialidad) {
		this.especialidad = especialidad;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	
	
}
