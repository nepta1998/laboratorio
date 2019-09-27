package com.proyecto.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CSolicitud {
    @GetMapping({"/tableRequest"})
    public String tableRequest() {
        return"tableRequest";
    }

    @GetMapping({"/tableBeneficiario"})
    public String tableBeneficiario() {
        return"tableBeneficiario";
    }

    @GetMapping({"/formRequest"})
    public String formRequest() {
        return"formRequest";
    }

}

