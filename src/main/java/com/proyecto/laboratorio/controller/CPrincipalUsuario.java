package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CPrincipalUsuario {

    @GetMapping({"/index"})
    public String index() {
        return"index";
    }

   /* @GetMapping({"/index"})
    public String showIndex(Model model) {
        return "index";
    }*/

   /* @GetMapping({"/tableFunDisc"})
    public String tableFunDisc() {
        return"tableFunDisc";
    }

    @GetMapping({"/tableFunMujer"})
    public String tableFunMujer() {
        return"tableFunMujer";
    }

    @GetMapping({"/tableFunNinnos"})
    public String tableFunNinnos() {
        return"tableFunNinnos";
    }*/
}
