package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDateTime;

public class DisponibilidadSlot {
    private String nombreServicio;
    private LocalDateTime fechaHoraInicio;
    private String nombreIps;
    private String nombreMedico;

    public DisponibilidadSlot(String nombreServicio,
                              LocalDateTime fechaHoraInicio,
                              String nombreIps,
                              String nombreMedico) {
        this.nombreServicio   = nombreServicio;
        this.fechaHoraInicio  = fechaHoraInicio;
        this.nombreIps        = nombreIps;
        this.nombreMedico     = nombreMedico;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public String getNombreIps() {
        return nombreIps;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void setNombreIps(String nombreIps) {
        this.nombreIps = nombreIps;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
    
}