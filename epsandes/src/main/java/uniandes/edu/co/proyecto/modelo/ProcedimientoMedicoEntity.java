
package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "PROCEDIMIENTOS_MEDICOS")
public class ProcedimientoMedicoEntity extends ServicioSaludEntity {

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer cantidad;
    
    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicioEntity ordenServicio;


    public ProcedimientoMedicoEntity() {
        super();
    }

    public ProcedimientoMedicoEntity(java.util.Date fecha, String descripcion,
                                    String tipo, Integer cantidad, OrdenServicioEntity ordenServicio) {
        super(fecha, descripcion);
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.ordenServicio = ordenServicio;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenServicioEntity getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioEntity ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
}