package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.Dependencia;
import com.mantenimiento.vehicular.model.Personal;
import com.mantenimiento.vehicular.model.SubCircuito;
import com.mantenimiento.vehicular.repository.DependenciaRepository;
import com.mantenimiento.vehicular.repository.PersonalRepository;
import com.mantenimiento.vehicular.repository.SubCircuitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalService {

    @Autowired
    PersonalRepository personalRepository;

    @Autowired
    private DependenciaRepository dependenciaRepository;
    @Autowired
    private SubCircuitoRepository subCircuitoRepository;

    public void crearPersonal(Personal personal) {
        personalRepository.save(personal);
    }

    public List<Personal> VerPersonal() {
        List<Personal> personals = new ArrayList<>(); // Creamos una lista de las personas e instanciamos la lista
        personals.addAll(personalRepository.findAll());
        return personals;
    }

    public void eliminarPersonal (long id){
        personalRepository.deleteById(id);
    }

    public void asignarSubCircuitoAPersonal(Long persoanlID, Long subCircuitoID){

            //  Obtenemos el personal y el subCircuito
        Personal personal = personalRepository.findById(persoanlID).orElse(null);
        SubCircuito subCircuito = subCircuitoRepository.findById(subCircuitoID).orElse(null);

        if (personal != null && subCircuito != null) {
            // Obtenemos la dependencia del personal
            String dependencia = personal.getDependencia();
        } else {
            String dependencia =  "Con dependencia";
        }
    }

}
