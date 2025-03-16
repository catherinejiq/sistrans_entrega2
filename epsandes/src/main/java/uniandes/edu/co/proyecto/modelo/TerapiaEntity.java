package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Terapias")
public class TerapiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTerapia;
    private String tipo;
    private Integer cantidadSesiones;

    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicioEntity ordenServicio;

    public TerapiaEntity() {;}

    public TerapiaEntity(String tipo, Integer cantidadSesiones, OrdenServicioEntity ordenServicio) {
        this.tipo = tipo;
        this.cantidadSesiones = cantidadSesiones;
        this.ordenServicio = ordenServicio;
    }

    public Integer getIdTerapia() {
        return idTerapia;
    }

    public void setIdTerapia(Integer idTerapia) {
        this.idTerapia = idTerapia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidadSesiones() {
        return cantidadSesiones;
    }

    public void setCantidadSesiones(Integer cantidadSesiones) {
        this.cantidadSesiones = cantidadSesiones;
    }

    public OrdenServicioEntity getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioEntity ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
}