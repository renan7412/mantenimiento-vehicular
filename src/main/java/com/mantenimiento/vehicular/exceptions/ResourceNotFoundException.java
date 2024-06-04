package com.mantenimiento.vehicular.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje) {
        super("Solicitud no encontrada");

    }

}
