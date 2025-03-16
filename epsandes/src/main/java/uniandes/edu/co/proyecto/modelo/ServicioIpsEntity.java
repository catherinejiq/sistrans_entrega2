package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "SERVICIOS_IPS")
public class ServicioIpsEntity {

    @EmbeddedId
    private ServicioIpsPK id;

    public ServicioIpsEntity() {
        ;
    }

    public ServicioIpsEntity(ServicioEntity servicio, IpsEntity ips) {
        this.id = new ServicioIpsPK(servicio, ips);
    }

    public ServicioIpsPK getId() {
        return id;
    }

    public void setId(ServicioIpsPK id) {
        this.id = id;
    }
}

