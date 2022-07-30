package cl.sustantiva.alumControl.persistence.repository;

import cl.sustantiva.alumControl.persistence.crud.EstudianteCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class EstudianteRepository {
    private final EstudianteCrudRepository crudRepository;

    public EstudianteRepository(EstudianteCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Estudiante> getAll(){
        return (List<Estudiante>) crudRepository.findAll();
    }

    public Optional<Estudiante> getOne(int idEstudiante){
        return crudRepository.findById(idEstudiante);
    }

    public Estudiante save(Estudiante estudiante){
        return crudRepository.save(estudiante);
    }

    public void delete(int idEstudiante){
        crudRepository.deleteById(idEstudiante);
    }
}
