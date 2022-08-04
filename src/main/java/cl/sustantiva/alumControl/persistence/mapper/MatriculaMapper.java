package cl.sustantiva.alumControl.persistence.mapper;

import cl.sustantiva.alumControl.domain.dto.MatriculaDTO;
import cl.sustantiva.alumControl.persistence.entity.Matricula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstudianteMapper.class, CursoMapper.class})
public interface MatriculaMapper {

    @Mappings({
            @Mapping(source = "id.idEstudiante", target = "idEstudiante"),
            @Mapping(source = "id.idCurso", target = "idCurso"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "estudiante", target = "estudianteDTO"),
            @Mapping(source = "curso", target = "cursoDTO"),
    })
    MatriculaDTO toMatriculaDTO(Matricula matricula);
    List<MatriculaDTO> toMatriculaDTOs(List<Matricula> matriculas);

    @InheritInverseConfiguration
    Matricula toMatricula(MatriculaDTO matriculaDTO);
}