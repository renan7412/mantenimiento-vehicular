package com.mantenimiento.vehicular.exceptions;

public class SolicitudNotFoundException extends RuntimeException {
    public SolicitudNotFoundException(String message){
        super("No se encontró ninguna solicitud con ID:");

    }
}
