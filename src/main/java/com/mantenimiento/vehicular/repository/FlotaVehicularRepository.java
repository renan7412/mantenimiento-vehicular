package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.Flota_Vehicular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlotaVehicularRepository extends JpaRepository<Flota_Vehicular, Long> {
    List<Flota_Vehicular> findByNumeroPlacaOrChasis(String placa, String chasis);
}
