package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoConsulta tipoConsulta;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    
    @Column(nullable = false)
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false)
    private AfiliadoEntity afiliado;

    
    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = true)
    private ExamenDiagnosticoEntity diagnosticoRelacionado;

    public ConsultaEntity() {
        ;
    }

    public ConsultaEntity(TipoConsulta tipoConsulta, Date fecha, String diagnostico, AfiliadoEntity afiliado,
            ExamenDiagnosticoEntity diagnosticoRelacionado) {
        this.tipoConsulta = tipoConsulta;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "ConsultaEntity [idConsulta=" + idConsulta + ", tipoConsulta=" + tipoConsulta +
                ", fecha=" + fecha + ", diagnostico=" + diagnostico +
                ", afiliado=" + (afiliado != null ? afiliado.getIdAfiliado() : "NULL") +
                ", diagnosticoRelacionado=" +
                (diagnosticoRelacionado != null ? diagnosticoRelacionado.getIdExamen() : "NULL") + "]";
    }
}

