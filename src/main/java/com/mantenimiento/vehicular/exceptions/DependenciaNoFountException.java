package com.mantenimiento.vehicular.exceptions;


public class DependenciaNoFountException extends RuntimeException{
    public DependenciaNoFountException(){
        super("No se localizo la dependencia por Id");

    }
}
