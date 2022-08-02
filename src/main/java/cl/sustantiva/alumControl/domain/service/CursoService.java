package cl.sustantiva.alumControl.domain.service;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import cl.sustantiva.alumControl.persistence.repository.CursoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    Log logger = LogFactory.getLog(CursoService.class);

    private final CursoRepository repository;
    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<CursoDTO> getAll(){
        return repository.getAll();
    }

    public Optional<CursoDTO> getOne(int idCurso){
        return repository.getOne(idCurso);
    }

    public CursoDTO save(CursoDTO curso){
        return repository.save(curso);
    }
    public boolean delete(int idCurso){
        return getOne(idCurso)
                .map(curso -> {
                    repository.delete(idCurso);
                    return true;
                }).orElse(false);
    }
}
