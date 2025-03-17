package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class IpsServicioPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "nit", nullable = false,referencedColumnName = "nit")
    private IpsEntity ips;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false,referencedColumnName = "idServicio")
    private ServicioSaludEntity servicio;

    public IpsServicioPK() {
        ;
    }

    public IpsServicioPK(IpsEntity ips, ServicioSaludEntity servicio) {
        super();
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
