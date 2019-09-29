package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.proyecto.laboratorio.model.entity.Empleado;

@Controller
public class CEmpleado {

    /*@GetMapping({"/formUser"})
    public String formUser() {
        return"formUser";
    }*/

    @GetMapping({"/formUser"})
    public String formUser(Model model) {
        model.addAttribute("usuario", new Empleado());
        return "formEmployee";
    }
}
