package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrdenServicios")
public class OrdenServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrden;
    private String tipoOrden;
    private String receta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoOrden estado;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "idConsulta", nullable = false)
    private ConsultaEntity consulta;

    public OrdenServicioEntity() { }

    public OrdenServicioEntity(String tipoOrden, String receta, EstadoOrden estado, Date fecha, 
                               MedicoEntity medico, ConsultaEntity consulta) {
        this.tipoOrden = tipoOrden;
        this.receta = receta;
        this.estado = estado;
        this.fecha = fecha;
        this.medico = medico;
        this.consulta = consulta;
    }

    

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public ConsultaEntity getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaEntity consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "OrdenServicioEntity [idOrden=" + idOrden + ", tipoOrden=" + tipoOrden +
                ", receta=" + receta + ", estado=" + estado + ", fecha=" + fecha +
                ", medico=" + (medico != null ? medico.getIdMedico() : "NULL") +
                ", consulta=" + (consulta != null ? consulta.getIdConsulta() : "NULL") + "]";
    }
}

