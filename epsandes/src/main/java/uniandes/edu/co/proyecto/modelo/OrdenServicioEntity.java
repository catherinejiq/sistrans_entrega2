package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrdenServicios")
public class OrdenServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrden;
    private String tipoOrden;
    private String receta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoOrden estado;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false,referencedColumnName ="idAfiliado" )
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false,referencedColumnName = "idMedico")
    private MedicoEntity medico;

    public OrdenServicioEntity() {;
    }

    public OrdenServicioEntity(String tipoOrden, String receta, EstadoOrden estado, Date fecha, AfiliadoEntity afiliado, MedicoEntity medico) {
        this.tipoOrden = tipoOrden;
        this.receta = receta;
        this.estado = estado;
        this.fecha = fecha;
        this.afiliado = afiliado;
        this.medico = medico;
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
