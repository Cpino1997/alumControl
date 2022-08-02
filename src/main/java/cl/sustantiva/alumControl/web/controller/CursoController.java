package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.service.CursoService;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/curso")
public class CursoController {
    Log logger = LogFactory.getLog(CursoController.class);

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllCurso(Model model){
        model.addAttribute("cursos", service.getAll());
        return "cursosList";
    }

    @GetMapping("/{idCurso}")
    public String getCursoById(@PathVariable("idCurso") int idCurso, Model model){
        try {
            model.addAttribute("curso", service.getOne(idCurso).get());
        } catch (Exception e){
            logger.error(e.toString());
        }
        return "curso";
    }

    @PostMapping("/save")
    public String saveCurso(@ModelAttribute CursoDTO curso, Model model){
        logger.info(curso.toString());
        service.save(curso);
        return "redirect:/curso";
    }
    @GetMapping("/new")
    public String newCurso(){
        return "newCurso";
    }
    @GetMapping("/del/{idCurso}")
    public String delCurso(@PathVariable("idCurso") int idCurso){
        service.delete(idCurso);
        return "redirect:/curso";
    }
}
