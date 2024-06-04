package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import com.mantenimiento.vehicular.repository.GenerarOrdenTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntregaVehiculoService {

    @Autowired
    private GenerarOrdenTrabajoRepository generarOrdenTrabajoRepository;

        // Método con el cual se imprime la oren de trabajo
    public String imprimirInforme(Long id) {
        Optional<GenerarOrdenTrabajo> generarOrdenTrabajoOptional = generarOrdenTrabajoRepository.findById(id);

        if (generarOrdenTrabajoOptional.isPresent()) {
            GenerarOrdenTrabajo generarOrdenTrabajo = generarOrdenTrabajoOptional.get();
            // Logica para generar el informe-implementar
            return generarInforme(generarOrdenTrabajo);   // Revisar
        } else {
            return "Orden de trabajo";
        }
    }
        // Método para generar el informe
    private String generarInforme(GenerarOrdenTrabajo generarOrdenTrabajo) {
            // Logica para generar el informe-implements
            // Crear archivo Pdf con el detalle del mantenimiento o cadena de texto
        StringBuilder informe = new StringBuilder();
        informe.append("Informe de la orden de trabajo");
        informe.append("Vehículo: ").append(generarOrdenTrabajo.getVehiculo().getMarca())
                .append(" ").append(generarOrdenTrabajo.getVehiculo().getModelo()).append("\n");
        informe.append("Placa: ").append(generarOrdenTrabajo.getVehiculo().getChasis()).append("\n");
        informe.append("Fecha de Finalización: ").append(generarOrdenTrabajo.getFechaFinalizacion()).append("\n");
        informe.append("Estado: ").append(generarOrdenTrabajo.getEstado()).append("\n");
        informe.append("Mantenimientos Realizados:\n");
        generarOrdenTrabajo.getMantenimientoPreventivos().forEach(mantenimiento -> {
            informe.append("- ").append(mantenimiento.getVehiculo()).append("\n");
        });
        return informe.toString();
    }

        // Métod con el cual se edita la orden de trabajo para realizar cualquier cambio
    public GenerarOrdenTrabajo editarOrdenTrabajo(Long id, GenerarOrdenTrabajo nuevosDatos) {
        Optional<GenerarOrdenTrabajo> generarOrdenTrabajoOptional = generarOrdenTrabajoRepository.findById(id);

        if (generarOrdenTrabajoOptional.isPresent()) {
            GenerarOrdenTrabajo generarOrdenTrabajo = generarOrdenTrabajoOptional.get();
            generarOrdenTrabajo.setFechaFinalizacion(nuevosDatos.getFechaFinalizacion());
            generarOrdenTrabajo.setEstado(nuevosDatos.getEstado());
            generarOrdenTrabajo.setMantenimientoPreventivos(nuevosDatos.getMantenimientoPreventivos());

            return generarOrdenTrabajoRepository.save(generarOrdenTrabajo);
        } else {
            return null;
        }
    }

        //  Método com el cual se puede realizar la eliminación de la orden de trabajo
    public void eliminarOrdenTrabajo(Long id) {
        generarOrdenTrabajoRepository.deleteById(id);
    }


}
