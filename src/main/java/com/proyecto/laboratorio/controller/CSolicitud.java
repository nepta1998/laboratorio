package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Service.ServicioService;
import com.proyecto.laboratorio.model.entity.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CSolicitud {

    @Autowired
    ServicioService servicioService;

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
        model.addAttribute("servicioList",servicioService.getAllServicios());
        return"formRequest";
    }
    @GetMapping({"/formRequest1"})
    public String formRequest1(@Valid @ModelAttribute("solicitudForm")Solicitud solicitud, ModelMap model, @RequestParam(value = "serv")Long serv) throws Exception {

        System.out.println(solicitud.getPrioridad());

        model.addAttribute("servicioList1", servicioService.getServicioById(serv));
        model.addAttribute("servicioList",servicioService.getAllServicios());
        model.addAttribute("solicitud", solicitud);
        return"formRequest";
    }


}

