package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ORDEN_SERVICIO_SERVICIO")
public class OrdenServicioServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRelacion")
    private Integer idRelacion;

    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicioEntity ordenServicio;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioEntity servicio;

    public OrdenServicioServicioEntity() {}

    public OrdenServicioServicioEntity(OrdenServicioEntity ordenServicio, ServicioEntity servicio) {
        this.ordenServicio = ordenServicio;
        this.servicio = servicio;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public OrdenServicioEntity getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioEntity ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public ServicioEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }
}
