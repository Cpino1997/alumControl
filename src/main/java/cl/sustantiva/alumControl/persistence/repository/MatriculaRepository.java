package cl.sustantiva.alumControl.persistence.repository;

import cl.sustantiva.alumControl.domain.dto.MatriculaDTO;
import cl.sustantiva.alumControl.domain.repository.MatriculaRepositoryDTO;
import cl.sustantiva.alumControl.persistence.crud.MatriculaCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Matricula;
import cl.sustantiva.alumControl.persistence.entity.MatriculaPK;
import cl.sustantiva.alumControl.persistence.mapper.MatriculaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MatriculaRepository implements MatriculaRepositoryDTO {

    private final MatriculaCrudRepository crud;
    private final MatriculaMapper mapper;

    public MatriculaRepository(MatriculaCrudRepository crud, MatriculaMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<MatriculaDTO>> findAll() {
        return Optional.of(mapper.toMatriculaDTOs((List<Matricula>)crud.findAll()));
    }

    @Override
    public Optional<MatriculaDTO> findById(int idEstudiante, int idCurso) {
        return crud.findById(new MatriculaPK(idEstudiante, idCurso))
                .map(mapper::toMatriculaDTO);
    }

    @Override
    public MatriculaDTO save(MatriculaDTO matriculaDTO) {
        return mapper.toMatriculaDTO(crud.save(mapper.toMatricula(matriculaDTO)));
    }

    @Override
    public void delete(int idEstudiante, int idCurso) {
        crud.deleteById(new MatriculaPK(idEstudiante, idCurso));
    }
}