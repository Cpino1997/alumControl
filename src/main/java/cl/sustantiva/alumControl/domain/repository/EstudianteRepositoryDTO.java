package cl.sustantiva.alumControl.domain.repository;

import cl.sustantiva.alumControl.domain.dto.EstudianteDTO;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepositoryDTO {
    Optional<List<EstudianteDTO>> findAll();
    Optional<EstudianteDTO> findById(int idEstudiante);
    EstudianteDTO save(EstudianteDTO estudianteDTO);
    void delete(int idEstudiante);
}
