package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Embeddable
@Table(name = "IPS_SERVICIO")
public class IpsServicioPK {


    @ManyToOne
    @MapsId("nit")
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioSaludEntity servicio;

    public IpsServicioPK() {}

    public IpsServicioPK(IpsEntity ips, ServicioSaludEntity servicio) {
        this.ips = ips;
        this.servicio = servicio;
    }


    public IpsEntity getIps() {
        return ips;
    }

    public void setIps(IpsEntity ips) {
        this.ips = ips;
    }

    public ServicioSaludEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSaludEntity servicio) {
        this.servicio = servicio;
    }
}
