package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Método para buscar el vehículo por su responsable

    Optional<Vehiculo> findByResponsableVehiculo(String responsableVehiculo);
}
