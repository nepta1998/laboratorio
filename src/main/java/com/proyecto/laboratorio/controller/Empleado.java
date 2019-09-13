package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Empleado {

    @GetMapping({"/formUser"})
    public String formUser() {
        return"formUser";
    }
}
