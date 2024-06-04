package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.Dependencia;
import com.mantenimiento.vehicular.exceptions.DependenciaNoFountException;
import com.mantenimiento.vehicular.repository.DependenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenciaService {

    @Autowired
    private DependenciaRepository dependenciaRepository;

    //Metodo con el cual se obtiene las dependencias de la base de datos y se almacena las dependencias en una lista y devuelve la lista de dependencias    y devuelve como lista de dependencias
    public List<Dependencia> buscarTodasDependencias(String provincia, String distrito, String parroquia, String circuito, String subcircuito ){
        return dependenciaRepository.findByProvinciaAndDistritoAndParroquiaAndCircuitoAndSubcircuito(
                provincia,distrito,parroquia, circuito,subcircuito);
    }

    //Metodo con el cual se modifica los datos de la dependencias
    public Dependencia modificarDependencia(Long id, Dependencia dependenciaModificada) {
        Optional<Dependencia> dependenciasOptional = dependenciaRepository.findById(id);

        if (dependenciasOptional.isPresent()) {
            Dependencia dependencia = dependenciasOptional.get();

            //Se modifica los campos necesarios
            dependencia.setProvincia(dependenciaModificada.getProvincia());
            dependencia.setNombreDistrito(dependenciaModificada.getNombreDistrito());
            dependencia.setParroquia(dependenciaModificada.getParroquia());
            dependencia.setNombreCircuito(dependenciaModificada.getNombreCircuito());
            dependencia.setNombreSubCircuito(dependenciaModificada.getNombreSubCircuito());

            //Se guardan los cambios en la bd con retorno
            return dependenciaRepository.save(dependencia);

        } else {
            //Funciona en el caso que no se encuentre la dependencia por el ID especificado
            throw new DependenciaNoFountException();
        }
    }

    public void eliminarDependencia(Long id) {
        dependenciaRepository.deleteById(id);

    }
}

