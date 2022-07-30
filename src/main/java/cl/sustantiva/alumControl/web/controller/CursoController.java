package cl.sustantiva.alumControl.web.controller;

import cl.sustantiva.alumControl.domain.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/curso")
public class CursoController {

        private final CursoService service;

        public CursoController(CursoService service) {
            this.service = service;
        }

        @GetMapping
        public String listCursos(Model model){
            model.addAttribute("cursos", service.getAll());
            return "cursosList";
        }
}
