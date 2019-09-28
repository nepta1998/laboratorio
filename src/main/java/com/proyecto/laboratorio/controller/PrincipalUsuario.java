package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalUsuario {

    @GetMapping({"/indexgob"})
    public String index() {
        return"indexgob";
    }

    @GetMapping({"/tableFunDisc"})
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
    }

}
