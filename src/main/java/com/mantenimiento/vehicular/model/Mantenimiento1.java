package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.TipoVehiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mantenimiento1")
public class Mantenimiento1 extends TipoMantenimiento{

    private final double costoBase = 43.59;

    @Override
    public double calcularCosto(TipoVehiculo tipoVehiculo) {
        return costoBase;
    }

}
