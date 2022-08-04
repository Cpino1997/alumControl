package cl.sustantiva.alumControl.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MatriculaDTO {
    private Integer idEstudiante;
    private Integer idCurso;
    private EstudianteDTO estudianteDTO;
    private CursoDTO cursoDTO;
    private LocalDate date;
}