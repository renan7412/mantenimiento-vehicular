package com.mantenimiento.vehicular.controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam (value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("errror", "Usuario y/o contraseña invalidos");
        }

        if (logout != null) {
            model.addAttribute("logout", "Ha cerrado sesión de forma correcta.");
        }

        return "login";  // Nomkbre de la plantilla thymeleaf

    }
}

