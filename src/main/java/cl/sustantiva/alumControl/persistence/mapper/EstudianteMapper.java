package cl.sustantiva.alumControl.persistence.mapper;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.domain.dto.EstudianteDTO;
import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import cl.sustantiva.alumControl.persistence.entity.Estudiante;
import cl.sustantiva.alumControl.persistence.entity.Profesor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface EstudianteMapper {
        @Mappings({
                @Mapping(source = "idEstudiante", target = "idEstudiante"),
                @Mapping(source = "rutEstudiante", target = "rutEstudiante"),
                @Mapping(source = "nombreEstudiante", target = "nombreEstudiante"),
                @Mapping(source = "emailEstudiante", target = "emailEstudiante"),
                @Mapping(source = "telefonoEstudiante", target = "telefonoEstudiante"),
        })
        EstudianteDTO toEstudianteDTO(Estudiante estudiante);
        List<EstudianteDTO> toEstudianteDTOs(List<Estudiante> estudiantes);

        @InheritInverseConfiguration
        Estudiante toEstudiante(EstudianteDTO estudianteDTO);
}
