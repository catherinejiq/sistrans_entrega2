package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Hospitalizaciones")
public class HospitalizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHospitalizacion;
    private String estado;
    private String tratamiento;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false)
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false)
    private IpsEntity ips;

    public HospitalizacionEntity() {
        ;
    }

    public HospitalizacionEntity(String estado, String tratamiento, AfiliadoEntity afiliado, IpsEntity ips) {
        this.estado = estado;
        this.tratamiento = tratamiento;
        this.afiliado = afiliado;
        this.ips = ips;
    }

    public Integer getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(Integer idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
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

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }

    public IpsEntity getIps() {
        return ips;
    }

    public void setIps(IpsEntity ips) {
        this.ips = ips;
    }
}