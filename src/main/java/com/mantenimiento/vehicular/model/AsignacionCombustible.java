package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignacion_Combustuble")
public class AsignacionCombustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_asignacion")
    private Date fechaAsignacion;

    @Column(name = "cantidad_litros")
    private Double cantidadLitros;

    @Column(name = "costo_total")
    private Double costoTotal;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "responsable_Vehiculo_id")
    private Policia ResponsableVehiculo;

    @ManyToOne
    @JoinColumn(name = "logistica_id")
    private Logistica IdLogistica;

}
