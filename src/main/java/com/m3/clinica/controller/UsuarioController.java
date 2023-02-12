package com.m3.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.clinica.modelo.Usuario;
import com.m3.clinica.servicio.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private final IUsuarioService servicioUsuario;

	@Autowired
	public UsuarioController(IUsuarioService servicioUsuario) {
		// TODO Auto-generated constructor stub
		this.servicioUsuario = servicioUsuario;
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> mostrarUsuarios() {
		List<Usuario> usuarios = this.servicioUsuario.listar();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> usuarioById(@PathVariable("id") Integer id) {
		Usuario usuario = this.servicioUsuario.leerPorId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@GetMapping("/filtrar/{filtro}")
	public ResponseEntity<List<Usuario>> filtrarUsuario(@PathVariable("filtro") String filtro) {
		return new ResponseEntity<List<Usuario>>(this.servicioUsuario.buscarByAny(filtro.toLowerCase()), HttpStatus.OK);
	}

	@PostMapping
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return this.servicioUsuario.registrar(usuario);
	}
	
	@PutMapping
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {
		return this.servicioUsuario.modificar(usuario);
	}
	
	@PutMapping(path = "/cambiarPassword")
	public Usuario cambiarPassword(@RequestBody Usuario usuario) {
		return this.servicioUsuario.cambiarPassword(usuario);
	}

}
