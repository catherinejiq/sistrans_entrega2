package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Hospitalizaciones")
public class HospitalizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String tratamiento;

    @OneToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioSaludEntity servicio;

    @ManyToMany
    @JoinTable(
        name = "HOSPITALIZACION_MEDICO",
        joinColumns = @JoinColumn(name = "idHospitalizacion"),
        inverseJoinColumns = @JoinColumn(name = "idMedico")
    )
    private List<MedicoEntity> medicos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "HOSPITALIZACION_AFILIADO",
        joinColumns = @JoinColumn(name = "idHospitalizacion"),
        inverseJoinColumns = @JoinColumn(name = "idAfiliado")
    )
    private List<AfiliadoEntity> afiliados = new ArrayList<>();

    public HospitalizacionEntity() {
    }

    public HospitalizacionEntity(String estado, String tratamiento, ServicioSaludEntity servicio) {
        this.estado = estado;
        this.tratamiento = tratamiento;
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public ServicioSaludEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSaludEntity servicio) {
        this.servicio = servicio;
    }

    public List<MedicoEntity> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoEntity> medicos) {
        this.medicos = medicos;
    }

    public List<AfiliadoEntity> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<AfiliadoEntity> afiliados) {
        this.afiliados = afiliados;
    }
}
