package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "responsable_vehiculo")
public class ResponsableVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    private String dependencia;
    private String tipoVehiculo;
    private String marca;

    @OneToMany(mappedBy = "responsable")
    private List<SolicitudMantenimientoPreventivo> solicitudes;
}
