package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.TipoMantenimiento;
import com.mantenimiento.vehicular.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMantenimientoRepository extends JpaRepository<TipoMantenimiento, Long> {

}
