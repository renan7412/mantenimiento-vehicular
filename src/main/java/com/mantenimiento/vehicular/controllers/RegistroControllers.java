package com.mantenimiento.vehicular.controllers;

import com.mantenimiento.vehicular.model.Usuario;
import com.mantenimiento.vehicular.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistroControllers {

    @Autowired
     private UsuarioService usuarioService;

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        // Añadir un objeto usuario vacío para el formulario
        model.addAttribute("user", new UsuarioControllers());
        return "registro"; // nombre de la plantilla Thymeleaf para la página de registro
    }

    @PostMapping("/registro")
    public String registerUser(@ModelAttribute("user") Usuario usuarios, Model model) {
        // Validar datos de registro
        if (usuarioService.findByUsername(usuarios.getUsername()) != null) {
            model.addAttribute("error", "El nombre de usuario ya está en uso.");
            return "registro";
        }
        if (!usuarios.getPassword().equals(usuarios.getConfirmPassword())) {    /* getconfirmPassword */
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "registro";
        }

        // Guardar el nuevo usuario
        usuarios.setPassword(new BCryptPasswordEncoder().encode(usuarios.getPassword()));
        usuarioService.save(usuarios);

        return "redirect:/login?registrado"; // Redirige a la página de login con un mensaje de éxito
    }
}
