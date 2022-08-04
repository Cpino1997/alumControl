package cl.sustantiva.alumControl.persistence.repository;


import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.dto.EstudianteDTO;
import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.domain.repository.EstudianteRepositoryDTO;
import cl.sustantiva.alumControl.persistence.crud.CursoCrudRepository;
import cl.sustantiva.alumControl.persistence.crud.EstudianteCrudRepository;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import cl.sustantiva.alumControl.persistence.mapper.CursoMapper;
import cl.sustantiva.alumControl.persistence.mapper.EstudianteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class EstudianteRepository implements EstudianteRepositoryDTO {
    private final EstudianteCrudRepository crud;
    private final EstudianteMapper mapper;

    public EstudianteRepository(EstudianteCrudRepository crud, EstudianteMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }
    @Override
    public Optional<List<EstudianteDTO>> findAll() {
        return Optional.of(mapper.toEstudianteDTOs((List<Estudiante>) crud.findAll()));
    }

    @Override
    public Optional<EstudianteDTO> findById(int idEstudiante) {
        return crud.findById(idEstudiante)
                .map(mapper::toEstudianteDTO);
    }

    @Override
    public EstudianteDTO save(EstudianteDTO estudianteDTO) {
        return mapper.toEstudianteDTO(crud.save(mapper.toEstudiante(estudianteDTO)));
    }


    @Override
    public void delete(int idEstudiante) {
        crud.deleteById(idEstudiante);

    }
}
