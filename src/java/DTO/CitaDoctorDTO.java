
package DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDoctorDTO {
    private Integer idcita;
    private Integer iddoctor;
    private String paciente;
    private String tipo_cita;
    private Double costo_cita;
    private LocalDate fecha_cita;
    private LocalTime hora_cita;
    
    public  CitaDoctorDTO() {
        
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public Double getCosto_cita() {
        return costo_cita;
    }

    public void setCosto_cita(Double costo_cita) {
        this.costo_cita = costo_cita;
    }

    public LocalDate getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDate fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public LocalTime getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(LocalTime hora_cita) {
        this.hora_cita = hora_cita;
    }

    
    
    
}
