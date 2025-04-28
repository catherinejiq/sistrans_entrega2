package uniandes.edu.co.proyecto.repositories;

import java.time.LocalDateTime;

public interface AgendaDisponibilidad {
    String getNombreServicio();
    LocalDateTime getFechaHoraInicio();
    String getNombreMedico();       
}