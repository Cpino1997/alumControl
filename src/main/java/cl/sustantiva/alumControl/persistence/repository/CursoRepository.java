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
    private final CursoCrudRepository crudRepository;
    private final CursoMapper mapper;

    public CursoRepository(CursoCrudRepository crudRepository, CursoMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    public List<CursoDTO> getAll(){
        return mapper.toCursoDTOs((List<Curso>) crudRepository.findAll());
    }
    public Optional<CursoDTO> getOne(int idCurso){
        return crudRepository.findById(idCurso).map(mapper::toCursoDTO);
    }

    public CursoDTO save(CursoDTO cursoDTO){
        return mapper.toCursoDTO(crudRepository.save(mapper.toCurso(cursoDTO)));
    }
    public void delete(int idCurso){
        crudRepository.deleteById(idCurso);
    }
}