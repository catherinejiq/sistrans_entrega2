package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ServiciosSalud")
public class ServicioSaludEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idServicio")
    private Integer idServicio;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany
    @JoinTable(
        name = "SERVICIO_ORDEN",
        joinColumns = @JoinColumn(name = "idServicio"),
        inverseJoinColumns = @JoinColumn(name = "idOrden")
    )
    private List<OrdenServicioEntity> ordenes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "SERVICIO_IPS",
        joinColumns = @JoinColumn(name = "idServicio"),
        inverseJoinColumns = @JoinColumn(name = "nit")
    )
    private List<IpsEntity> ipsList = new ArrayList<>();

    public ServicioSaludEntity() {
    }

    public ServicioSaludEntity(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<OrdenServicioEntity> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenServicioEntity> ordenes) {
        this.ordenes = ordenes;
    }

    public List<IpsEntity> getIpsList() {
        return ipsList;
    }

    public void setIpsList(List<IpsEntity> ipsList) {
        this.ipsList = ipsList;
    }
}


