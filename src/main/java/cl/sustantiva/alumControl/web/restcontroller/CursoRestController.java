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

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getOne(@PathVariable("id") int idCurso){
        return service.getOne(idCurso)
                .map(curso -> new ResponseEntity<>(curso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CursoDTO> save(@RequestBody CursoDTO curso){
        return new ResponseEntity<>(service.save(curso), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity delete(@PathVariable("id") int idCurso){
        if (service.delete(idCurso)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
