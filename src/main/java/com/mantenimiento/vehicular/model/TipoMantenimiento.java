package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.TipoVehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tipo_mantenimiento")
public abstract class TipoMantenimiento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract double calcularCosto(TipoVehiculo tipovehiculo);

}
