package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Servicio {
    @GetMapping({"/tableService"})
    public String tableService() {
        return"tableService";
    }
}
