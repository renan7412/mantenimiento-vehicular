package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.service.TipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mantenimiento")
public class TipoMantenimientoControllers {

    @Autowired
    private TipoMantenimientoService tipoMantenimientoService;

    @PostMapping("/solicitar")
    public String solicitarTipoMantenimiento(@RequestBody SolicitudMantenimientoPreventivo solicitud) {
        GenerarOrdenTrabajo ordenTrabajo = tipoMantenimientoService.CrearOrdenTrabajo(solicitud);
        ordenTrabajo.procesarOrden();
        return "Orden de trabajo procesada con exito";
    }
}
