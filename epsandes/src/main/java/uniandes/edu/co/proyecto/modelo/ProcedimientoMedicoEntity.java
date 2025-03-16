package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "PROCEDIMIENTO_MEDICO")
public class ProcedimientoMedicoEntity extends ServicioSaludEntity {

    @Column(nullable = false)
    private String tipo;

    public ProcedimientoMedicoEntity() {
        super();
    }

    public ProcedimientoMedicoEntity(Date fecha, String descripcion, String tipo) {
        super(fecha, descripcion);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


