package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class AfiliadoHospitalizacionPK implements Serializable {


    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false,referencedColumnName ="idAfiliado")
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idHospitalizacion", nullable = false,referencedColumnName = "idHospitalizacion")
    private HospitalizacionEntity hospitalizacion;

    public AfiliadoHospitalizacionPK() {
        ;
    }

    public AfiliadoHospitalizacionPK(AfiliadoEntity afiliado, HospitalizacionEntity hospitalizacion) {
        super();
        this.afiliado = afiliado;
        this.hospitalizacion = hospitalizacion;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }

    public HospitalizacionEntity getHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(HospitalizacionEntity hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }
}
