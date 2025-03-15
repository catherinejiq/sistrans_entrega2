package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Hospitalizacion_Medico")
public class HospitalizacionMedico {

    @EmbeddedId
    private HospitalizacionMedicoPK pk;

    public HospitalizacionMedico() {
        ;
    }

    public HospitalizacionMedico(HospitalizacionEntity hospitalizacion, MedicoEntity medico) {
        this.pk = new HospitalizacionMedicoPK(hospitalizacion, medico);
    }

    public HospitalizacionMedicoPK getPk() {
        return pk;
    }

    public void setPk(HospitalizacionMedicoPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "HospitalizacionMedico [hospitalizacion=" + pk.getHospitalizacion().getIdHospitalizacion() +
                ", medico=" + pk.getMedico().getIdMedico() + "]";
    }
}
