package cl.sustantiva.alumControl.domain.dto;

import lombok.Data;

//@Data
public class CursoDTO {
    private Integer idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private Integer idProfesor;
    private ProfesorDTO profesorDTO;

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public ProfesorDTO getProfesorDTO() {
        return profesorDTO;
    }

    public void setProfesorDTO(ProfesorDTO profesorDTO) {
        this.profesorDTO = profesorDTO;
    }
}
