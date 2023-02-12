package com.m3.clinica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3.clinica.modelo.Especialidad;

public interface IEspecialidadRepo extends JpaRepository<Especialidad, Integer> {

}
