package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CError {

    @GetMapping({"/403"})
    public String index() {
        return "403";
    }
}
