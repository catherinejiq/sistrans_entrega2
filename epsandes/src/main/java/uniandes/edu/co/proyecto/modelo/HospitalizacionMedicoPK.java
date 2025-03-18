package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class HospitalizacionMedicoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idHospitalizacion", nullable = false,referencedColumnName = "idHospitalizacion")
    private HospitalizacionEntity hospitalizacion;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false,referencedColumnName = "idMedico")
    private MedicoEntity medico;

    public HospitalizacionMedicoPK() {
        ;
    }

    public HospitalizacionMedicoPK(HospitalizacionEntity hospitalizacion, MedicoEntity medico) {
        super();
        this.hospitalizacion = hospitalizacion;
        this.medico = medico;
    }

    public HospitalizacionEntity getHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(HospitalizacionEntity hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }
}
