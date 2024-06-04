package com.mantenimiento.vehicular.model;

import com.mantenimiento.vehicular.Enum.TipoVehiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "solicitud_mantenimiento_preventivo")
public class SolicitudMantenimientoPreventivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudMantenimiento;

    //private Long idVehiculo;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitudMantenimiento;

    @ManyToOne
    @JoinColumn(name = "responsableVehiculo_id")
    private ResponsableVehiculo responsableVehiculo;

    @ManyToOne
    @JoinColumn(name = "ordenTrabajo_id")
    private GenerarOrdenTrabajo ordenTrabajo;

    private String estadoActual;
    private String dependencia;
    private String tipoVehiculo;
    private String nombreResponsableVehiculo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vehiculo")
    private TipoVehiculo tipovehiculo;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToOne
    @JoinColumn(name = "tipo_mantenimiento_id")
    private TipoMantenimiento tipoMantenimiento;

}
