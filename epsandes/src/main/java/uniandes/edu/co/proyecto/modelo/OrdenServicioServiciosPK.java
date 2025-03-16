package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrdenServicioServiciosPK implements Serializable {

    private Integer idOrden;
    private Integer idServicio;

    public OrdenServicioServiciosPK() {}

    public OrdenServicioServiciosPK(Integer idOrden, Integer idServicio) {
        this.idOrden = idOrden;
        this.idServicio = idServicio;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
}
