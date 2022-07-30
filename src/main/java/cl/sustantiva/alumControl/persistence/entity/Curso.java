package cl.sustantiva.alumControl.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(name="codigo")
    private String codigoCurso;
    @Column(name="nombre")
    private String nombreCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facilitador", insertable = false, updatable = false)
    private Profesor profesor;
    @Column(name="id_facilitador")
    private Integer idProfesor;


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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
}
