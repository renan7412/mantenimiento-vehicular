package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.GenerarOrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerarOrdenTrabajoRepository extends JpaRepository<GenerarOrdenTrabajo, Long> {
}
