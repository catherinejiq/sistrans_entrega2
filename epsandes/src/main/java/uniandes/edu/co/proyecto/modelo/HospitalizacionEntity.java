package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "Hospitalizaciones")
public class HospitalizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHospitalizacion;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String tratamiento;

    @OneToOne
    @JoinColumn(name = "idServicio", nullable = false, referencedColumnName = "idServicio")
    private ServicioSaludEntity servicio;

    public HospitalizacionEntity() {
        ;
    }

    public HospitalizacionEntity(String estado, String tratamiento, ServicioSaludEntity servicio) {
        this.estado = estado;
        this.tratamiento = tratamiento;
        this.servicio = servicio;
    }

    public Integer getId() {
        return idHospitalizacion;
    }

    public void setId(Integer id) {
        this.idHospitalizacion = id;
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
}
