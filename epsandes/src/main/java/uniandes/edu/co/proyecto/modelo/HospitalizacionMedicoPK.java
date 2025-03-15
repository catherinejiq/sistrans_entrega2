package uniandes.edu.co.epsandes.modelo;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class HospitalizacionMedicoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idHospitalizacion", nullable = false)
    private HospitalizacionEntity hospitalizacion;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private MedicoEntity medico;

    public HospitalizacionMedicoPK() {
        ;
    }

    public HospitalizacionMedicoPK(HospitalizacionEntity hospitalizacion, Medico medico) {
        this.hospitalizacion = hospitalizacion;
        this.medico = medico;
    }

    public HospitalizacionEntity getHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(HospitalizacionEntity hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        HospitalizacionMedicoPK other = (HospitalizacionMedicoPK) obj;
        return hospitalizacion.equals(other.hospitalizacion) && medico.equals(other.medico);
    }

    @Override
    public int hashCode() {
        return hospitalizacion.hashCode() + medico.hashCode();
    }
}
