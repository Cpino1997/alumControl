package cl.sustantiva.alumControl.web.restcontroller;

import cl.sustantiva.alumControl.domain.service.EstudianteService;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/estudiante")
public class EstudianteRestController {

        private final EstudianteService service;

        public EstudianteRestController(EstudianteService service) {
            this.service = service;
        }

    @GetMapping("/all")
    public ResponseEntity<List<Estudiante>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getOne(@PathVariable("id") int idEstudiante){
        return service.getOne(idEstudiante)
                .map(estudiante -> new ResponseEntity<>(estudiante, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante){
        return new ResponseEntity<>(service.save(estudiante), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity delete(@PathVariable("id") int idEstudiante){
        if (service.delete(idEstudiante)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    }
