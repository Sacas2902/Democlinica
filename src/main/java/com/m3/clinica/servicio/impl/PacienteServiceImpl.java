package com.m3.clinica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.clinica.modelo.Paciente;
import com.m3.clinica.repositorio.IPacienteRepo;
import com.m3.clinica.servicio.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {

	private final IPacienteRepo pacienteRepo;
	
	@Autowired
	public PacienteServiceImpl(IPacienteRepo pacienteRepo) {
		// TODO Auto-generated constructor stub
		this.pacienteRepo = pacienteRepo;
	}
	
	@Override
	public Paciente registrar(Paciente obj) {
		// TODO Auto-generated method stub
		return pacienteRepo.save(obj);
	}

	@Override
	public Paciente modificar(Paciente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente leerPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.findById(id).orElse(new Paciente());
	}

	@Override
	public boolean eliminar(Paciente obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
