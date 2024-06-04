package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.Enum.EstadoSolicitud;
import com.mantenimiento.vehicular.exceptions.ResourceNotFoundException;
import com.mantenimiento.vehicular.model.SolicitudMovilizacion;
import com.mantenimiento.vehicular.repository.PoliciaRepository;
import com.mantenimiento.vehicular.repository.SolicitudMovilizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudMovilizacionService {

    @Autowired
    private SolicitudMovilizacionRepository solicitudMovilizacionRepository;

    @Autowired
    private PoliciaRepository policiaRepository;


    public SolicitudMovilizacion crearSolicitud(SolicitudMovilizacion solicitud) {
        solicitud.setEstado(EstadoSolicitud.PENDIENTE);
        return solicitudMovilizacionRepository.save(solicitud);
    }

    public SolicitudMovilizacion aprobarSolicitud(Long solicitudId) {
        SolicitudMovilizacion solicitud = solicitudMovilizacionRepository.findById(solicitudId)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud no encontrada"));
        solicitud.setEstado(EstadoSolicitud.APROBADA);
        return solicitudMovilizacionRepository.save(solicitud);
    }
}
