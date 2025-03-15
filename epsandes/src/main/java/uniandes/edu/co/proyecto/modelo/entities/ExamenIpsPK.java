package uniandes.edu.co.epsandes.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class ExamenIpsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = false)
    private ExamenDiagnosticoEntity examen;

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    public ExamenIpsPK() {
        ;
    }

    public ExamenIpsPK(ExamenDiagnosticoEntity examen, IpsEntity ips) {
        this.examen = examen;
        this.ips = ips;
    }

    public ExamenDiagnosticoEntity getExamen() {
        return examen;
    }

    public void setExamen(ExamenDiagnosticoEntity examen) {
        this.examen = examen;
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
        ExamenIpsPK other = (ExamenIpsPK) obj;
        return examen.equals(other.examen) && ips.equals(other.ips);
    }

    @Override
    public int hashCode() {
        return examen.hashCode() + ips.hashCode();
    }
}
