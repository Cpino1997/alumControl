package cl.sustantiva.alumControl.domain.service;


import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.domain.repository.ProfesorRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepositoryDTO repo;

    public ProfesorService(ProfesorRepositoryDTO repo) {
        this.repo = repo;
    }

    public Optional<List<ProfesorDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<ProfesorDTO> findById(int idProfe){
        return repo.findById(idProfe);
    }
    public ProfesorDTO save(ProfesorDTO profesorDTO){
        return repo.save(profesorDTO);
    }

    public boolean delete(int idProfe){
        return findById(idProfe)
                .map(profesorDTO -> {
                    repo.delete(idProfe);
                    return true;})
                .orElse(false);
    }
}
