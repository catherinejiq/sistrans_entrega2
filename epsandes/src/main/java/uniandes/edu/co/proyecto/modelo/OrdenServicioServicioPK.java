package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class OrdenServicioServicioPK implements Serializable {

    @Column(name = "idOrden")
    private Integer idOrden;

    @Column(name = "idServicio")
    private Integer idServicio;

    public OrdenServicioServicioPK() {}

    public OrdenServicioServicioPK(Integer idOrden, Integer idServicio) {
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
