package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.TipoVehiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mantenimiento3")
public class Mantenimiento3 extends TipoMantenimiento{
    private final double costoBase = 180.00;

    @Override
    public double calcularCosto(TipoVehiculo tipoVehiculo){
        return costoBase;
    }
}
