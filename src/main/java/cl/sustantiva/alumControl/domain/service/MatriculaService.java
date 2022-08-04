package cl.sustantiva.alumControl.domain.service;

import cl.sustantiva.alumControl.domain.dto.MatriculaDTO;
import cl.sustantiva.alumControl.domain.repository.MatriculaRepositoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MatriculaService {
    private final MatriculaRepositoryDTO repo;

    public MatriculaService(MatriculaRepositoryDTO repo) {
        this.repo = repo;
    }

    public Optional<List<MatriculaDTO>> findAll(){
        return repo.findAll();
    }
    public Optional<MatriculaDTO> findById(int idEstudiante, int idCurso){
        return repo.findById(idEstudiante, idCurso);
    }

    public MatriculaDTO save(MatriculaDTO matriculaDTO){
        return repo.save(matriculaDTO);
    }

    public boolean delete(int idEstudiante, int idCurso){
        return findById(idEstudiante, idCurso)
                .map(matriculaDTO -> {
                    repo.delete(idEstudiante, idCurso);
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

