package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Repository.EmpleadoRepository;
import com.proyecto.laboratorio.Repository.FundacionRepository;
import com.proyecto.laboratorio.Service.EmpleadoService;
import com.proyecto.laboratorio.Service.FundacionService;
import com.proyecto.laboratorio.model.entity.Fundacion;
import com.proyecto.laboratorio.model.entity.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.proyecto.laboratorio.model.entity.Empleado;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CEmpleado {

    /*@GetMapping({"/formUser"})
    public String formUser() {
        return"formUser";
    }*/
    @Autowired
    FundacionService fundacionService;

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping({"/formUser"})
    public String formUser( Model model) {
        model.addAttribute("empleado", new Empleado());
        return "formEmployee";
    }

    @PostMapping({"/formUser"})
    public String createServicio(@Valid @ModelAttribute("fundacionForm") Empleado empleado, BindingResult result, ModelMap model,
                                 @RequestParam(value = "fundacion")Long fundacion,
                                 @RequestParam(value = "tipCed")String tipCed,
                                 @RequestParam(value = "ced")String ced,
                                 @RequestParam(value = "codTlf")String codTlf,
                                 @RequestParam(value = "telefono")String telefono)
    {
        System.out.println(fundacion);
        System.out.println(tipCed);
        System.out.println(ced);
        System.out.println(codTlf);
        System.out.println(telefono);
        System.out.println(empleado.toString());
            try {
                String cedula=tipCed+"-"+ced;
                String telefono1=codTlf+"-"+telefono;
                Fundacion fundacion1=fundacionService.getFundacionById(fundacion);
                empleado.setFundacion(fundacion1);
                empleado.setCedula(cedula);
                empleado.setTelefono(telefono1);
                empleadoService.createEmpleado(empleado);
                model.addAttribute("empleado", new Empleado());
                model.addAttribute("exitoMessage","registro exitoso");
            } catch (Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                model.addAttribute("fundacion1",fundacion);
                model.addAttribute("tipCedula",tipCed);
                model.addAttribute("cedula",ced);
                model.addAttribute("codigoTlf",codTlf);
                model.addAttribute("telefono1",telefono);
                model.addAttribute("empleado", empleado);

            }
        //model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        return"formEmployee";
    }
}
