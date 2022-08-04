package cl.sustantiva.alumControl.domain.repository;

import cl.sustantiva.alumControl.domain.dto.MatriculaDTO;

import java.util.List;
import java.util.Optional;

public interface MatriculaRepositoryDTO {
    Optional<List<MatriculaDTO>> findAll();
    Optional<MatriculaDTO> findById(int idEstudiante, int idCurso);
    MatriculaDTO save(MatriculaDTO matriculaDTO);
    void delete(int idEstudiante, int idCurso);

}
