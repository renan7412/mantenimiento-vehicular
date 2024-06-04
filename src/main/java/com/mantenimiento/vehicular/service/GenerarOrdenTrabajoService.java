package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.repository.GenerarOrdenTrabajoRepository;
import com.mantenimiento.vehicular.repository.SolicitudMantenimientoPreventivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenerarOrdenTrabajoService {

    @Autowired
    private GenerarOrdenTrabajoRepository generarOrdenTrabajoRepository;

    @Autowired
    private SolicitudMantenimientoPreventivoRepository solicitudMantenimientoPreventivoRepository;

    public List<SolicitudMantenimientoPreventivo> visualizarRegistroMantenimiento(){
        return solicitudMantenimientoPreventivoRepository.findAll();
    }

    public List<GenerarOrdenTrabajo> descargarRegistroOrdenatrabajo(){
        return generarOrdenTrabajoRepository.findAll();
    }

    public GenerarOrdenTrabajo finalizarOrdenTrabajo(Long id) {
        Optional<GenerarOrdenTrabajo> generarOrdenTrabajoOptional = generarOrdenTrabajoRepository.findById(id);

        if (generarOrdenTrabajoOptional.isPresent()){
            GenerarOrdenTrabajo generarOrdenTrabajo = generarOrdenTrabajoOptional.get();
            generarOrdenTrabajo.setEstado("Finalizado");
            return generarOrdenTrabajoRepository.save(generarOrdenTrabajo);

        } else {
            return null;
        }
    }
    public GenerarOrdenTrabajo editarOrdenTrabajo(Long id, GenerarOrdenTrabajo nuevosDatos){
        Optional<GenerarOrdenTrabajo> generarOrdenTrabajoOptional = generarOrdenTrabajoRepository.findById(id);
        if (generarOrdenTrabajoOptional.isPresent()){
            GenerarOrdenTrabajo generarOrdenTrabajo = generarOrdenTrabajoOptional.get();
            generarOrdenTrabajo.setObservaciones(nuevosDatos.getObservaciones());
            return generarOrdenTrabajoRepository.save(generarOrdenTrabajo);
        } else {
            return null;
        }
    }

        // Método para eliminar si se desea la orden de tabajo
    public void eliminarOrdenTrabajo(Long id) {
        generarOrdenTrabajoRepository.deleteById(id);
    }
        // Método con el cual se podrá imprimir una orden de trabajo
    public void imprimirOrdenTrabajo(Long id) {
        // Logica de impresión implementar aquí
    }
}
