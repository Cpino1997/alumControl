package cl.sustantiva.alumControl.persistence.crud;

import cl.sustantiva.alumControl.persistence.entity.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoCrudRepository extends CrudRepository<Curso, Integer> {
}
