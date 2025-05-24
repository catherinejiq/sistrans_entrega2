package uniandes.edu.co.demo.modelo;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas_collection")
public class Cita {
    @Id
    private String id;
    private String disponibilidadId;
    private String afiliadoId;
    private Date   fechaReserva;
    private String ordenId;      

    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDisponibilidadId() { return disponibilidadId; }
    public void setDisponibilidadId(String disponibilidadId) { this.disponibilidadId = disponibilidadId; }

    public String getAfiliadoId() { return afiliadoId; }
    public void setAfiliadoId(String afiliadoId) { this.afiliadoId = afiliadoId; }

    public Date getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(Date fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getOrdenId() { return ordenId; }
    public void setOrdenId(String ordenId) { this.ordenId = ordenId; }
}