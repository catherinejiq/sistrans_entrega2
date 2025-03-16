package uniandes.edu.co.epsandes.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class ProcedimientoMedicoIpsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idProcedimiento", nullable = false)
    private ProcedimientoMedicoEntity procedimiento;

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    public ProcedimientoMedicoIpsPK() {
        ;
    }

    public ProcedimientoMedicoIpsPK(ProcedimientoMedicoEntity procedimiento, IpsEntity ips) {
        this.procedimiento = procedimiento;
        this.ips = ips;
    }

    public ProcedimientoMedicoEntity getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(ProcedimientoMedicoEntity procedimiento) {
        this.procedimiento = procedimiento;
    }

    public IpsEntity getIps() {
        return ips;
    }

    public void setIps(IpsEntity ips) {
        this.ips = ips;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ProcedimientoMedicoIpsPK other = (ProcedimientoMedicoIpsPK) obj;
        return procedimiento.equals(other.procedimiento) && ips.equals(other.ips);
    }

    @Override
    public int hashCode() {
        return procedimiento.hashCode() + ips.hashCode();
    }
}

