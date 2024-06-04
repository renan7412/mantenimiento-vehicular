package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.exceptions.DatosFaltantesException;
import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.exceptions.SolicitudNotFoundException;
import com.mantenimiento.vehicular.model.Vehiculo;
import com.mantenimiento.vehicular.repository.SolicitudMantenimientoPreventivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudMantenimientoPreventivoService {

    @Autowired
    private SolicitudMantenimientoPreventivoRepository solicitudMantenimientoPreventivoRepository;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private DependenciaService dependenciaService;

        // Método con el cual se crea una solicitud de mantenimiento preventivo

    public SolicitudMantenimientoPreventivo crearSolicitud(SolicitudMantenimientoPreventivo solicitud){
        //  Verificar si el vehículo esta asociado al usuario

        Optional<Vehiculo> vehiculo = vehiculoService.buscarVehiculoPorResponsable(solicitud.getNombreResponsableVehiculo());

        if (vehiculo.isPresent()) {
            solicitud.setVehiculo(vehiculo.get());
        } else {
            // Si el vehículo no está asociado, solicitar información de vehículo y dependencia
            // (aquí puedes implementar la lógica para solicitar estos datos al usuario)
            // Por ejemplo, puedes lanzar una excepción o devolver un estado especial indicando que se necesitan más datos
            throw new DatosFaltantesException("Se necesita más información para registrar la solicitud.");
        }

        // Guardar la solicitud en la base de datos
        return solicitudMantenimientoPreventivoRepository.save(solicitud);
    }

    // Método para obtener todas las solicitudes de mantenimiento preventivo
    public List<SolicitudMantenimientoPreventivo> obtenerTodasSolicitudes() {
        return solicitudMantenimientoPreventivoRepository.findAll();
    }

    // Método para obtener una solicitud de mantenimiento preventivo por ID
    public Optional<SolicitudMantenimientoPreventivo> obtenerSolicitudPorId(Long id) {
        return solicitudMantenimientoPreventivoRepository.findById(id);
    }

    // Método para actualizar una solicitud de mantenimiento preventivo
    public SolicitudMantenimientoPreventivo actualizarSolicitud(Long id, SolicitudMantenimientoPreventivo solicitudActualizada) {
        // Verificar si la solicitud existe
        Optional<SolicitudMantenimientoPreventivo> solicitudExistente = solicitudMantenimientoPreventivoRepository.findById(id);
        if (solicitudExistente.isPresent()) {
            SolicitudMantenimientoPreventivo solicitud = solicitudExistente.get();
            // Actualizar los campos necesarios
            solicitud.getFechaSolicitudMantenimiento();

            // Puedes continuar actualizando otros campos según sea necesario

            // Guardar y retornar la solicitud actualizada
            return solicitudMantenimientoPreventivoRepository.save(solicitud);
        } else {
            // Manejo de error si la solicitud no existe
            throw new SolicitudNotFoundException("No se encontró ninguna solicitud con ID: " + id);
        }
    }

    // Método para eliminar una solicitud de mantenimiento preventivo
    public void eliminarSolicitud(Long id) {
        solicitudMantenimientoPreventivoRepository.deleteById(id);
    }

}
