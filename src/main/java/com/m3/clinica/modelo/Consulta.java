package com.m3.clinica.modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idConsulta;
	
	@ManyToOne
	@JoinColumn(name="id_paciente",nullable=false,
	foreignKey=@ForeignKey(name="FK_consulta_paciente"))
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="id_medico",nullable=false,
	foreignKey=@ForeignKey(name="FK_consulta_medico"))
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="id_especialidad",nullable=false,
	foreignKey=@ForeignKey(name="FK_consulta_especialidad"))
	private Especialidad especialidad;	
	private String numConsultorio;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime fechaConsulta;	
	private LocalTime horaConsulta;
	@OneToMany(mappedBy="consulta", cascade= { CascadeType.ALL }, orphanRemoval=true)
	private List<DetalleConsulta> detalleConsulta;
	
	public Consulta() {
		// TODO Auto-generated constructor stub
	}

	public Consulta(Integer idConsulta, Paciente paciente, Medico medico, Especialidad especialidad,
			String numConsultorio, LocalDateTime fechaConsulta, List<DetalleConsulta> detalleConsulta) {
		super();
		this.idConsulta = idConsulta;
		this.paciente = paciente;
		this.medico = medico;
		this.especialidad = especialidad;
		this.numConsultorio = numConsultorio;
		this.fechaConsulta = fechaConsulta;
		this.detalleConsulta = detalleConsulta;
	}
	
	

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
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

	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}

	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}
	
	
	
	
}
