package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.dto.MatriculaDTO;
import cl.sustantiva.alumControl.domain.service.MatriculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("matriculas",
                service.findAll()
                        .orElse(new ArrayList<MatriculaDTO>()));
        return "matriculasList";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("idEstudiante, idCurso") int idEstudiante, int idCurso, Model model){
        model.addAttribute("matricula",
                service.findById(idEstudiante, idCurso)
                        .orElse(new MatriculaDTO()));
        return "matricula";
    }

    @GetMapping("/new")
    public String create(){
        return "newMatricula";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("idEstudiante, idCurso") int idEstudiante, int idCurso, Model model){
        model.addAttribute("matricula",
                service.findById(idEstudiante, idCurso)
                        .orElse(new MatriculaDTO()));

        return "matricula";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MatriculaDTO matriculaDTO){
        service.save(matriculaDTO);
        return "redirect:/matricula/all";
    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("idEstudiante, idCurso") int idEstudiante, int idCurso){
        service.delete(idEstudiante, idCurso);
        return "redirect:/matricula/all";
    }


}
