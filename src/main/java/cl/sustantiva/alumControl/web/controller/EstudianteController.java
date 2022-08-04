package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.dto.EstudianteDTO;
import cl.sustantiva.alumControl.domain.service.CursoService;
import cl.sustantiva.alumControl.domain.service.EstudianteService;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService service;
    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("estudiantes",
                service.findAll()
                        .orElse(new ArrayList<EstudianteDTO>()));
        return "estudiantesList";
    }

    @GetMapping("/{idEstudiante}")
    public String findById(@PathVariable("idEstudiante") int idEstudiante, Model model){
        model.addAttribute("estudiante",
                service.findById(idEstudiante)
                        .orElse(new EstudianteDTO()));
        return "estudiante";
    }

    @GetMapping("/new")
    public String create(){
        return "newEstudiante";
    }

    @GetMapping("/edit/{idEstudiante}")
    public String edit(@PathVariable("idEstudiante") int idEstudiante, Model model){
        model.addAttribute("estudiante",
                service.findById(idEstudiante)
                        .orElse(new EstudianteDTO()));

        return "estudiante";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute EstudianteDTO idEstudiante){
        service.save(idEstudiante);
        return "redirect:/estudiante/all";
    }
    @GetMapping("/del/{idEstudiante}")
    public String delete(@PathVariable("idEstudiante") int idEstudiante){
        service.delete(idEstudiante);
        return "redirect:/estudiante/all";
    }

}
