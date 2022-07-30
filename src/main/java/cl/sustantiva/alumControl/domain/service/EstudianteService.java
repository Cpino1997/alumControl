package cl.sustantiva.alumControl.domain.service;

import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import cl.sustantiva.alumControl.persistence.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteService {
    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> getAll(){
        return repository.getAll();
    }

    public Optional<Estudiante> getOne(int idEstudiante){
        return repository.getOne(idEstudiante);
    }

    public Estudiante save(Estudiante estudiante){
        return repository.save(estudiante);
    }

    public boolean delete(int idEstudiante){
        return getOne(idEstudiante)
                .map(estudiante -> {
                    repository.delete(idEstudiante);
                    return true;
                }).orElse(false);
}
}
