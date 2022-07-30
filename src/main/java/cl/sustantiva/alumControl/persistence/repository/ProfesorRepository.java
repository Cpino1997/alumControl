package cl.sustantiva.alumControl.persistence.repository;


import cl.sustantiva.alumControl.persistence.crud.ProfesorCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Profesor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesorRepository {

    private final ProfesorCrudRepository crudRepository;

    public ProfesorRepository(ProfesorCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Profesor> getAll(){
        return (List<Profesor>) crudRepository.findAll();
    }

    public Optional<Profesor> getOne(int idProfesor){
        return crudRepository.findById(idProfesor);
    }

    public Profesor save(Profesor profesor){
        return crudRepository.save(profesor);
    }

    public void delete(int idProfesor){
        crudRepository.deleteById(idProfesor);
    }
}
