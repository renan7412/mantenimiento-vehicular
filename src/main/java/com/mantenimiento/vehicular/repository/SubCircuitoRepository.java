package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.SubCircuito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCircuitoRepository extends JpaRepository<SubCircuito, Long> {
}
