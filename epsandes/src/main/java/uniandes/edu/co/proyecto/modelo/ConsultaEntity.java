package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;
    String diagnostico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConsulta tipoConsulta;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = true)
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = false)
    private ExamenDiagnosticoEntity diagnosticoRelacionado;

    public ConsultaEntity () {
        ;
    }

    public ConsultaEntity(TipoConsulta tipoConsulta, AfiliadoEntity afiliado,
            ExamenDiagnosticoEntity diagnosticoRelacionado, String diagnostico) {
        this.tipoConsulta = tipoConsulta;
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

    public ExamenDiagnosticoEntity getDiagnosticoRelacionado() {
        return diagnosticoRelacionado;
    }

    public void setDiagnosticoRelacionado(ExamenDiagnosticoEntity diagnosticoRelacionado) {
        this.diagnosticoRelacionado = diagnosticoRelacionado;
    }
}