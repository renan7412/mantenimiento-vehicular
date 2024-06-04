package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flota_vehicular")
public class Flota_Vehicular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String monbre;

    @OneToMany(mappedBy = "flota")
    private List<Vehiculo> vehiculos;

    //@Enu(EnumType.ORDINAL)
    @Column(name = "tipoVehículo")
    public Enum tipoVehiculo;

    public int placa;

    public String chasis;


}
