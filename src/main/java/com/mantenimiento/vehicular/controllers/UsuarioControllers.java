package com.mantenimiento.vehicular.controllers;
import com.mantenimiento.vehicular.model.Usuario;
import com.mantenimiento.vehicular.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControllers {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setUsername("Julio");
        usuario.setApellido("Jimenez");
        usuario.setEmail("julio@gmail.com");
        usuario.setTelefono("0978451268");
        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(004L);
        usuario.setUsername("Telmo");
        usuario.setApellido("Rodriguez");
        usuario.setEmail("trodriguez@gmail.com");
        usuario.setTelefono("0978451987");


        Usuario usuario2 = new Usuario();
        usuario2.setId(005L);
        usuario2.setUsername("Amanda");
        usuario2.setApellido("Aguiza");
        usuario2.setEmail("aaguiza@gmail.com");
        usuario2.setTelefono("0978451369");

        Usuario usuario3 = new Usuario();
        usuario3.setId(006l);
        usuario3.setUsername("Liliana");
        usuario3.setApellido("Vaca");
        usuario3.setEmail("lilianav@gmail.com");
        usuario3.setTelefono("0978455241");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
    }

    @RequestMapping(value = "usuario2/{id}")
    public Usuario editar(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setUsername("Irene");
        usuario.setApellido("Vargas");
        usuario.setEmail("ivargas12@gmail.com");
        usuario.setTelefono("0978432548");
        return usuario;
    }

    @RequestMapping(value = "usuario3/{id}")
    public Usuario eliminar(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setUsername("Julio");
        usuario.setApellido("Jimenez");
        usuario.setEmail("julio@gmail.com");
        usuario.setTelefono("0978451268");
        return usuario;
    }

    @RequestMapping(value = "usuario4/{id}")
    public Usuario buscar(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setUsername("Julio");
        usuario.setApellido("Jimenez");
        usuario.setEmail("julio@gmail.com");
        usuario.setTelefono("0978451268");
        return usuario;
    }

}
