package cl.sustantiva.alumControl.web.restcontroller;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.service.CursoService;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {

    private final CursoService service;

    public CursoRestController(CursoService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<CursoDTO>> findAll(){
        return service.findAll()
                .map(cursos -> new ResponseEntity<>(cursos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoDTO> findById(@PathVariable("idCurso") int idCurso){
        return service.findById(idCurso)
                .map(cursoDTO -> new ResponseEntity<>(cursoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CursoDTO> save(@RequestBody CursoDTO cursoDTO){
        return new ResponseEntity<>(service.save(cursoDTO), HttpStatus.OK);
    }
    @DeleteMapping("/del/{idCurso}")
    public ResponseEntity delete(@PathVariable("idCurso") int idCurso){
        if (service.delete(idCurso)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
