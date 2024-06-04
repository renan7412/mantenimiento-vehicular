package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.exceptions.SolicitudNotFoundException;
import com.mantenimiento.vehicular.service.SolicitudMantenimientoPreventivoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes-mantenimiento-preventivo")
public class SolicitudMnatenimientoPreventivoControllers {

    private SolicitudMantenimientoPreventivoService solicitudMantenimientoPreventivoService;

    // Método para realizar una nueva petición de solicitud
    @PostMapping("/crear")
    public SolicitudMantenimientoPreventivo crearSolicitud(@RequestBody SolicitudMantenimientoPreventivo solicitud) {
        return solicitudMantenimientoPreventivoService.crearSolicitud(solicitud);
    }

    // Método para todas las solicitudes de matenimiento preventivo
    @GetMapping("/todas")
    public List<SolicitudMantenimientoPreventivo> obtenerTodasSolicitudesPreventivos() {
        return solicitudMantenimientoPreventivoService.obtenerTodasSolicitudes();
    }

    // Método para obtener una solicitud de mantenimiento preventivo por id
    @GetMapping("/{id}")
    public SolicitudMantenimientoPreventivo obtenerSolicitudPorId(@PathVariable Long id) {
        return solicitudMantenimientoPreventivoService.obtenerSolicitudPorId(id)
                .orElseThrow(() -> new SolicitudNotFoundException("No se encontro nimguna solicitud por ID:" + id));
    }

    // Método para actualizar una solicitud de mantenimiento preventivo
    @PutMapping("/{id}")
    public SolicitudMantenimientoPreventivo actualizarSolicitud(@PathVariable Long id, @RequestBody SolicitudMantenimientoPreventivo solicitudActualizada) {
        return solicitudMantenimientoPreventivoService.actualizarSolicitud(id, solicitudActualizada);
    }

    // Método para eliminar una solicitud de mantenimiento preventivo
    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable Long id) {
        solicitudMantenimientoPreventivoService.eliminarSolicitud(id);
    }
}
