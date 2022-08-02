package cl.sustantiva.alumControl.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "curso")
@NamedQuery(name="Curso.findByNombre", query="select c from Curso c where c.nombreCurso like ?1")
public class Curso {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    @Column(name="id_facilitador")
    private Integer idProfesor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_facilitador", insertable = false, updatable = false)
    private Profesor profesor;
    @Column(name="codigo")
    private String codigoCurso;
    @Column(name="nombre")
    private String nombreCurso;




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

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", idProfesor=" + idProfesor +
                ", codigoCurso='" + codigoCurso + '\'' +
                ", nombreCurso='" + nombreCurso + '\'' +
                '}';
    }
}
