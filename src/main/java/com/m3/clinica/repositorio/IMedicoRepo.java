package com.m3.clinica.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.m3.clinica.modelo.Medico;

public interface IMedicoRepo extends JpaRepository<Medico,Integer> {
	@Query("from Medico m where LOWER(m.nombreMedico) like %:filtro% or LOWER(m.apellidoMedico) like %:filtro% or LOWER(m.jvpm) like %:filtro%")
	List<Medico> buscarByAny(@Param("filtro") String filtro );

}
