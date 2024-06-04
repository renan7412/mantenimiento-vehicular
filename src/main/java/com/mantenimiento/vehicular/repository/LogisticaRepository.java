package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.Logistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticaRepository extends JpaRepository<Logistica, Long> {
}
