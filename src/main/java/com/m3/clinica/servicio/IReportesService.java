package com.m3.clinica.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface IReportesService<T> {
	public void generarReporte(InputStream stream, HttpServletResponse response, List<T> data) throws IOException;
}
