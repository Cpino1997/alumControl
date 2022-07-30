package cl.sustantiva.alumControl.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/matricula")
public class MatriculasController {
        Log logger = LogFactory.getLog(cl.sustantiva.alumControl.web.controller.InicioController.class);
        @GetMapping
        public String inicio(){
            logger.info("En Creacion");
            return "matricula";
        }
}
