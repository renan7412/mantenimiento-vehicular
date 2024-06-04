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
public class Logistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lojistica")
    private long id;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "dependencia_id")
    private Dependencia dependencias;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;


    private String mantenimiento;
    private String solicitudes;
    private String vinculacion;
    private String Recepción;
    private String estado;
    private String fecha;
    private String Registro;

    @OneToMany(mappedBy = "logistica")
    private List<AsignacionCombustible> asignacionesCombustible;
}
