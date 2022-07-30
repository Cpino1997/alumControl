package cl.sustantiva.alumControl.persistence.crud;

import cl.sustantiva.alumControl.persistence.entity.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorCrudRepository extends CrudRepository<Profesor, Integer> {
}
