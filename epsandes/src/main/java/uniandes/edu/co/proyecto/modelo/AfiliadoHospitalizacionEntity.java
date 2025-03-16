package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "AFILIADO_HOSPITALIZACION")
public class AfiliadoHospitalizacionEntity {

    @EmbeddedId
    private AfiliadoHospitalizacionPK id;

    public AfiliadoHospitalizacionEntity() {}

    public AfiliadoHospitalizacionEntity(AfiliadoEntity afiliado, HospitalizacionEntity hospitalizacion) {
        this.id = new AfiliadoHospitalizacionPK(afiliado, hospitalizacion);
    }

    public AfiliadoHospitalizacionPK getId() {
        return id;
    }

    public void setId(AfiliadoHospitalizacionPK id) {
        this.id = id;
    }
}
