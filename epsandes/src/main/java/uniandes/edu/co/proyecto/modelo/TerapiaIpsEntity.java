package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Terapia_IPS")
public class TerapiaIpsEntity {

    @EmbeddedId
    private TerapiaIpsPK id;

    public TerapiaIpsEntity() {
        ;
    }

    public TerapiaIpsEntity(TerapiaEntity terapia, IpsEntity ips) {
        this.id = new TerapiaIpsPK(terapia, ips);
    }

    public TerapiaIpsPK getId() {
        return id;
    }

    public void setId(TerapiaIpsPK id) {
        this.id = id;
    }
}


