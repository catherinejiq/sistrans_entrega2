package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDEN_SERVICIO_SERVICIOS")
public class OrdenServicioServiciosEntity {

    @EmbeddedId
    private OrdenServicioServiciosPK id;

    @ManyToOne
    @MapsId("idOrden")
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicioEntity ordenServicio;

    @ManyToOne
    @MapsId("idServicio")
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioSaludEntity servicio;

    public OrdenServicioServiciosEntity() {}

    public OrdenServicioServiciosEntity(OrdenServicioEntity ordenServicio, ServicioSaludEntity servicio) {
        this.ordenServicio = ordenServicio;
        this.servicio = servicio;
        this.id = new OrdenServicioServiciosPK(ordenServicio.getIdOrden(), servicio.getIdServicio());
    }

    public OrdenServicioServiciosPK getId() {
        return id;
    }

    public void setId(OrdenServicioServiciosPK id) {
        this.id = id;
    }

    public OrdenServicioEntity getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioEntity ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public ServicioSaludEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSaludEntity servicio) {
        this.servicio = servicio;
    }
}
