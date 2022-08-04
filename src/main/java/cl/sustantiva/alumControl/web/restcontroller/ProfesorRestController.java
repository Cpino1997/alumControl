package cl.sustantiva.alumControl.web.restcontroller;


import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.domain.service.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorRestController {

    private final ProfesorService service;

    public ProfesorRestController(ProfesorService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProfesorDTO>> findAll(){
        return service.findAll()
                .map(profesores -> new ResponseEntity<>(profesores, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idProfe}")
    public ResponseEntity<ProfesorDTO> findById(@PathVariable("idProfe") int idProfe){
        return service.findById(idProfe)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ProfesorDTO> save(@RequestBody ProfesorDTO profesorDTO){
        return new ResponseEntity<>(service.save(profesorDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idProfe}")
    public ResponseEntity delete(@PathVariable("idProfe") int idProfe){
        if (service.delete(idProfe)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
