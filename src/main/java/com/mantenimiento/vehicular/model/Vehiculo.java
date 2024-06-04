package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.TipoVehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.lang.model.element.Name;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flota_id")
    private Flota_Vehicular flota;

    private String marca;
    private String modelo;
    private String color;

    @OneToOne
    @JoinColumn(name = "placa")
    private Vehiculo numeroPlaca;

    private String motor;

    @OneToOne
    @JoinColumn(name = "chasis")
    private Vehiculo chasis;

    @OneToOne
    @JoinColumn(name = "responsable_id")
    private Personal responsable;

    private String cilindraje;
    private String tipo;
    private String capacidadCarga;
    private String capacidadPasageros;
    private String numeroMatricula;
    private double kilometrajeInicio;

    @ManyToOne
    @JoinTable(name = "distrito_id")
    private Distrito distrito;

    @OneToOne
    private SubCircuito subCircuito;

    @OneToMany(mappedBy = "vehiculo")
    private List<AsignacionCombustible> asignacionesCombustibles;

    private TipoVehiculo tipoVehiculo;
    public Vehiculo(TipoVehiculo tipoVehiculo){
        this.tipoVehiculo = tipoVehiculo;
    }


}