package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Medico_Ips")
public class MedicoIps {

    @EmbeddedId
    private MedicoIpsPK pk;

    public MedicoIps() {
        ;
    }

    public MedicoIps(MedicoEntity medico, IpsEntity ips) {
        this.pk = new MedicoIpsPK(medico, ips);
    }

    public MedicoIpsPK getPk() {
        return pk;
    }

    public void setPk(MedicoIpsPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "MedicoIps [medico=" + pk.getMedico().getIdMedico() +
                ", ips=" + pk.getIps().getNit() + "]";
    }
}
