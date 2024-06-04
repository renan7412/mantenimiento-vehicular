package com.mantenimiento.vehicular.exceptions;

public class DatosFaltantesException extends RuntimeException {
    public DatosFaltantesException(String message){
        super("Se necesita más información para registrar la solicitud.");
    }
}
