package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.model.entity.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CPersona {

    @GetMapping({"/formUser"})
    public String formUser(Model model) {
        model.addAttribute("usuario", new Persona());
        return"formUser";
    }
}
