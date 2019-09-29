package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.model.entity.Solicitud;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

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
    public String formRequest(Model model) {
        model.addAttribute("solicitud", new Solicitud());
        return"formRequest";
    }

}

