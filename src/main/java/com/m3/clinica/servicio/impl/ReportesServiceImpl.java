package com.m3.clinica.servicio.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.m3.clinica.servicio.IReportesService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportesServiceImpl<T> implements IReportesService<T> {

	@Override
	public void generarReporte(InputStream stream, HttpServletResponse response, List<T> data)
			throws IOException {
		// TODO Auto-generated method stub
				try {
					final JasperReport report = JasperCompileManager.compileReport(stream);
					final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(data);
					final Map<String, Object> parameters = new HashMap<>();
					parameters.put("createdBy", "Admin");
					final JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, source);
					response.setContentType("application/x-pdf");
					response.setHeader("Content-disposition", "inline; filename=App_report_en.pdf");
					final OutputStream outStream = response.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

				}catch(JRException e) {
					e.printStackTrace();
				}
		
	}

}
