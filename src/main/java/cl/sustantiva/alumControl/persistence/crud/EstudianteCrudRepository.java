package cl.sustantiva.alumControl.persistence.crud;

import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteCrudRepository extends CrudRepository<Estudiante, Integer> {

}
