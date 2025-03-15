package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConsulta tipoConsulta;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false)
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = false)
    private ExamenEntity diagnosticoRelacionado;

    public Consulta() {
        ;
    }

    public ConsultaEntity(TipoConsulta tipoConsulta, AfiliadoEntity afiliado,
            ExamenEntity diagnosticoRelacionado, String diagnostico) {
        this.tipoConsulta = tipoConsulta;
        this.diagnostico = diagnostico;
        this.afiliado = afiliado;
        this.diagnosticoRelacionado = diagnosticoRelacionado;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }

    public ExamenEntity getDiagnosticoRelacionado() {
        return diagnosticoRelacionado;
    }

    public void setDiagnosticoRelacionado(ExamenEntity diagnosticoRelacionado) {
        this.diagnosticoRelacionado = diagnosticoRelacionado;
    }

    @Override
    public String toString() {
        return "ConsultaEntity [idConsulta=" + idConsulta + ", tipoConsulta=" + tipoConsulta +
                ", fecha=" + fecha + ", diagnostico=" + diagnostico +
                ", afiliado=" + (afiliado != null ? afiliado.getIdAfiliado() : "NULL") +
                ", diagnosticoRelacionado="
                + (diagnosticoRelacionado != null ? diagnosticoRelacionado.getIdDiagnostico() : "NULL") + "]";
    }
}
