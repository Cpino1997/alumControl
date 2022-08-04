package cl.sustantiva.alumControl.web.controller;


import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.domain.service.ProfesorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/profesor")

public class ProfesorController {


    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("profesores",
                service.findAll()
                        .orElse(new ArrayList<ProfesorDTO>()));
        return "profesoresList";
    }

    @GetMapping("/{idProfe}")
    public String findById(@PathVariable("idProfe") int idProfe, Model model){
        model.addAttribute("profesor",
                service.findById(idProfe)
                        .orElse(new ProfesorDTO()));
        return "profesor";
    }

    @GetMapping("/new")
    public String create(){
        return "newProfesor";
    }

    @GetMapping("/edit/{idProfe}")
    public String edit(@PathVariable("idProfe") int idProfe, Model model){
        model.addAttribute("idProfe",
                service.findById(idProfe)
                        .orElse(new ProfesorDTO()));

        return "profesor";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ProfesorDTO idProfe){
        service.save(idProfe);
        return "redirect:/profesor/all";
    }
    @GetMapping("/del/{idProfe}")
    public String delete(@PathVariable("idProfe") int idProfe){
        service.delete(idProfe);
        return "redirect:/profesor/all";
    }
}
