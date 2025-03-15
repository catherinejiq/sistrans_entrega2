package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "TerapiaIpsEntity [terapia=" + id.getTerapia().getIdTerapia() + ", ips=" + id.getIps().getNit() + "]";
    }
}


