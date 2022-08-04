package cl.sustantiva.alumControl.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MatriculaPK implements Serializable {

    @Column(name="id_estudiante")
    private int idEstudiante;
    @Column(name="id_curso")
    private int idCurso;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public MatriculaPK() {
    }

    public MatriculaPK(Integer idEstudiante, Integer idCurso) {
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
    }
}
