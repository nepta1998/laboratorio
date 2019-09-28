package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Service.ServicioService;
import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @PostMapping({"/formService"})
    public String createServicio(@Valid @ModelAttribute("servicioForm")Servicio servicio, BindingResult result, ModelMap model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("servicio", servicio);
            model.addAttribute("listTab","active");
        }else {
            try {
                servicioService.createServicio(servicio);
                model.addAttribute("servicio", new Servicio());
                model.addAttribute("listTab","active");
            } catch (Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                model.addAttribute("servicio", servicio);
                model.addAttribute("listTab","active");
            }
        }
        model.addAttribute("servicioList",servicioService.getAllServicios());
        return"formService";
    }

    @GetMapping("/editServicio{id}")
    public String getEditServicio(Model model, @PathVariable(name="id")Long id) throws Exception
    {
        Servicio servicioEdit= servicioService.getServicioById(id);
        model.addAttribute("servicioList",servicioService.getAllServicios());
        model.addAttribute("servicio", servicioEdit);
        model.addAttribute("listTab","active");
        model.addAttribute("editMode","true");
        return"formService";
    }

    @PostMapping("/editServicio")
    public String postEditServicio(@Valid @ModelAttribute("servicioForm")Servicio servicio, BindingResult result, ModelMap model )
    {
        if(result.hasErrors())
        {
            model.addAttribute("servicio", servicio);
            model.addAttribute("listTab","active");
            model.addAttribute("editMode","true");
        }else {
            try {
                servicioService.updateServicio(servicio);
                model.addAttribute("servicio", new Servicio());
                model.addAttribute("listTab","active");
            } catch (Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                model.addAttribute("servicio", servicio);
                model.addAttribute("listTab","active");
                model.addAttribute("editMode","true");
            }
        }
        model.addAttribute("servicioList",servicioService.getAllServicios());
        return"formService";
    }
    @GetMapping("/deleteServicio{id}")
    public String deleteSercvicio(Model model, @PathVariable(name="id")Long id)
    {
        try {
            servicioService.deleteServicio(id);
        }catch (Exception e){
            model.addAttribute("listError",e.getMessage());
        }
        return tableService(model);
    }
}
