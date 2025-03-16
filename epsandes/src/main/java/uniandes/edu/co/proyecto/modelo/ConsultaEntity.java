package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
@Table(name = "CONSULTA")
public class ConsultaEntity extends ServicioSaludEntity {

    @Column(nullable = false)
    private String tipoConsulta;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false)
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private MedicoEntity medico;

    public ConsultaEntity() {
        super();
    }

    public ConsultaEntity(Date fecha, String descripcion, String tipoConsulta,
                            AfiliadoEntity afiliado, MedicoEntity medico) {
        super(fecha, descripcion);
        this.tipoConsulta = tipoConsulta;
        this.afiliado = afiliado;
        this.medico = medico;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }
}

