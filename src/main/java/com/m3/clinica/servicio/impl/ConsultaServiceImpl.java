package com.m3.clinica.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.clinica.modelo.Consulta;
import com.m3.clinica.repositorio.IConsultaRepo;
import com.m3.clinica.servicio.IConsultaService;

@Service
public class ConsultaServiceImpl implements IConsultaService {

	private final IConsultaRepo consultaRepo;
	
	@Autowired
	public ConsultaServiceImpl( IConsultaRepo consultaRepo) {
		this.consultaRepo=consultaRepo;
	}
	
	@Override
	public Consulta registrar(Consulta obj) {
		// TODO Auto-generated method stub
		return this.consultaRepo.save(obj);
	}

	@Override
	public Consulta modificar(Consulta obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return this.consultaRepo.findAll();
	}

	@Override
	public Consulta leerPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.consultaRepo.findById(id).get();
	}

	@Override
	public boolean eliminar(Consulta obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
