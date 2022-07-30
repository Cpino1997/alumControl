package cl.sustantiva.alumControl.persistence.repository;

import cl.sustantiva.alumControl.persistence.crud.CursoCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository {
    private final CursoCrudRepository crudRepository;

    public CursoRepository(CursoCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Curso> getAll(){
        return (List<Curso>) crudRepository.findAll();
    }
    public Optional<Curso> getOne(int idCurso){
        return crudRepository.findById(idCurso);
    }
    public Curso save(Curso curso){
        return crudRepository.save(curso);
    }
    public void delete(int idCurso){
        crudRepository.deleteById(idCurso);
    }
}
