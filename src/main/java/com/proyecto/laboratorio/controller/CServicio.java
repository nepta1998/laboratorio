package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Service.ServicioService;
import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CServicio {

    @Autowired
    ServicioService servicioService;

    @GetMapping({"/tableService"})
    public String tableService(Model model) {
        model.addAttribute("servicioList",servicioService.getAllServicios());
        return"tableService";
    }

    @GetMapping({"/formService"})
    public String formService(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("listTab","active");
        return"formService";
    }

    /*@PostMapping({"/formService"})
    public String createServicio(@Valid @ModelAttribute("servicioForm")Servicio servicio, BindingResult result, ModelMap model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("servicio", servicio);
        }
        return"formService";
    }*/
}
