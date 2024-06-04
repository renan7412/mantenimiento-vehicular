package com.mantenimiento.vehicular.repository;

import com.mantenimiento.vehicular.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
UsuarioRepository extends JpaRepository<Usuario, Long> {
     Usuario finBayUsername(String username);
     Usuario finByEmail(String email);

}
