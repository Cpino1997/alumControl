package cl.sustantiva.alumControl.domain.dto;

import lombok.Data;

@Data
public class CursoDTO {
    private Integer idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private Integer idProfesor;
    private ProfesorDTO profesorDTO;
}
