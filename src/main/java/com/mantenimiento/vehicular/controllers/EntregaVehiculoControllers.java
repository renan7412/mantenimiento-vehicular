package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import com.mantenimiento.vehicular.service.EntregaVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entrega_vehiculo")
public class EntregaVehiculoControllers {

    @Autowired
    private EntregaVehiculoService entregaVehiculoService;

    @GetMapping("/imprimir/{id}")
    public String imprimirInforme(@PathVariable Long id){
        return entregaVehiculoService.imprimirInforme(id);

    }

    @PutMapping("/editar/{id}")
    public GenerarOrdenTrabajo editarOrdenTrabajo(@PathVariable Long id, @RequestBody GenerarOrdenTrabajo nuevosDatos){
        return entregaVehiculoService.editarOrdenTrabajo(id, nuevosDatos);
    }

    public void eliminarOrdenTrabajo(@PathVariable Long id) {

        entregaVehiculoService.eliminarOrdenTrabajo(id);
    }

}
