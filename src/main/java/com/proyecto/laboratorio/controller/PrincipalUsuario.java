package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalUsuario {

    @GetMapping({"/index"})
    public String index() {
        return"index";
    }
}
