package uniandes.edu.co.proyecto.modelo;

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
}
