package com.m3.clinica.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="detalle_consulta")
public class DetalleConsulta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDetalleConsulta;
	
	@ManyToOne
	@JoinColumn(name="id_consulta",nullable=false,
	foreignKey=@ForeignKey(name="FK_consulta_detalle"))
	private Consulta consulta;
	
	private String diagnostico;
	private String tratamiento;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="consulta_examanen", 
	joinColumns = @JoinColumn(name="id_detalle_consulta",referencedColumnName="idDetalleConsulta"),
	inverseJoinColumns = @JoinColumn(name="id_examen",referencedColumnName="idExamen"))
	private List<Examen> examenes;

	public DetalleConsulta() {
		// TODO Auto-generated constructor stub
	}
	public DetalleConsulta(Integer idDetalleConsulta, Consulta consulta, String diagnostico, String tratamiento,
			List<Examen> examenes) {
		super();
		this.idDetalleConsulta = idDetalleConsulta;
		this.consulta = consulta;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.examenes = examenes;
	}
	public Integer getIdDetalleConsulta() {
		return idDetalleConsulta;
	}
	public void setIdDetalleConsulta(Integer idDetalleConsulta) {
		this.idDetalleConsulta = idDetalleConsulta;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public List<Examen> getExamenes() {
		return examenes;
	}
	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}	
	
	
	
	
	
}
