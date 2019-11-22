package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Repository.EmpleadoRepository;
import com.proyecto.laboratorio.Repository.FundacionRepository;
import com.proyecto.laboratorio.Repository.RoleRepository;
import com.proyecto.laboratorio.Repository.UserRepository;
import com.proyecto.laboratorio.Service.EmpleadoService;
import com.proyecto.laboratorio.Service.FundacionService;
import com.proyecto.laboratorio.Service.UserService;
import com.proyecto.laboratorio.Service.UserServiceImpl;
import com.proyecto.laboratorio.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;


    @GetMapping({"/formUser"})
    public String formUser( Model model) {
        model.addAttribute("empleado", new Empleado());
        return "formEmployee";
    }

    @PostMapping({"/formUser"})
    public String createServicio(@Valid @ModelAttribute("fundacionForm") Empleado empleado, BindingResult result, ModelMap model,
                                 @RequestParam(value = "fundacion")Long fundacion)
    {
        System.out.println(fundacion);
        System.out.println(empleado.toString());
            try {
                Fundacion fundacion1=fundacionService.getFundacionById(fundacion);
                empleado.setFundacion(fundacion1);

                User user = new User();

                //Role rol = new Role();
                user.setUsername(empleado.getCedula());
                user.setPassword(empleado.getContraseña());
                int id=fundacion.intValue();

                Set<Role> roles = new HashSet<>();
                Role rol = new Role();

                if(id == 1){
                    rol = roleRepository.findByName("Usuario_1");
                    System.out.println(rol.toString());
                    roles.add(rol);
                }else if (id == 2){
                    rol = roleRepository.findByName("Usuario_2");
                    System.out.println(rol.toString());
                    roles.add(rol);
                }else if (id == 3){
                    rol = roleRepository.findByName("Usuario_3");
                    System.out.println(rol.toString());
                    roles.add(rol);
                }

               /* switch (id){
                    case 1:
                        roles.add(roleRepository.findByName("Usuario_1"));
                        System.out.println("Cualquier verga");
                        break;
                    case 2:
                        roles.add(roleRepository.findByName("Usuario_2"));
                        break;
                    case 3:
                        roles.add(roleRepository.findByName("Usuario_3"));
                        break;

                }*/
                user.setRoles(roles);
                empleadoService.createEmpleado(empleado);
                userService.createUser(user);
                model.addAttribute("empleado", new Empleado());
                model.addAttribute("exitoMessage","registro exitoso");
            } catch (Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                model.addAttribute("fundacion1",fundacion);
                model.addAttribute("empleado", empleado);

            }
        //model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        return"formEmployee";
    }
}
