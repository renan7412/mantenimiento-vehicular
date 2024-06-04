package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.Dependencia;
import com.mantenimiento.vehicular.repository.DependenciaRepository;
import com.mantenimiento.vehicular.service.DependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencia")
public class DependenciasControllers {


    @Autowired
    private DependenciaService dependenciaService;
    @Autowired
    private DependenciaRepository dependenciaRepository;

    //Endpoint mediante el cual se obtiene las dependencias de bd
    @GetMapping
    public List<Dependencia> getDependencias(){
        List<Dependencia> dependencia = dependenciaRepository.findAll();
        return dependencia;
    }

    //Endpoint para la busqueda de las dependencias por pro, dis, parr, cir, subcir
    @GetMapping("/buscar")
    public List<Dependencia> buscarDependencias(
            @RequestParam(required = false) String provincia,
            @RequestParam(required = false) String distrito,
            @RequestParam(required = false) String parroquia,
            @RequestParam(required = false) String circuito,
            @RequestParam(required = false) String subcircuito) {
        return dependenciaService.buscarTodasDependencias(provincia,distrito,parroquia,circuito,subcircuito);
    }

    //Metodo para modificar la dependencia por su Id
    @PutMapping("/{id}")
    public Dependencia modificarDependencias(@PathVariable Long id, @RequestBody Dependencia dependenciaModificada){
        return dependenciaService.modificarDependencia(id, dependenciaModificada);

    }

    //Método para eliminar un dependencia por su ID
    @DeleteMapping("/{id}")
    public void eliminarDependencia(@PathVariable Long id){

        dependenciaService.eliminarDependencia(id);
    }
}
