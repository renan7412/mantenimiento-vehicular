package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.Vehiculo;
import com.mantenimiento.vehicular.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VehiculoControllers {

    @Autowired
    VehiculoService vehiculoService;

    @GetMapping("/vehiculo")
    private List<Vehiculo> verVehiculo(){
        return vehiculoService.VerVehiculo();
    }

    @PostMapping("/vehículo")
    private void createVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.crearYactualizarVehiculo(vehiculo);
    }

    @DeleteMapping("/vehiculo/{id}")
    private void eliminarVehiculo(@PathVariable("id") Long id){
        vehiculoService.eliminarVehiculo(id);

    }

    @PutMapping("/vehiculo")
    private void editarVehiculo(@RequestBody Vehiculo vehiculo){
        vehiculoService.crearYactualizarVehiculo(vehiculo);
    }
}
