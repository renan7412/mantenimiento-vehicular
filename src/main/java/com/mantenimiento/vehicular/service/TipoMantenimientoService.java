package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import com.mantenimiento.vehicular.model.RecepcionRegistroMantenimientoPreventivo;
import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.repository.TipoMantenimientoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoMantenimientoService {

    // private TipoMantenimientoRepository tipoMantenimientoRepository;

    public GenerarOrdenTrabajo CrearOrdenTrabajo(SolicitudMantenimientoPreventivo solicitud) {
        RecepcionRegistroMantenimientoPreventivo registro = new RecepcionRegistroMantenimientoPreventivo(solicitud);
        return new GenerarOrdenTrabajo();
    }
}
