package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.TipoVehiculo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mantenimiento2")
public class Mantenimiento2 extends TipoMantenimiento{
    private final double costoBase = 60.00;
    private final double reduccionMoto = 15.00;

    @Override
    public double calcularCosto(TipoVehiculo tipoVehiculo){
        if (tipoVehiculo == TipoVehiculo.MOTOCICLETA){
            return costoBase - reduccionMoto;
        }
        return costoBase;

    }
}
