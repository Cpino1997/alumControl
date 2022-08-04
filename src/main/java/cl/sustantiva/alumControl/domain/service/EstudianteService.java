package cl.sustantiva.alumControl.domain.service;

import cl.sustantiva.alumControl.domain.dto.EstudianteDTO;
import cl.sustantiva.alumControl.domain.repository.EstudianteRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EstudianteService {
    private final EstudianteRepositoryDTO repo;

    public EstudianteService(EstudianteRepositoryDTO repo) {
        this.repo = repo;
    }

    public Optional<List<EstudianteDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<EstudianteDTO> findById(int idEstudiante){
        return repo.findById(idEstudiante);
    }

    public EstudianteDTO save(EstudianteDTO estudianteDTO){
        return repo.save(estudianteDTO);
    }

    public boolean delete(int idEstudiante){
        return findById(idEstudiante)
                .map(estudianteDTO -> {
                    repo.delete(idEstudiante);
                    return true;})
                .orElse(false);


        /*if(findById(idEstudiante).isPresent()){
            repo.delete(idEstudiante);
            return true;
        } else {
            return false;
        }*/
    }
}
