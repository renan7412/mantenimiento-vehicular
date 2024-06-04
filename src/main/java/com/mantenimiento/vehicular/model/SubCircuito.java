package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "subcircuito")
public class SubCircuito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcircuitoId;

    @ManyToOne
    @JoinColumn(name = "dependencia_id")
    private Dependencia dependencia;

    @Column(name = "name_subCircuito")
    private String subcircuitoName;

    @Column(name = "cod_subCircuito")
    private String codigo;

    @OneToOne
    @JoinColumn(name = "personal")
    private Personal personal;

}
