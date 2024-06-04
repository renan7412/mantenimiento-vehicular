package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.Policia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliciaRepository extends JpaRepository<Policia, Long> {
}
