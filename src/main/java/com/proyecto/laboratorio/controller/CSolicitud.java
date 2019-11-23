package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Service.*;
import com.proyecto.laboratorio.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class CSolicitud {

    ImplementorSolicitud[] imp={new Solicitud(),new Fundacion()};
    AbstraccionSolicitud abst[]= {new RefinedAbstractionSolicitud(imp[0]),new RefinedAbstractionSolicitud(imp[1])};
    AgregarServicio agregarServicio=AgregarServicioImpl.Instance();

    @Autowired
    ServicioService servicioService;

    @Autowired
    SolicitudService solicitudService;

    @Autowired
    PersonaService personaService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    FundacionService fundacionService;

    @Autowired
    GobernacionService gobernacionService;


    @GetMapping({"/tableRequest"})
    public String tableRequest(Model model) {
        model.addAttribute("solicitudList",solicitudService.getAllSolicitudes());
        model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        return"tableRequest";
    }



    @GetMapping({"/formRequest"})
    public String formRequest(Model model) {
        model.addAttribute("solicitud", new Solicitud());
        model.addAttribute("servicioList",servicioService.getAllServicios());
        agregarServicio.deleteAll();
        return"formRequest";
    }

    @GetMapping({"/formRequest0"})
    public String formRequest1(@Valid @ModelAttribute("solicitud")Solicitud solicitud, ModelMap model,
                               @RequestParam(value = "serv")Long serv) throws Exception {
        Servicio service=servicioService.getServicioById(serv);
        boolean distintos=true;
        for (Servicio servicio:agregarServicio.getAll()) {
            if(servicio.getId()==service.getId())
            {
                distintos=false;
                break;
            }
        }
        if(distintos)
        {
            System.out.println("jajjaja");
            agregarServicio.agregarServicio(service);
            model.addAttribute("servicioList1", agregarServicio.getAll());
            model.addAttribute("servicioList",servicioService.getAllServicios());
            model.addAttribute("solicitud", solicitud);
        }
        else
        {
            model.addAttribute("servicioList1", agregarServicio.getAll());
            model.addAttribute("servicioList",servicioService.getAllServicios());
            model.addAttribute("solicitud", solicitud);
        }


        return"formRequest";
    }



    @PostMapping({"/formRequest"})
    public String createServicio(@Valid @ModelAttribute("solicitud") Solicitud solicitud, BindingResult result, ModelMap model)
    {
        if (result.hasErrors()) {
            model.addAttribute("solicitud", solicitud);
            model.addAttribute("servicioList1", agregarServicio.getAll());
            model.addAttribute("servicioList",servicioService.getAllServicios());
        } else{
            try {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                Empleado empleado=empleadoService.getEmpleadoById(auth.getName());
                Gobernacion gobernacion=gobernacionService.getGobernacionById("LARA");

                Iterable<Solicitud> solicitudes=solicitudService.getByFundacionAndStatus(empleado.getFundacion(),'a');
                double totalFundacion=gobernacion.getPartidaAnual()*empleado.getFundacion().getPorcentaje()/100;
                double totalGastado=abst[1].contador_acumulador(solicitudes);
                if(totalGastado>totalFundacion*0.75)
                {
                    model.addAttribute("errorMessage","no hay suficientes fondos para crear la solicitud");
                    model.addAttribute("solicitud", solicitud);
                    model.addAttribute("servicioList1", agregarServicio.getAll());
                    model.addAttribute("servicioList",servicioService.getAllServicios());
                }
                else {
                    double acumulador=0;
                    ServicioIterator servicioIterator= agregarServicio.getServicioIterator();
                    while(!servicioIterator.isLastServicio()) {
                        Servicio servicio = servicioIterator.nextServicio();
                        acumulador=acumulador+servicio.getCosto();
                    }
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());


                    //Solicitud solicitud=new Solicitud();

                    Persona persona=solicitud.getPersona();
                    personaService.createPersona(persona);
                    solicitud.setServicios(agregarServicio.getAll());
                    solicitud.setEmpleado(empleado);
                    //solicitud.setPersona(persona);
                    solicitud.setFundacion(empleado.getFundacion());
                    solicitud.setFecha(sqlDate);
                    //solicitud.setPrioridad(prioridad);
                    solicitud.setStatus('p');
                    solicitud.setPresupuesto(acumulador);

                    Long ide=(long)abst[0].contador_acumulador(solicitudService.getAllSolicitudes());

                    solicitud.setId(ide);


                    solicitudService.createSolicitud(solicitud);
                    model.addAttribute("servicioList",servicioService.getAllServicios());
                    model.addAttribute("solicitud", new Solicitud());
                    agregarServicio.deleteAll();
                    model.addAttribute("servicioList1", agregarServicio.getAll());
                    model.addAttribute("exitoMessage","registro exitoso");

                    System.out.println(solicitud.getFecha());
                    System.out.println(sqlDate);
                }




            } catch (Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                model.addAttribute("solicitud", solicitud);
                model.addAttribute("servicioList1", agregarServicio.getAll());
                model.addAttribute("servicioList",servicioService.getAllServicios());

            }
        }
        //model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        return"formRequest";
    }

    @GetMapping("/formRequest{id}")
    public String deleteServicio(Model model, @PathVariable(name="id")Long id) throws Exception {
        model.addAttribute("solicitud", new Solicitud());
        model.addAttribute("servicioList",servicioService.getAllServicios());
        int cont=0;
        ServicioIterator servicioIterator= agregarServicio.getServicioIterator();
        while(!servicioIterator.isLastServicio()) {
            Servicio servicio1 = servicioIterator.nextServicio();
            if(id==servicio1.getId())
            {
                agregarServicio.eliminarServicio(cont);
                break;
            }
            cont++;
        }
        model.addAttribute("servicioList1",agregarServicio.getAll());
        return "formRequest";
    }

    @GetMapping("/tableRequest{id}")
    public String getEditSolicitud(Model model, @PathVariable(name="id")Long id) throws Exception
    {
        Solicitud solicitud= solicitudService.getSolicitudById(id);
        solicitud.setStatus('a');
        solicitudService.updateSolicitud(solicitud);
        return tableRequest(model);
    }

    @GetMapping("/deny{id}")
    public String getDenySolicitud(Model model, @PathVariable(name="id")Long id) throws Exception
    {
        Solicitud solicitud= solicitudService.getSolicitudById(id);
        solicitud.setStatus('n');
        solicitudService.updateSolicitud(solicitud);
        model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        model.addAttribute("solicitudList",solicitudService.getAllSolicitudes());
        return"tableRequest";
    }


    @GetMapping("/tableRequestE")
    public String getSolicitudes(Model model, @RequestParam(value = "status")char status)
    {
        System.out.println(status);
        model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByStatus(status));
        return"tableRequest";
    }

    @GetMapping("/tableRequestF")
    public String getSolicitudesF(Model model,
                                  @RequestParam(value = "fecha1") java.sql.Date fecha1,
                                  @RequestParam(value = "fecha2") java.sql.Date fecha2)
    {
        Iterable<Solicitud> solicitudes=solicitudService.getSolicitudesByFecha(fecha1,fecha2);
        double total=abst[1].contador_acumulador(solicitudes);
        System.out.println(fecha1);
        System.out.println(fecha2);
        model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        model.addAttribute("solicitudList",solicitudes);
        model.addAttribute("totalSolicitudes",total);
        return"tableRequest";
    }

    @GetMapping("/tableRequestEmp")
    public String getSolicitudesEmp(Model model,
                                    @RequestParam(value = "emp")String emp) throws Exception {
        System.out.println(emp);
        model.addAttribute("empleadoList",empleadoService.getAllEmpleados());
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByEmpleado(empleadoService.getEmpleadoById(emp)));
        return"tableRequest";
    }

    @GetMapping("/tableFunNinnos")
    public String getSolicitudesfunN(Model model) throws Exception {

        Fundacion fundacion=fundacionService.getFundacionById(new Long(1));
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByFundacion(fundacion));
        return"tableFunNinnos";
    }

    @GetMapping("/tableFunNinnos{id}")
    public String getEditSolicitudfunN(Model model, @PathVariable(name="id")Long id) throws Exception
    {
        Solicitud solicitud= solicitudService.getSolicitudById(id);
        solicitud.setStatus('a');
        solicitudService.updateSolicitud(solicitud);
        Fundacion fundacion=fundacionService.getFundacionById(new Long(1));
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByFundacion(fundacion));
        return"tableFunNinnos";
    }


    @GetMapping("/tableFunNinnosF")
    public String getSolicitudesfunNFecha(Model model,
                                  @RequestParam(value = "fecha1") java.sql.Date fecha1,
                                  @RequestParam(value = "fecha2") java.sql.Date fecha2) throws Exception {

        Fundacion fundacion=fundacionService.getFundacionById(new Long(1));
        Iterable<Solicitud> solicitudes=solicitudService.getSolicitudesByFechaAndFundacion(fecha1,fecha2,fundacion);
        double total=abst[1].contador_acumulador(solicitudes);
        System.out.println(fecha1);
        System.out.println(fecha2);
        model.addAttribute("solicitudList",solicitudes);
        model.addAttribute("totalSolicitudes",total);
        return"tableFunNinnos";
    }

    @GetMapping("/tableFunDisc")
    public String getSolicitudesfunD(Model model) throws Exception {

        Fundacion fundacion=fundacionService.getFundacionById(new Long(2));
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByFundacion(fundacion));
        return"tableFunDisc";
    }

    @GetMapping("/tableFunDisc{id}")
    public String getEditSolicitudfunD(Model model, @PathVariable(name="id")Long id) throws Exception
    {
        Solicitud solicitud= solicitudService.getSolicitudById(id);
        solicitud.setStatus('a');
        solicitudService.updateSolicitud(solicitud);
        Fundacion fundacion=fundacionService.getFundacionById(new Long(2));
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByFundacion(fundacion));
        return"tableFunDisc";
    }
    @GetMapping("/tableFunDiscF")
    public String getSolicitudesfunDFecha(Model model,
                                          @RequestParam(value = "fecha1") java.sql.Date fecha1,
                                          @RequestParam(value = "fecha2") java.sql.Date fecha2) throws Exception {

        Fundacion fundacion=fundacionService.getFundacionById(new Long(2));
        Iterable<Solicitud> solicitudes=solicitudService.getSolicitudesByFechaAndFundacion(fecha1,fecha2,fundacion);
        double total=abst[1].contador_acumulador(solicitudes);
        System.out.println(fecha1);
        System.out.println(fecha2);
        model.addAttribute("solicitudList",solicitudes);
        model.addAttribute("totalSolicitudes",total);
        return"tableFunDisc";
    }

    @GetMapping("/tableFunMujer")
    public String getSolicitudesfunM(Model model) throws Exception {

        Fundacion fundacion=fundacionService.getFundacionById(new Long(3));
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByFundacion(fundacion));
        return"/tableFunMujer";
    }

    @GetMapping("/tableFunMujer{id}")
    public String getEditSolicitudfunM(Model model, @PathVariable(name="id")Long id) throws Exception
    {
        Solicitud solicitud= solicitudService.getSolicitudById(id);
        solicitud.setStatus('a');
        solicitudService.updateSolicitud(solicitud);
        Fundacion fundacion=fundacionService.getFundacionById(new Long(3));
        model.addAttribute("solicitudList",solicitudService.getSolicitudesByFundacion(fundacion));
        return"/tableFunMujer";
    }

    @GetMapping("/tableFunMujerF")
    public String getSolicitudesfunMFecha(Model model,
                                          @RequestParam(value = "fecha1") java.sql.Date fecha1,
                                          @RequestParam(value = "fecha2") java.sql.Date fecha2) throws Exception {

        Fundacion fundacion=fundacionService.getFundacionById(new Long(3));
        Iterable<Solicitud> solicitudes=solicitudService.getSolicitudesByFechaAndFundacion(fecha1,fecha2,fundacion);
        double total=abst[1].contador_acumulador(solicitudes);
        System.out.println(fecha1);
        System.out.println(fecha2);
        model.addAttribute("solicitudList",solicitudes);
        model.addAttribute("totalSolicitudes",total);
        return"/tableFunMujer";
    }



}

