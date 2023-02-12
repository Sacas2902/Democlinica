package com.m3.clinica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.clinica.modelo.Especialidad;
import com.m3.clinica.repositorio.IEspecialidadRepo;
import com.m3.clinica.servicio.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService  {
	
	private final IEspecialidadRepo especialidadRepo;
	
	@Autowired
	public EspecialidadServiceImpl(IEspecialidadRepo especialidadRepo) {
		// TODO Auto-generated constructor stub
		this.especialidadRepo = especialidadRepo;
	}

	@Override
	public Especialidad registrar(Especialidad obj) {
		// TODO Auto-generated method stub
		return this.especialidadRepo.save(obj);
	}

	@Override
	public Especialidad modificar(Especialidad obj) {
		// TODO Auto-generated method stub
		return registrar(obj);
	}

	@Override
	public List<Especialidad> listar() {
		// TODO Auto-generated method stub
		return this.especialidadRepo.findAll();
	}

	@Override
	public Especialidad leerPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.especialidadRepo.findById(id).get();
	}

	@Override
	public boolean eliminar(Especialidad obj) {
		// TODO Auto-generated method stub
		this.especialidadRepo.delete(obj);
		return true;
	}

	

}
