package udb.m3.clinica.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.m3.clinica.dtos.PacienteValidDTO;

@SpringBootTest
@AutoConfigureMockMvc
class ValidacionesControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	void whenPacienteEmpty_guardarPaciente_thenReturnError() throws Exception {
		mvc.perform(post("http://localhost:8080/validar").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new PacienteValidDTO()))).andExpect(status().is4xxClientError());
	}

	@Test
	void whenPacienteFill_guardarPaciente_theReturnOk() throws Exception {
		PacienteValidDTO paciente = new PacienteValidDTO(1, "Maria Anabell", "Serrano Ortega", "02034456", "Libertad",
				"70986548", "maria.serrano@gmail.com", true, LocalDate.parse("1981-06-16"),
				LocalDate.parse("2025-06-16"));
		mvc.perform(post("http://localhost:8080/validar").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(paciente))).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());

			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void exceptionTesting_guardarPaciente_theReturnMessage() throws Exception {
		PacienteValidDTO paciente = new PacienteValidDTO(1, "Carlos", "lemus", "02324678", "libertad", "77495333",
				"carlos.lemus", true, LocalDate.parse("1981-11-01"), LocalDate.parse("2024-11-01"));
		mvc.perform(post("http://localhost:8080/validar").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(paciente))).andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.filedError[*]", is(List.of("debe ingresar un correo valido"))));

	}

}
