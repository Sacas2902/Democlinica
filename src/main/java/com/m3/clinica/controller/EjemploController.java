package com.m3.clinica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejemplo")
public class EjemploController {
	
	@GetMapping
	public String saludoSpBoot() {
		String s="Hola desde spring boot";
		return s;
	}
}
