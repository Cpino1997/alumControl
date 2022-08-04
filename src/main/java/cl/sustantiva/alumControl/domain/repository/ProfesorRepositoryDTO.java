package cl.sustantiva.alumControl.domain.repository;


import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepositoryDTO {
    Optional<List<ProfesorDTO>> findAll();
    Optional<ProfesorDTO> findById(int idProfe);
    ProfesorDTO save(ProfesorDTO profesorDTO);
    void delete(int idProfe);
}
