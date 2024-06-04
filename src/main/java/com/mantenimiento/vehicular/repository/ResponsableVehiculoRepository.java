package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.ResponsableVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableVehiculoRepository extends JpaRepository<ResponsableVehiculo, Long> {

}
