package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Policia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String cedula;
    private String celular;
    private String rango;
    private String circuito;
    private String subcircuito;
    private String distrito;

    @OneToMany(mappedBy = "responsableVehiculo")
    private List<AsignacionCombustible> asignacionCombustible;

}
