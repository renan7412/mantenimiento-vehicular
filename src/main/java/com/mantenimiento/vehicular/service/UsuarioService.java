package com.mantenimiento.vehicular.service;

import com.mantenimiento.vehicular.model.Usuario;
import com.mantenimiento.vehicular.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario findByUsername(String username) {
        return usuarioRepository.finBayUsername(username);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.finByEmail(email);
    }

    public void save(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public boolean checkUsuarioExists(String username, String email) {
        return findByUsername(username) != null || findByEmail(email) != null;
    }
}
