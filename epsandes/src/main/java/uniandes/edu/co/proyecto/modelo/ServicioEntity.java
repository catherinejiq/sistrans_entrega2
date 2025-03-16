package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "SERVICIOSSALUD")
public class ServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Integer idServicio;
    private String tipo;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicioEntity ordenServicio;

    public ServicioEntity() {}

    public ServicioEntity(String tipo, String descripcion, OrdenServicioEntity ordenServicio) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ordenServicio = ordenServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OrdenServicioEntity getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioEntity ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
}
