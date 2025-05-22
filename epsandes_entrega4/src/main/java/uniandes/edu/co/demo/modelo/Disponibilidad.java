package uniandes.edu.co.demo.modelo;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "disponibilidad_collection")
public class Disponibilidad {
    @Id
    private String id;
    private int    idServicio;
    private int    ipsId;
    private String medicoId;
    private Date   fechaHoraInicio;
    private Date   fechaHoraFin;
    private String estado; 

   
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }

    public int getIpsId() { return ipsId; }
    public void setIpsId(int ipsId) { this.ipsId = ipsId; }

    public String getMedicoId() { return medicoId; }
    public void setMedicoId(String medicoId) { this.medicoId = medicoId; }

    public Date getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(Date fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }

    public Date getFechaHoraFin() { return fechaHoraFin; }
    public void setFechaHoraFin(Date fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
