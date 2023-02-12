package com.m3.clinica.controller;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.clinica.dtos.ConsultaDTO;
import com.m3.clinica.modelo.Consulta;
import com.m3.clinica.modelo.GenericResponse;
import com.m3.clinica.servicio.IConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	private final IConsultaService consultaService;
	
	@Autowired
	public ConsultaController( IConsultaService consultaService) {
		// TODO Auto-generated constructor stub
		this.consultaService=consultaService;
	}
	
	@GetMapping("/hateos")
	public ResponseEntity<List<ConsultaDTO>> getAllHATEOSConsulta(){
		List<Consulta> consultas = this.consultaService.listar();
		List<ConsultaDTO> consultasDTO =new ArrayList<ConsultaDTO>();
		if(consultas.size()>0) {
			consultas.stream().forEach(c -> {
				ConsultaDTO consultaDTO = new ConsultaDTO(
					c.getIdConsulta(),
					c.getPaciente().getIdPaciente(),
					c.getMedico().getIdMedico(),
					c.getEspecialidad().getIdEspecialidad(),
					c.getNumConsultorio(),
					c.getFechaConsulta()
				);							
				 Link pacienteLink = linkTo(methodOn(PacienteController.class).pacienteById(c.getPaciente().getIdPaciente())).withSelfRel();
				 consultaDTO.add(pacienteLink);
				 consultasDTO.add(consultaDTO);
				
				//especialidadById
				
				//medicoById
			});
		}
		return new ResponseEntity<List<ConsultaDTO>>(consultasDTO,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> getAllConsulta(){
		List<Consulta> consultas = this.consultaService.listar();
		List<ConsultaDTO> consultasDTO =new ArrayList<ConsultaDTO>();
		if(consultas.size()>0) {
			consultas.stream().forEach(c -> {
				ConsultaDTO consultaDTO = new ConsultaDTO(
					c.getIdConsulta(),
					c.getPaciente().getIdPaciente(),
					c.getMedico().getIdMedico(),
					c.getEspecialidad().getIdEspecialidad(),
					c.getNumConsultorio(),
					c.getFechaConsulta()
				);	
				consultasDTO.add(consultaDTO);
			});
		}
		return new ResponseEntity<List<ConsultaDTO>>(consultasDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> consultadById(@PathVariable("id") Integer id){
		Consulta consulta = this.consultaService.leerPorId(id);		
		return new ResponseEntity<Consulta>(consulta,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<GenericResponse<Consulta>> guardarConsulta(@RequestBody Consulta consulta){
		HttpStatus http = HttpStatus.INTERNAL_SERVER_ERROR;
		GenericResponse<Consulta> resp = new GenericResponse<Consulta>(0,"Fallo - No puedo almacenarse consulta",consulta);
		
		Optional<Consulta> opt=Optional.of(consulta);
		if(opt.isPresent()) {
			if(consulta.getDetalleConsulta().size()>0) {
				consulta.getDetalleConsulta().stream().peek(d->d.setConsulta(consulta)).collect(Collectors.toList());
				try {
					consultaService.registrar(consulta);
					resp.setCode(1);
					resp.setMessage("Exito - Consulta almacenada correctamente");
					http=HttpStatus.OK;					
				} catch (Exception e) {
					// TODO: handle exception	
					System.out.println(e.getMessage());
				}
				
			}
		}
		return new ResponseEntity<GenericResponse<Consulta>>(resp,http);
		
	}
	
}
