package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoService service;
    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("cursos",
                service.findAll()
                        .orElse(new ArrayList<CursoDTO>()));
        return "cursosList";
    }

    @GetMapping("/{idCurso}")
    public String findById(@PathVariable("idCurso") int idCurso, Model model){
        model.addAttribute("curso",
                service.findById(idCurso)
                        .orElse(new CursoDTO()));
        return "curso";
    }

    @GetMapping("/new")
    public String create(){
        return "newCurso";
    }

    @GetMapping("/edit/{idCurso}")
    public String edit(@PathVariable("idCurso") int idCurso, Model model){
        model.addAttribute("curso",
                service.findById(idCurso)
                        .orElse(new CursoDTO()));

        return "curso";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute CursoDTO idCurso){
        service.save(idCurso);
        return "redirect:/curso/all";
    }
    @GetMapping("/del/{idCurso}")
    public String delete(@PathVariable("idCurso") int idCurso){
        service.delete(idCurso);
        return "redirect:/curso/all";
    }

}