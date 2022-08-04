package cl.sustantiva.alumControl.web.restcontroller;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.dto.EstudianteDTO;
import cl.sustantiva.alumControl.domain.service.CursoService;
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
    public ResponseEntity<List<EstudianteDTO>> findAll(){
        return service.findAll()
                .map(estudiantes -> new ResponseEntity<>(estudiantes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idEstudiante}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable("idEstudiante") int idEstudiante){
        return service.findById(idEstudiante)
                .map(estudianteDTO -> new ResponseEntity<>(estudianteDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<EstudianteDTO> save(@RequestBody EstudianteDTO estudianteDTO){
        return new ResponseEntity<>(service.save(estudianteDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idEstudiante}")
    public ResponseEntity delete(@PathVariable("idEstudiante") int idEstudiante){
        if (service.delete(idEstudiante)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    }
