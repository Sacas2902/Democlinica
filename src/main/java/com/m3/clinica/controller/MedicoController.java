package com.m3.clinica.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.m3.clinica.modelo.GenericResponse;
import com.m3.clinica.modelo.Medico;
import com.m3.clinica.servicio.IMedicoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	private final IMedicoService servicioMedico;

	@Autowired
	public MedicoController(IMedicoService servicioMedico) {
		// TODO Auto-generated constructor stub
		this.servicioMedico = servicioMedico;
	}

	@ApiOperation(value = "Obtener todos los medicos", notes = "No necesita parametros de entrada", responseContainer = "Medico")
	@ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED", response = Medico.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
			@ApiResponse(code = 404, message = "Not found, no encontrado"),
			@ApiResponse(code = 405, message = "No se encontraron pacientes en la BD"),
			@ApiResponse(code = 200, message = "Peticón OK") })

	@GetMapping
	public ResponseEntity<List<Medico>> mostrarMedicos() {
		List<Medico> medicos = this.servicioMedico.listar();
		return new ResponseEntity<List<Medico>>(medicos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> medicoById(@PathVariable("id") Integer id) {
		Medico medico = this.servicioMedico.leerPorId(id);
		return new ResponseEntity<Medico>(medico, HttpStatus.OK);
	}

	@GetMapping("/filtrar/{filtro}")
	public ResponseEntity<List<Medico>> filtrarMedico(@PathVariable("filtro") String filtro) {
		return new ResponseEntity<List<Medico>>(this.servicioMedico.buscarByAny(filtro.toLowerCase()), HttpStatus.OK);
	}

	@PostMapping
	public Medico guardarMedico(@RequestBody Medico medico) {
		return this.servicioMedico.registrar(medico);
	}

	@PutMapping
	public ResponseEntity<GenericResponse<Medico>> editarMedico(@RequestBody Medico medico) {
		Optional<Medico> med = Optional.ofNullable(this.servicioMedico.leerPorId(medico.getIdMedico()));
		GenericResponse<Medico> resp;
		if (med.isPresent()) {
			resp = new GenericResponse<Medico>(1, "medico guardado con exito", guardarMedico(medico));
			return new ResponseEntity<GenericResponse<Medico>>(resp, HttpStatus.OK);
		} else {
			resp = new GenericResponse<Medico>(0, "Error-No pudo encontrarse medico", new Medico());
			return new ResponseEntity<GenericResponse<Medico>>(resp, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<GenericResponse<Medico>> eliminarMedico(@PathVariable("id") Integer id) {
		Medico opMed = this.servicioMedico.leerPorId(id);
		GenericResponse<Medico> rs = new GenericResponse<Medico>();
		rs.setResponse(opMed);
		if (opMed != null) {
			if (this.servicioMedico.eliminar(opMed)) {
				rs.setCode(1);
				rs.setMessage("Exito - Medico eliminado");
				return new ResponseEntity<GenericResponse<Medico>>(rs, HttpStatus.OK);
			}

			else {
				rs.setCode(0);
				rs.setMessage("Error - No fue posible eliminar al medico");
				return new ResponseEntity<GenericResponse<Medico>>(rs, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {
			rs.setCode(0);
			rs.setMessage("Error - No pudo encontrarse el medico a eliminar");
			return new ResponseEntity<GenericResponse<Medico>>(rs, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/pdf")
	public void medicosPdf(ModelAndView model, HttpServletResponse response) throws IOException {		
		this.servicioMedico.generarReporteMedicos(response);
	}

}
