package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio_IPS")
public class IpsServicioEntity {

    @EmbeddedId
    private IpsServicioPK id;

    @ManyToOne
    @MapsId("nit")
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioSaludEntity servicio;

    public IpsServicioEntity() {}

    public IpsServicioEntity(IpsEntity ips, ServicioSaludEntity servicio) {
        this.ips = ips;
        this.servicio = servicio;
        this.id = new IpsServicioPK(ips, servicio);
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
