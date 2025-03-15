package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ProcedimientoMedico_IPS")
public class ProcedimientoMedicoIpsEntity {

    @EmbeddedId
    private ProcedimientoMedicoIpsPK id;

    public ProcedimientoMedicoIpsEntity() {
        ;
    }

    public ProcedimientoMedicoIpsEntity(ProcedimientoMedicoEntity procedimiento, IpsEntity ips) {
        this.id = new ProcedimientoMedicoIpsPK(procedimiento, ips);
    }

    public ProcedimientoMedicoIpsPK getId() {
        return id;
    }

    public void setId(ProcedimientoMedicoIpsPK id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProcedimientoMedicoIpsEntity [procedimiento=" + id.getProcedimiento().getIdProcedimiento() +
                ", ips=" + id.getIps().getNit() + "]";
    }
}

