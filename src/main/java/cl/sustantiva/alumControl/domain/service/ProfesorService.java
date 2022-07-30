package cl.sustantiva.alumControl.domain.service;

import cl.sustantiva.alumControl.persistence.entity.Profesor;
import cl.sustantiva.alumControl.persistence.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    public List<Profesor> getAll(){
        return repository.getAll();
    }

    public Optional<Profesor> getOne(int idProfesor){
        return repository.getOne(idProfesor);
    }

    public Profesor save(Profesor profesor){
        return repository.save(profesor);
    }

    public boolean delete(int idProfesor){
        return getOne(idProfesor)
                .map(profesor -> {
                    repository.delete(idProfesor);
                    return true;
                }).orElse(false);
    }
}
