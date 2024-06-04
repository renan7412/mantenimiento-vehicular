package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.model.Vehiculo;
import com.mantenimiento.vehicular.service.RecepcionRegistroMantenimientoPreventivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
public class RecepcionRegistroMantenimientoPreventivoControllers {

    @Autowired
    private RecepcionRegistroMantenimientoPreventivoService recepcionRegistroMantenimientoPreventivoService;

    public Vehiculo solicitarVehiculo(@PathVariable Long idVehiculo) {
        return recepcionRegistroMantenimientoPreventivoService.solicitarVehiculo(idVehiculo);
    }

    @PostMapping("/vehiculo")
    public Vehiculo ingresarDatosVehiculo(@RequestBody Vehiculo vehiculo) {
        return recepcionRegistroMantenimientoPreventivoService.ingresarDatosVehiculo(vehiculo);
    }

    @PostMapping("/imagen")
    public String ingresarImagen(@RequestParam("file") MultipartFile file) {
        return recepcionRegistroMantenimientoPreventivoService.IngresarImagen(file);
    }

    @PutMapping("/editar/{id}")
    public SolicitudMantenimientoPreventivo editarMantenimiento
            (@PathVariable Long id, @RequestBody SolicitudMantenimientoPreventivo nuevosDatos) {
        return recepcionRegistroMantenimientoPreventivoService
                .editarSolicitudMantenimientoPreventivo(id, nuevosDatos);
    }

    @GetMapping("/gusrdar")
    public SolicitudMantenimientoPreventivo guardarMantenimiento
            (@RequestBody SolicitudMantenimientoPreventivo solicitudMantenimientoPreventivo){
        return recepcionRegistroMantenimientoPreventivoService
                .guardarMantenimiento(solicitudMantenimientoPreventivo);
    }

    @GetMapping("/buscar/mantenimiento_Por_Vehiculo")
    public List<SolicitudMantenimientoPreventivo> BuscarSolicitudMantenimientoPreventivoPorVehiculo
            (@PathVariable Long vehiculoId){
        return recepcionRegistroMantenimientoPreventivoService.buscarMantenimientoPorVehiculo(vehiculoId);
    }
    /*
    @GetMapping("/generar/{id}")
    public void generarReportesDeMantenimientoPreventivoPorId(@PathVariable Long id) {
        return recepcionRegistroMantenimientoPreventivoService
                .generarReportesDeMantenimientoPreventivoPorId(Long, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarMantenimientoPreventivo(@PathVariable Long id) {
        return recepcionRegistroMantenimientoPreventivoService.eliminarMantenimnientoPreventivo(Long,id);
    }
    */
}
