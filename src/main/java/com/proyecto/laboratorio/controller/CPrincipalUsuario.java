package com.proyecto.laboratorio.controller;

import com.proyecto.laboratorio.Service.FundacionService;
import com.proyecto.laboratorio.Service.GobernacionService;
import com.proyecto.laboratorio.model.entity.Fundacion;
import com.proyecto.laboratorio.model.entity.Gobernacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CPrincipalUsuario {

    @Autowired
    GobernacionService gobernacionService;
    @Autowired
    FundacionService fundacionService;


    @GetMapping({"/index"})
    public String index(Model model) throws Exception {
        Gobernacion gobernacion=gobernacionService.getGobernacionById("LARA");
        model.addAttribute("fundacionList",fundacionService.getAllFundaciones());
        model.addAttribute("total",gobernacion.getPartidaAnual());
        model.addAttribute("gobernacion",new Gobernacion());
        return"index";
    }

    @PostMapping({"/index"})
    public String createServicio(@Valid @ModelAttribute("gobernacion")Gobernacion gobernacion, BindingResult result, ModelMap model) throws Exception {

        Gobernacion gobernacion1=gobernacionService.getGobernacionById("LARA");
        if(result.hasErrors())
        {
            model.addAttribute("gobernacion", gobernacion);
            model.addAttribute("fundacionList",fundacionService.getAllFundaciones());
            model.addAttribute("total",gobernacion1.getPartidaAnual());
        }else {
            try {
                gobernacion1.setPartidaAnual(gobernacion.getPartidaAnual());
                gobernacionService.updateGobernacion(gobernacion1);
                model.addAttribute("fundacionList",fundacionService.getAllFundaciones());
                model.addAttribute("total",gobernacion1.getPartidaAnual());
                model.addAttribute("gobernacion",new Gobernacion());
                model.addAttribute("exitoMessage","registro exitoso");
            } catch (Exception e) {
                model.addAttribute("errorMessage",e.getMessage());
                model.addAttribute("gobernacion", gobernacion);
                model.addAttribute("fundacionList",fundacionService.getAllFundaciones());
                model.addAttribute("total",gobernacion.getPartidaAnual());
            }
        }
        return"index";
    }

    @GetMapping({"/index1"})
    public String createServicio1(ModelMap model,
                                  @RequestParam(value ="porcentaje1")double porc1,
                                  @RequestParam(value ="porcentaje2")double porc2,
                                  @RequestParam(value ="porcentaje3")double porc3) throws Exception {
            System.out.println(porc1);
            System.out.println(porc2);
            System.out.println(porc3);
            Gobernacion gobernacion=gobernacionService.getGobernacionById("LARA");
            try {

                long porcentaje=(long)(porc1+porc2+porc3);
                if(porcentaje==100)
                {
                    Iterable<Fundacion>fundaciones=fundacionService.getAllFundaciones();
                    for (Fundacion fundacion:fundaciones) {
                        int id=fundacion.getId().intValue();
                        switch (id){
                            case 1:
                                fundacion.setPorcentaje(porc2);
                                break;
                            case 2:
                                fundacion.setPorcentaje(porc3);
                                break;
                            case 3:
                                fundacion.setPorcentaje(porc1);
                                break;

                        }
                        fundacionService.updateFundacion(fundacion);
                    }

                    model.addAttribute("fundacionList",fundaciones);
                    model.addAttribute("total",gobernacion.getPartidaAnual());
                    model.addAttribute("gobernacion",new Gobernacion());
                    model.addAttribute("exitoMessage1","registro exitoso");
                }
                else
                {
                    model.addAttribute("fundacionList",fundacionService.getAllFundaciones());
                    model.addAttribute("total",gobernacion.getPartidaAnual());
                    model.addAttribute("gobernacion",new Gobernacion());
                    model.addAttribute("errorMessage1","Los porcentajes no suman 100");
                }


            } catch (Exception e) {
                model.addAttribute("errorMessage1",e.getMessage());
                model.addAttribute("gobernacion", new Gobernacion());
                model.addAttribute("fundacionList",fundacionService.getAllFundaciones());
                model.addAttribute("total",gobernacion.getPartidaAnual());
            }
        return"index";
    }


   /* @GetMapping({"/index"})
    public String showIndex(Model model) {
        return "index";
    }*/

   /* @GetMapping({"/tableFunDisc"})
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
    }*/
}
