package cl.sustantiva.alumControl.domain.repository;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;

import java.util.List;
import java.util.Optional;

public interface CursoRepositoryDTO {
    Optional<List<CursoDTO>> findAll();
    Optional<CursoDTO> findById(int idCurso);
    CursoDTO save(CursoDTO cursoDTO);
    void delete(int idCurso);
}