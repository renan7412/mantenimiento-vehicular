package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.EstadoSolicitud;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class SolicitudMovilizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaSlicitud;
    private Date fechaMovilizacion;
    private Date fechaLlegada;
    private Time horaSalida;
    private Time horaLlegada;
    private String motivo;
    private String ruta;
    private int numeroPersonas;

    @ElementCollection
    private List<String> nombresPersonas;

    @ManyToOne
    private Policia solicitante;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

}
