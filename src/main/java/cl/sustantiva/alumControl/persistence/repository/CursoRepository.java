package cl.sustantiva.alumControl.persistence.repository;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.repository.CursoRepositoryDTO;
import cl.sustantiva.alumControl.persistence.crud.CursoCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import cl.sustantiva.alumControl.persistence.mapper.CursoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CursoRepository implements CursoRepositoryDTO {

    private final CursoCrudRepository crud;
    private final CursoMapper mapper;


    public CursoRepository(CursoCrudRepository crud, CursoMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }


    @Override
    public Optional<List<CursoDTO>> findAll() {
        return Optional.of(mapper.toCursoDTOs((List<Curso>) crud.findAll()));
    }

    @Override
    public Optional<CursoDTO> findById(int idCurso) {
        return crud.findById(idCurso)
                .map(mapper::toCursoDTO);
    }

    @Override
    public CursoDTO save(CursoDTO cursoDTO) {
        return mapper.toCursoDTO(crud.save(mapper.toCurso(cursoDTO)));
    }

    @Override
    public void delete(int idCurso) {
        crud.deleteById(idCurso);
    }
}
