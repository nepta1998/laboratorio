package com.proyecto.laboratorio.exception;

public class CustomFieldValidationException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = -4995433707591853255L;

    private String fieldName;

    public CustomFieldValidationException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}