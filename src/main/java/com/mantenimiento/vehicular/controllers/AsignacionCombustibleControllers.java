package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.AsignacionCombustible;
import com.mantenimiento.vehicular.service.AsignacionCombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignacionCombustible")
public class AsignacionCombustibleControllers {

    @Autowired
    private AsignacionCombustibleService asignacionCombustibleService;

    public ResponseEntity<AsignacionCombustible> crearAsignacionCombustible(@RequestBody AsignacionCombustible asignacionCombustible) {
        AsignacionCombustible nuevaAsignacion = asignacionCombustibleService.crearAsignacionCombustible(asignacionCombustible);
        return new ResponseEntity<>(nuevaAsignacion, HttpStatus.CREATED);

    }

}
