package com.mantenimiento.vehicular.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orden_trabajo")
public class GenerarOrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaCreacion;
    private String estado;   //  e.g., "En proceso", "finalizado"
    private String observaciones;
    private Date fechaFinalizacion;

    @ManyToOne
    private Vehiculo vehiculo;

    @Transient
    private SolicitudMantenimientoPreventivo solicitudMantenimientoPreventivo;

    @OneToMany(mappedBy = "ordenTrabajo")
    private List<SolicitudMantenimientoPreventivo> mantenimientoPreventivos;

    @Transient
    private RecepcionRegistroMantenimientoPreventivo registro;

    // Método con el que se calcula el coste del mantenimiiento, ademas se lo imprime a dicho costo
    public void procesarOrden(){
       double costo = registro.obtenerCosto();
       System.out.println("Costo del mantenimiento es: " + costo);
    }


    public void mostrarRegistros(List<RecepcionRegistroMantenimientoPreventivo> registros) {

    }

    public void descargarRegistros(List<RecepcionRegistroMantenimientoPreventivo> registros) {

    }

    public  void imprimirRegistros(List<RecepcionRegistroMantenimientoPreventivo> registros) {

    }

    public void finalizarRegistros(List<RecepcionRegistroMantenimientoPreventivo> registros) {

    }


}
