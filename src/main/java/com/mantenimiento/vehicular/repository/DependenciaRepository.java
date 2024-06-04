package com.mantenimiento.vehicular.repository;


import com.mantenimiento.vehicular.model.Dependencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Long> {
    List<Dependencia> findByProvinciaAndDistritoAndParroquiaAndCircuitoAndSubcircuito(
            String provincia,
            String distrito,
            String parroquia,
            String circuito,
            String subcircuito
    );

}
