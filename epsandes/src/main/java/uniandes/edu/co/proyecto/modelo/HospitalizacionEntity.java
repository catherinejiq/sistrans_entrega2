package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Hospitalizaciones")
public class HospitalizacionEntity extends ServicioSaludEntity {
    
    private String estado;  
    private String tratamiento;

    @ManyToMany
    @JoinTable(
        name = "AFILIADO_HOSPITALIZACION",
        joinColumns = @JoinColumn(name = "idHospitalizacion"),
        inverseJoinColumns = @JoinColumn(name = "idAfiliado")
    )
    private List<AfiliadoEntity> afiliados = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "MEDICO_HOSPITALIZACION",
        joinColumns = @JoinColumn(name = "idHospitalizacion"),
        inverseJoinColumns = @JoinColumn(name = "idMedico")
    )
    private List<MedicoEntity> medicos = new ArrayList<>();

    public HospitalizacionEntity() {
        super();
    }

    public HospitalizacionEntity(Date fecha, String descripcion, String estado, String tratamiento) {
        super(fecha, descripcion);
        this.estado = estado;
        this.tratamiento = tratamiento;
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

    public List<AfiliadoEntity> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(List<AfiliadoEntity> afiliados) {
        this.afiliados = afiliados;
    }

    public List<MedicoEntity> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoEntity> medicos) {
        this.medicos = medicos;
    }

    public Integer getIdHospitalizacion() {
        return idHospitalizacion;
    }
    public void setIdHospitalizacion(Integer idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

}