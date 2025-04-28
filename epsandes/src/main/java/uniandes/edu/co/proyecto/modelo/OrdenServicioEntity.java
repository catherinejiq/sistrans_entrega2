package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "OrdenServicios")
public class OrdenServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrden;
    private String tipoOrden;
    private String receta;

    @Column(nullable = false)
    private String estado;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false,referencedColumnName ="idAfiliado" )
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false,referencedColumnName = "idMedico")
    private MedicoEntity medico;

    public OrdenServicioEntity() {;
    }

    public OrdenServicioEntity(String tipoOrden, String receta, String estado, LocalDate fecha, AfiliadoEntity afiliado, MedicoEntity medico) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
