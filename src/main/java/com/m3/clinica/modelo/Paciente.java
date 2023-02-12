package com.m3.clinica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPaciente;
	@Column(name="nombre_paciente",nullable=false,length=70)
	private String nombrePaciente;
	@Column(name="apellido_paciente",nullable=false,length=70)
	private String apellidoPaciente;
	@Column(name="ident_paciente",nullable=true,length=20)
	private String identPaciente;
	@Column(name="direccion_paciente",nullable=false,length=100)
	private String direccionPaciente;
	@Column(name="telefono_paciente",nullable=false,length=10)
	private String telefonoPaciente;
	@Column(name="email_paciente",nullable=true,length=25)
	private String emailPaciente;
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Paciente(Integer idPaciente, String nombrePaciente, String apellidoPaciente, String identPaciente,
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
