package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ProcedimientosMedicos")
public class ProcedimientoMedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcedimiento;
    private String tipo;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicio ordenServicio;

    public ProcedimientoMedico() {;}

    public ProcedimientoMedico(String tipo, Integer cantidad, OrdenServicioEntity ordenServicio) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.ordenServicio = ordenServicio;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
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

    @Override
    public String toString() {
        return "ProcedimientoMedicoEntity [idProcedimiento=" + idProcedimiento + ", tipo=" + tipo +
                ", cantidad=" + cantidad + ", ordenServicio=" +
                (ordenServicio != null ? ordenServicio.getIdOrden() : "NULL") + "]";
    }
}
