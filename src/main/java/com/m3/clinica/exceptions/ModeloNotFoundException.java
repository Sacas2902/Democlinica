package com.m3.clinica.exceptions;

public class ModeloNotFoundException extends RuntimeException{

    public ModeloNotFoundException(String message) {
        super(message);
    }
}
