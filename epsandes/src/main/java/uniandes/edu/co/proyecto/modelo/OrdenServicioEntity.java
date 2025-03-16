package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OrdenServicios")
public class OrdenServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrden")
    private Integer idOrden;
    private String tipoOrden;
    private String receta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoOrden estado;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "idConsulta", nullable = false)
    private ConsultaEntity consulta;

    @OneToMany(mappedBy = "ordenServicio", cascade = CascadeType.ALL)
    private List<ServicioEntity> servicios;

    public OrdenServicioEntity() {}

    public OrdenServicioEntity(String tipoOrden, String receta, EstadoOrden estado, Date fecha, MedicoEntity medico, ConsultaEntity consulta) {
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

    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }
}
