package cl.sustantiva.alumControl.persistence.repository;


import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.domain.repository.ProfesorRepositoryDTO;
import cl.sustantiva.alumControl.persistence.crud.CursoCrudRepository;
import cl.sustantiva.alumControl.persistence.crud.ProfesorCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import cl.sustantiva.alumControl.persistence.entity.Profesor;
import cl.sustantiva.alumControl.persistence.mapper.CursoMapper;
import cl.sustantiva.alumControl.persistence.mapper.ProfesorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfesorRepository implements ProfesorRepositoryDTO {

    private final ProfesorCrudRepository crud;
    private final ProfesorMapper mapper;

    public ProfesorRepository(ProfesorCrudRepository crud, ProfesorMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }
    @Override
    public Optional<List<ProfesorDTO>> findAll() {
        return Optional.of(mapper.toProfesorDTOs((List<Profesor>) crud.findAll()));
    }

    @Override
    public Optional<ProfesorDTO> findById(int idProfe) {
        return crud.findById(idProfe)
                .map(mapper::toProfesorDTO);
    }

    @Override
    public ProfesorDTO save(ProfesorDTO profesorDTO) {
        return mapper.toProfesorDTO(crud.save(mapper.toProfesor(profesorDTO)));
    }

    @Override
    public void delete(int idProfe) {
        crud.deleteById(idProfe);
    }
}
