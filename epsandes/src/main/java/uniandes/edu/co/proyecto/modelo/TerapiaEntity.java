package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "TERAPIA")
public class TerapiaEntity extends ServicioSaludEntity {

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer cantidadSesiones;

    public TerapiaEntity() {
        super();
    }

    public TerapiaEntity(Date fecha, String descripcion, String tipo, Integer cantidadSesiones) {
        super(fecha, descripcion);
        this.tipo = tipo;
        this.cantidadSesiones = cantidadSesiones;
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
}
