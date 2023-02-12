package com.m3.clinica.modelo;

public class GenericResponse<T> {
	private Integer code;
	private String message;
	private T response;
	
	public GenericResponse() {
		// TODO Auto-generated constructor stub
	}

		
	
	public GenericResponse(Integer code, String message, T response) {
		super();
		this.code = code;
		this.message = message;
		this.response = response;
	}






	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public T getResponse() {
		return response;
	}


	public void setResponse(T response) {
		this.response = response;
	}
	
	
	
	
	
	
}
