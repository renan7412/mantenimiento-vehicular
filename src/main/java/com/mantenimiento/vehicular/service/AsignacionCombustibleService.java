package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.controllers.AsignacionCombustibleControllers;
import com.mantenimiento.vehicular.model.AsignacionCombustible;
import com.mantenimiento.vehicular.repository.AsignacionCombustibleRepository;
import com.mantenimiento.vehicular.repository.LogisticaRepository;
import com.mantenimiento.vehicular.repository.PoliciaRepository;
import com.mantenimiento.vehicular.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionCombustibleService {

    @Autowired
    private AsignacionCombustibleRepository asignacionCombustibleRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private PoliciaRepository policiaRepository;

    @Autowired
    private LogisticaRepository logisticaRepository;

    @Autowired
    private AsignacionCombustibleControllers asignacionCombustibleControllers;

    public AsignacionCombustible crearAsignacionCombustible(AsignacionCombustible asignacionCombustible) {
        return asignacionCombustibleRepository.save(asignacionCombustible);
    }
}
