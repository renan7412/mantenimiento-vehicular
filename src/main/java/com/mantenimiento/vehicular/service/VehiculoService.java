package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.SubCircuito;
import com.mantenimiento.vehicular.model.Vehiculo;
import com.mantenimiento.vehicular.exceptions.VehiculoNoFoundException;
import com.mantenimiento.vehicular.repository.SubCircuitoRepository;
import com.mantenimiento.vehicular.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;  // Asignación de dependencias

    @Autowired
    private SubCircuitoRepository subCircuitoRepository;

    public void asignarVehiculoSubCircuito(Long subCircuitoId, Long vehiculoId){
            // Obtener verhiculo y subCircuito
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId).orElse(null);
        SubCircuito subCircuito = subCircuitoRepository.findById(subCircuitoId).orElse(null);

        if (vehiculo != null && subCircuito != null) {
            vehiculo.setSubCircuito(subCircuito);
            vehiculoRepository.save(vehiculo);

        } else {
            throw new VehiculoNoFoundException("No se encontro vehículo alguno con ID: " + vehiculo);

        }

    }
    public void  crearYactualizarVehiculo (Vehiculo vehiculo){
        vehiculoRepository.save(vehiculo);
    }

    public List VerVehiculo (){
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.addAll(vehiculoRepository.findAll());
        return vehiculos;

    }

    public void eliminarVehiculo (long id){
        vehiculoRepository.deleteById(id);
    }

        // Método para buscar el vehículo por el responsable
    public Optional<Vehiculo> buscarVehiculoPorResponsable(String responsableVehiculo) {
        return vehiculoRepository.findByResponsableVehiculo(responsableVehiculo);
    }

}
