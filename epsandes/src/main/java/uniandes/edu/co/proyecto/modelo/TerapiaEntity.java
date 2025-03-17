package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Terapias")
public class TerapiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTerapia;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer cantidadSesiones;

    @OneToOne
    @JoinColumn(name = "idServicio", nullable = false,referencedColumnName = "idServicio")
    private ServicioSaludEntity servicio;

    public TerapiaEntity() {
        ;
    }

    public TerapiaEntity(String tipo, Integer cantidadSesiones, ServicioSaludEntity servicio) {
        this.tipo = tipo;
        this.cantidadSesiones = cantidadSesiones;
        this.servicio = servicio;
    }

    public Integer getId() {
        return idTerapia;
    }

    public void setId(Integer id) {
        this.idTerapia = id;
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

    public ServicioSaludEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSaludEntity servicio) {
        this.servicio = servicio;
    }
}

