package cl.sustantiva.alumControl.persistence.crud;

import cl.sustantiva.alumControl.persistence.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoCrudRepository extends CrudRepository<Curso, Integer> {
}
