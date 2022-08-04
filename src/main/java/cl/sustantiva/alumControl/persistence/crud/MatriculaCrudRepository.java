package cl.sustantiva.alumControl.persistence.crud;

import cl.sustantiva.alumControl.persistence.entity.Matricula;
import cl.sustantiva.alumControl.persistence.entity.MatriculaPK;
import org.springframework.data.repository.CrudRepository;

public interface MatriculaCrudRepository extends CrudRepository<Matricula, MatriculaPK> {
}
