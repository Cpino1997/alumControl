package cl.sustantiva.alumControl.domain.dto;

import lombok.Data;

//@Data
public class ProfesorDTO {
    private Integer idProfe;
    private String nombreProfesor;
    private String rutProfesor;
    private String emailProfesor;
    private String telefonoProfesor;
    private String valorHoraProfesor;
    private String bancoProfesor;
    private String ctaProfesor;

    public Integer getIdProfe() {
        return idProfe;
    }

    public void setIdProfe(Integer idProfe) {
        this.idProfe = idProfe;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getRutProfesor() {
        return rutProfesor;
    }

    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
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

    @Override
    public String toString() {
        return ""+nombreProfesor+"";
    }
}
