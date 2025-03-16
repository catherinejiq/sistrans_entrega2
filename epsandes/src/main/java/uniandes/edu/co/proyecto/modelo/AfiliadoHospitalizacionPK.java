package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AfiliadoHospitalizacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false)
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "idHospitalizacion", nullable = false)
    private HospitalizacionEntity hospitalizacion;

    public AfiliadoHospitalizacionPK() {}

    public AfiliadoHospitalizacionPK(AfiliadoEntity afiliado, HospitalizacionEntity hospitalizacion) {
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
