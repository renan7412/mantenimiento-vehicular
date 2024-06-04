package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import com.mantenimiento.vehicular.model.Vehiculo;
import com.mantenimiento.vehicular.repository.RecepcionRegistroMantenimientoPreventivoRepository;
import com.mantenimiento.vehicular.repository.SolicitudMantenimientoPreventivoRepository;
import com.mantenimiento.vehicular.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

@Service
public class RecepcionRegistroMantenimientoPreventivoService {

    @Autowired
    private RecepcionRegistroMantenimientoPreventivoRepository recepcionRegistroMantenimientoPreventivoRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private SolicitudMantenimientoPreventivoRepository solicitudMantenimientoPreventivoRepository;

    public Vehiculo solicitarVehiculo(Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    public Vehiculo ingresarDatosVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public String IngresarImagen(MultipartFile imagen) {
        // Logica para guardar imagen y devolver la ruta o nombre del archivo
        return "ruta/imgen.jps";
    }

    public SolicitudMantenimientoPreventivo editarSolicitudMantenimientoPreventivo(Long id, SolicitudMantenimientoPreventivo nuevosDatos) {
        Optional<SolicitudMantenimientoPreventivo> solicitudMantenimientoPreventivoOptional = solicitudMantenimientoPreventivoRepository.findById(id);
        if (solicitudMantenimientoPreventivoOptional.isPresent()) {
            SolicitudMantenimientoPreventivo solicitudPreventivo = solicitudMantenimientoPreventivoOptional.get();
            solicitudPreventivo.setIdSolicitudMantenimiento(nuevosDatos.getIdSolicitudMantenimiento());
            solicitudPreventivo.setFechaSolicitudMantenimiento(nuevosDatos.getFechaSolicitudMantenimiento());
            solicitudPreventivo.setTipoMantenimiento(nuevosDatos.getTipoMantenimiento());
            return solicitudMantenimientoPreventivoRepository.save(solicitudPreventivo);
        } else {
            return null;
        }
    }

    public void eliminarMantenimnientoPreventivo(Long id) {
        recepcionRegistroMantenimientoPreventivoRepository.deleteById(id);
    }

    public List<SolicitudMantenimientoPreventivo> buscarMantenimientoPorVehiculo(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElse(null);
        if (vehiculo != null){
            return solicitudMantenimientoPreventivoRepository.findAll();
        } else {
            return null;
        }
    }

    public SolicitudMantenimientoPreventivo guardarMantenimiento(SolicitudMantenimientoPreventivo mantenimientoPreventivo){
        return solicitudMantenimientoPreventivoRepository.save(mantenimientoPreventivo);
    }

    public void generarReportesDeMantenimientoPreventivoPorId(Long id) {
        // Generamos la logica para los reportes de mantenimiennto

    }

}
