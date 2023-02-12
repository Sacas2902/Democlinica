package com.m3.clinica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m3.clinica.dtos.ConsultaMedicosDTO;
import com.m3.clinica.modelo.Consulta;

public interface IConsultaRepo extends JpaRepository<Consulta,Integer> {
	/*
	@Query(name = "select idMedico,nombreMedico,apellidoMedico,count(*) consultas from medico group by idMedico" , nativeQuery = true)
	List<ConsultaMedicosDTO> totalConsultasPorMedico();	
	*/
	
}
