package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class TerapiaIpsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idTerapia", nullable = false)
    private TerapiaEntity terapia;

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    public TerapiaIpsPK() {
        ;
    }

    public TerapiaIpsPK(TerapiaEntity terapia, IpsEntity ips) {
        this.terapia = terapia;
        this.ips = ips;
    }

    public TerapiaEntity getTerapia() {
        return terapia;
    }

    public void setTerapia(TerapiaEntity terapia) {
        this.terapia = terapia;
    }

    public IpsEntity getIps() {
        return ips;
    }

    public void setIps(IpsEntity ips) {
        this.ips = ips;
    }
}
