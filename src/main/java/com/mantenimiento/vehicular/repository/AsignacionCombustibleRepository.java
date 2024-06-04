package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.AsignacionCombustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionCombustibleRepository extends JpaRepository<AsignacionCombustible, Long> {

}
