package cl.sustantiva.alumControl.domain.service;

import cl.sustantiva.alumControl.persistence.entity.Curso;
import cl.sustantiva.alumControl.persistence.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }
    public List<Curso> getAll(){
        return repository.getAll();
    }
    public Optional<Curso> getOne(int addressId){
        return repository.getOne(addressId);
    }

    public Curso save(Curso curso){
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
