package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    private String lastName;
    private String rango;
    private String dependencia;
    private String vehiculo;

    @OneToOne(mappedBy = "responsable")
    private Vehiculo responsableVehiculo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private EnumType rango_tipo;


}
