package cl.sustantiva.alumControl.persistence.mapper;

import cl.sustantiva.alumControl.domain.dto.ProfesorDTO;
import cl.sustantiva.alumControl.persistence.entity.Profesor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ProfesorMapper {
    @Mappings({
            @Mapping(source = "idProfe", target ="idProfe"),
            @Mapping(source = "nombreProfesor", target ="nombreProfesor"),
            @Mapping(source = "rutProfesor", target ="rutProfesor"),
            @Mapping(source = "emailProfesor", target ="emailProfesor"),
            @Mapping(source = "telefonoProfesor", target ="telefonoProfesor"),
            @Mapping(source = "valorHoraProfesor", target ="valorHoraProfesor"),
            @Mapping(source = "bancoProfesor", target ="bancoProfesor"),
            @Mapping(source = "ctaProfesor", target ="ctaProfesor"),
    })

    ProfesorDTO toProfesorDTO(Profesor profesor);
    List<Profesor> toProfesorDTOs(List<Profesor> profesores);

    @InheritInverseConfiguration
    Profesor toProfesor(ProfesorDTO profesorDTO);
}
