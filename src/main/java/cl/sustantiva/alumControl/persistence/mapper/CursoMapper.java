package cl.sustantiva.alumControl.persistence.mapper;

import cl.sustantiva.alumControl.domain.dto.CursoDTO;
import cl.sustantiva.alumControl.persistence.entity.Curso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProfesorMapper.class})
public interface CursoMapper {
    @Mappings({
            @Mapping(source = "idCurso", target = "idCurso"),
            @Mapping(source = "codigoCurso", target = "codigoCurso"),
            @Mapping(source = "nombreCurso", target = "nombreCurso"),
            @Mapping(source = "idProfesor", target = "idProfesor"),
            @Mapping(source = "profesor", target = "profesorDTO"),
    })
    CursoDTO toCursoDTO(Curso curso);
    List<CursoDTO> toCursoDTOs(List<Curso> cursos);

    @InheritInverseConfiguration
    @Mapping(source = "idProfesor", target = "idProfesor")
    Curso toCurso(CursoDTO cursoDTO);
}