package cl.sustantiva.alumControl.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="matricula")
public class Matricula {

    @EmbeddedId
    private MatriculaPK id;
    private LocalDate fecha;

    @ManyToOne
    @MapsId("idEstudiante")
    private Estudiante estudiante;
    @ManyToOne
    @MapsId("idCurso")
    private Curso curso;

    public MatriculaPK getId() {
        return id;
    }

    public void setId(MatriculaPK id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
