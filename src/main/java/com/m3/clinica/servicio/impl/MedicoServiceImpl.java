package com.m3.clinica.servicio.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.clinica.modelo.Medico;
import com.m3.clinica.repositorio.IMedicoRepo;
import com.m3.clinica.servicio.IMedicoService;
import com.m3.clinica.servicio.IReportesService;

@Service
public class MedicoServiceImpl implements IMedicoService {

	private final IMedicoRepo servicioMedico;
	
	private final IReportesService servicioReporte;
	
	@Autowired
	public MedicoServiceImpl(IMedicoRepo servicioMedico, IReportesService servicioReporte) {
		// TODO Auto-generated constructor stub
		this.servicioMedico = servicioMedico;
		this.servicioReporte = servicioReporte;
	}
	
	@Override
	public Medico registrar(Medico obj) {
		// TODO Auto-generated method stub
		return this.servicioMedico.save(obj);
	}
	
	
	@Override
	public List<Medico> buscarByAny(String filtro){
		
		return this.servicioMedico.buscarByAny(filtro);
	}
	

	@Override
	public Medico modificar(Medico obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medico> listar() {
		List<Medico> listMedicos= this.servicioMedico.findAll();
		return listMedicos;
	}

	@Override
	public Medico leerPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Medico> opMed= this.servicioMedico.findById(id);
		if(opMed.isPresent()) {
			return opMed.get();
		}else {
			return null;
		}
		
	}

	@Override
	public boolean eliminar(Medico obj) {
		// TODO Auto-generated method stub
		try {			
			this.servicioMedico.delete(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}

	public void generarReporteMedicos(HttpServletResponse response) throws IOException {
		final InputStream stream = this.getClass().getResourceAsStream("/reports/medicos.jrxml");
		this.servicioReporte.generarReporte(stream, response, listar());
	}

}
