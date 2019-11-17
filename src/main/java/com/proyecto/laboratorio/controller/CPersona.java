package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Service.PersonaService;
import com.proyecto.laboratorio.model.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CPersona {

    @Autowired
    PersonaService personaService;

    @GetMapping({"/tableBeneficiario"})
    public String tableBeneficiario(Model model) {
        model.addAttribute("personaList",personaService.getAllPersonas());
        return"tableBeneficiario";
    }


}
