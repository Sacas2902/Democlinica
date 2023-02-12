package com.m3.clinica.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.clinica.dtos.PacienteValidDTO;
import com.m3.clinica.exceptions.InvalidDataException;

@RestController
@RequestMapping("/validar")
public class ValidacionesController {

	@PostMapping
	public ResponseEntity<PacienteValidDTO> guardarPaciente(@Valid @RequestBody PacienteValidDTO paciente, BindingResult result) throws Exception{		
		if(result.hasErrors()) {
			throw new InvalidDataException(result);
		}
		return ResponseEntity.ok(paciente);
	}
}
