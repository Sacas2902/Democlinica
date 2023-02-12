package com.m3.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.clinica.exceptions.ModeloNotFoundException;
import com.m3.clinica.modelo.Especialidad;
import com.m3.clinica.modelo.Medico;
import com.m3.clinica.modelo.Paciente;
import com.m3.clinica.servicio.IPacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

	private final IPacienteService servicePaciente;
	
	@Autowired
	public PacienteController(IPacienteService servicePaciente) {
		// TODO Auto-generated constructor stub
		this.servicePaciente = servicePaciente;
	}
	
	@PostMapping
	public Paciente guardarPaciente(@RequestBody Paciente paciente) {
		return this.servicePaciente.registrar(paciente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> pacienteById(@PathVariable("id") Integer id){
		Paciente paciente = this.servicePaciente.leerPorId(id);		
		if(paciente.getIdentPaciente() == null) {
			throw new ModeloNotFoundException("Paciente no encontrado");
		}		
		return new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
	}
}
