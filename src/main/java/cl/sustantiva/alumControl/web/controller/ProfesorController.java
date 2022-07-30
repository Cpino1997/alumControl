package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.service.EstudianteService;
import cl.sustantiva.alumControl.domain.service.ProfesorService;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import cl.sustantiva.alumControl.persistence.entity.Profesor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profesor")

public class ProfesorController {

    Log logger = LogFactory.getLog(ProfesorController.class);

    private final ProfesorService service;

    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public String getProfesores(Model model) {

        model.addAttribute("profesores", service.getAll());
        model.addAttribute("nombre", "Cristian");
        return "profesoresList";
    }

    @GetMapping("/{idProfesor}")
    public String getProfesorById(@PathVariable("idProfesor") int idProfesor, Model model) {
        try {
            model.addAttribute("profesor", service.getOne(idProfesor).get());
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return "profesor";
    }
    @PostMapping("/save")
    public String saveProfesor(@ModelAttribute Profesor profesor, Model model){
        logger.info(profesor.toString());
        service.save(profesor);
        return "redirect:/profesor";
    }
    @GetMapping("/new")
    public String newProfesor(){
        return "newProfesor";
    }
    @GetMapping("/del/{idProfesor}")
    public String delProfesor(@PathVariable("idProfesor") int idProfesor){
        service.delete(idProfesor);
        return "redirect:/profesor";
    }
}
