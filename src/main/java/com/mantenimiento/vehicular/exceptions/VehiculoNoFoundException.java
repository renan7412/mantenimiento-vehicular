package com.mantenimiento.vehicular.exceptions;

public class VehiculoNoFoundException  extends RuntimeException {
    public VehiculoNoFoundException(Long id) {
        super("No se encontró el vehículo por id");

    }
    public VehiculoNoFoundException(String message) {
        super(message);

    }

}