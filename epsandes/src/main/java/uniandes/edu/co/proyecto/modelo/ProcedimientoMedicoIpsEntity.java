package uniandes.edu.co.proyecto.modelo;

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
}

