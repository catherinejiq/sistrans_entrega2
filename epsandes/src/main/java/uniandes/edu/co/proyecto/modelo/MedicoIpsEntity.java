package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Medico_Ips")
public class MedicoIpsEntity {

    @EmbeddedId
    private MedicoIpsPK pk;

    public MedicoIpsEntity() {
        ;
    }

    public MedicoIpsEntity(MedicoEntity medico, IpsEntity ips) {
        this.pk = new MedicoIpsPK(medico, ips);
    }

    public MedicoIpsPK getPk() {
        return pk;
    }

    public void setPk(MedicoIpsPK pk) {
        this.pk = pk;
    }
}
