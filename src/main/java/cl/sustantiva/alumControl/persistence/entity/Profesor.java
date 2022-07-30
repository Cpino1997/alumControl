package cl.sustantiva.alumControl.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="facilitador")
public class Profesor {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfe;

    @Column(name="rut")
    private String rutProfesor;

    @Column(name="nombre")
    private String nombreProfesor;

    @Column(name="email")
    private String emailProfesor;

    @Column(name="telefono")
    private String telefonoProfesor;

    @Column(name="valorhora")
    private String valorHoraProfesor;

    @Column(name="banco")
    private String bancoProfesor;

    @Column(name="ctabancaria")
    private String ctaProfesor;

    public int getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(int idProfe) {
        this.idProfe = idProfe;
    }

    public String getRutProfesor() {
        return rutProfesor;
    }

    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    public String getTelefonoProfesor() {
        return telefonoProfesor;
    }

    public void setTelefonoProfesor(String telefonoProfesor) {
        this.telefonoProfesor = telefonoProfesor;
    }

    public String getValorHoraProfesor() {
        return valorHoraProfesor;
    }

    public void setValorHoraProfesor(String valorHoraProfesor) {
        this.valorHoraProfesor = valorHoraProfesor;
    }

    public String getBancoProfesor() {
        return bancoProfesor;
    }

    public void setBancoProfesor(String bancoProfesor) {
        this.bancoProfesor = bancoProfesor;
    }

    public String getCtaProfesor() {
        return ctaProfesor;
    }

    public void setCtaProfesor(String ctaProfesor) {
        this.ctaProfesor = ctaProfesor;
    }
}
