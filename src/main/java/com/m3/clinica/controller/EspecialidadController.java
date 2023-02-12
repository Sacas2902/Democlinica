package com.m3.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.clinica.modelo.Especialidad;
import com.m3.clinica.modelo.Medico;
import com.m3.clinica.modelo.Paciente;
import com.m3.clinica.servicio.IEspecialidadService;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

	private final IEspecialidadService servicioEspecialidad;
	
	@Autowired
	public EspecialidadController(IEspecialidadService servicioEspecialidad) {
		// TODO Auto-generated constructor stub
		this.servicioEspecialidad = servicioEspecialidad;	
	}
	
	@PostMapping
	public Especialidad guardarEspecialidad(@RequestBody Especialidad especialidad) {
		return this.servicioEspecialidad.registrar(especialidad);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> especialidadById(@PathVariable("id") Integer id){
		Especialidad especialidad = this.servicioEspecialidad.leerPorId(id);		
		return new ResponseEntity<Especialidad>(especialidad,HttpStatus.OK);
	}
	
}
