package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CLogin {

   /* @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }*/

    /*@GetMapping({"/","/login"})
    public String mostrarLogin(Model model)
    {
        return "login";
    }*/
    @GetMapping({"/","/login"})
    public String index() {
        return "login";
    }
}
