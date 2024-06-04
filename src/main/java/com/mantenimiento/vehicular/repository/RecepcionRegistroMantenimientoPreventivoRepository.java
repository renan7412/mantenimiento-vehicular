package com.mantenimiento.vehicular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepcionRegistroMantenimientoPreventivoRepository extends
        JpaRepository<RecepcionRegistroMantenimientoPreventivoRepository, Long> {

}
