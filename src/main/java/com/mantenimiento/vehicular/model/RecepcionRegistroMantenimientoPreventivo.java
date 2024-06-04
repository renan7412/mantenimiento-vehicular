package com.mantenimiento.vehicular.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecepcionRegistroMantenimientoPreventivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private SolicitudMantenimientoPreventivo solicitud;

    public double obtenerCosto() {
        return solicitud.getTipoMantenimiento().calcularCosto(solicitud.getVehiculo().getTipoVehiculo());
    }

    public RecepcionRegistroMantenimientoPreventivo(SolicitudMantenimientoPreventivo solicitud) {
        this.solicitud = solicitud;

    }

    /*public void recibirSolicitud(SolicitudMantenimientoPreventivo solicitud) {
            // Encargado de logística selecciona el tipo de mantenimiento
        TipoMantenimiento tipoMantenimiento = TipoMantenimiento.MANTENIMIENTO_2;

            // Obtener el costo del mantenimiento seleccionado
        int costoMantenimiento = tipoMantenimiento.getCosto();

            // Realizar el registro del mantenimiento preventivo y asignar el costo
    }

    public void registroMantenimiento(SolicitudMantenimientoPreventivo solicitud) {
        // logica para registrar la solicitud de mantenimiento
    }*/


}
