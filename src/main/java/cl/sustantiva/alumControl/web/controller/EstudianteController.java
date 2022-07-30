package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.service.EstudianteService;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    Log logger = LogFactory.getLog(EstudianteController.class);

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public String getEstudiantes(Model model){

        model.addAttribute("estudiantes", service.getAll());
        return "estudiantesList";
    }

    @GetMapping("/{idEstudiante}")
    public String getEstudianteById(@PathVariable("idEstudiante") int idEstudiante, Model model){
        try {
            model.addAttribute("estudiante", service.getOne(idEstudiante).get());
        } catch (Exception e){
            logger.error(e.toString());
        }
        return "estudiante";
    }
    @PostMapping("/save")
    public String saveEstudiante(@ModelAttribute Estudiante estudiante, Model model){
        logger.info(estudiante.toString());
        service.save(estudiante);
        return "redirect:/estudiante";
    }
    @GetMapping("/new")
    public String newEstudiante(){
        return "newEstudiante";
    }
    @GetMapping("/del/{idEstudiante}")
    public String delEstudiante(@PathVariable("idEstudiante") int idEstudiante){
        service.delete(idEstudiante);
        return "redirect:/estudiante";
    }

}
