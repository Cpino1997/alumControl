package cl.sustantiva.alumControl.web.restcontroller;

import cl.sustantiva.alumControl.domain.dto.MatriculaDTO;
import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.domain.service.MatriculaService;
import cl.sustantiva.alumControl.domain.service.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
public class MatriculaRestController {
    private final MatriculaService service;

    public MatriculaRestController(MatriculaService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<MatriculaDTO>> findAll(){
        return service.findAll()
                .map(matriculas -> new ResponseEntity<>(matriculas, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable("idEstudiante, idCurso") int idEstudiante, int idCurso){
        return service.findById(idEstudiante, idCurso)
                .map(matriculaDTO -> new ResponseEntity<>(matriculaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<MatriculaDTO> save(@RequestBody MatriculaDTO matriculaDTO){
        return new ResponseEntity<>(service.save(matriculaDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity delete(@PathVariable("idEstudiante, idCurso") int idCurso, int idEstudiante){
        if (service.delete(idCurso, idEstudiante)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}


