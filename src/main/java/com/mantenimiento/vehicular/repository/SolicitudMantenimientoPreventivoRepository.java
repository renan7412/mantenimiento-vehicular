package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.SolicitudMantenimientoPreventivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudMantenimientoPreventivoRepository extends JpaRepository<SolicitudMantenimientoPreventivo, Long> {
}
