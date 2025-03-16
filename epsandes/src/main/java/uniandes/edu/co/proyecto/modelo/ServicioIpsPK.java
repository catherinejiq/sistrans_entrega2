package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.persistence.Embeddable;


@Embeddable
public class ServicioIpsPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioEntity servicio;

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    public ServicioIpsPK() {
        ;
    }

    public ServicioIpsPK(ServicioEntity servicio, IpsEntity ips) {
        this.servicio = servicio;
        this.ips = ips;
    }

    public ServicioEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioEntity Servicio) {
        this.servicio = Servicio;
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
        ServicioIpsPK other = (ServicioIpsPK) obj;
        return servicio.equals(other.servicio) && ips.equals(other.ips);
    }
}

