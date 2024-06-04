package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.service.GenerarOrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenTrabajo")
public class GenerarOrdenTrabajoControllers {

    @Autowired
    private GenerarOrdenTrabajoService generarOrdenTrabajoService;

    @GetMapping("/mantenimiento")
    public List<SolicitudMantenimientoPreventivo> visualizarRegistroMantenimiento() {
        return generarOrdenTrabajoService.visualizarRegistroMantenimiento();
    }

    @GetMapping("/descargar")
    public List<GenerarOrdenTrabajo> descargarRegistroOrdenTrabajo(){
        return generarOrdenTrabajoService.descargarRegistroOrdenatrabajo();
    }

    @PostMapping("/finalizar/{id}")
    public GenerarOrdenTrabajo finalizarOrdenTrabajo(@PathVariable Long id){
        return generarOrdenTrabajoService.finalizarOrdenTrabajo(id);
    }

    @PutMapping("/editar/{id}")
    public GenerarOrdenTrabajo editarOrdenTrabajo(@PathVariable Long id, @RequestBody GenerarOrdenTrabajo nuevosDatos){
        return generarOrdenTrabajoService.editarOrdenTrabajo(id,nuevosDatos);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarOrdenTrabajo(@PathVariable Long id){
        generarOrdenTrabajoService.eliminarOrdenTrabajo(id);
    }

    @GetMapping("/imprimir/{id}")
    public void ImprimirOrdenTrabajo(@PathVariable Long id){
        generarOrdenTrabajoService.imprimirOrdenTrabajo(id);
    }
}
