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
@Table(name = "dependencias")
public class Dependencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dependencia")
    private Long id;

    private String provincia;
    private int numDistritos;
    private String parroquia;
    private int codDistrito;
    private String nombreDistrito;
    private int numCircuito;
    private int codCircuito;
    private String nombreCircuito;
    private int numSubCircuito;
    private int codSubCircuito;
    private String nombreSubCircuito;

    @OneToMany(mappedBy = "dependencia")
    private List<SubCircuito> subCircuitos;

    @OneToMany(mappedBy = "dependencia")
    private List<Personal> personalList;

}
