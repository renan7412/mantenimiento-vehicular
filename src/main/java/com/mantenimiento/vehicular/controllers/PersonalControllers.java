package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.Personal;
import com.mantenimiento.vehicular.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalControllers {
    @Autowired
    PersonalService personalService;

    @GetMapping("/personal")
    private List<Personal> verPersonal(){
        return personalService.VerPersonal();
    }

    @PostMapping("/personal")
    private void crearYactualizarPersonal(@RequestBody Personal personal){
        personalService.crearPersonal(personal);
    }

    @DeleteMapping("/personal/{id}")
    private void eliminarPersonal(@PathVariable("id") Long id){
        personalService.eliminarPersonal(id);

    }

    @PutMapping("/personal")
    private void editarPersonal(@RequestParam Long id){
        personalService.eliminarPersonal(id);

    }

}
