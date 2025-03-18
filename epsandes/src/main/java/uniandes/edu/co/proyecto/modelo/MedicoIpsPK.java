package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.persistence.Embeddable;

@Embeddable
public class MedicoIpsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false,referencedColumnName = "idMedico")
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false,referencedColumnName = "nit")
    private IpsEntity ips;

    public MedicoIpsPK() {
        ;
    }

    public MedicoIpsPK(MedicoEntity medico, IpsEntity ips) {
        super();
        this.medico = medico;
        this.ips = ips;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public IpsEntity getIps() {
        return ips;
    }

    public void setIps(IpsEntity ips) {
        this.ips = ips;
    }

}
