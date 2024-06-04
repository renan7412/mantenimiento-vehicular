package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.SolicitudMovilizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudMovilizacionRepository extends JpaRepository<SolicitudMovilizacion, Long> {

}
