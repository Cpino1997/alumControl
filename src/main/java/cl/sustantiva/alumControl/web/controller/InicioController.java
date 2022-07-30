package cl.sustantiva.alumControl.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InicioController {

    Log logger = LogFactory.getLog(InicioController.class);
    @GetMapping
    public String inicio(){
        logger.info("funciono Otra Vez :D");
        return "index";
    }
    @GetMapping("/home")
    public String home(){
        logger.info("cargue el home");
        return "home";
    }
}
