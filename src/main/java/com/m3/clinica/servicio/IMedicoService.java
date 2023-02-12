package com.m3.clinica.servicio;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.m3.clinica.modelo.Medico;

public interface IMedicoService extends ICRUD<Medico> {
	List<Medico> buscarByAny(String filtro);
	
	public void generarReporteMedicos(HttpServletResponse response) throws IOException;
}
