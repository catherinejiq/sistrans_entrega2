package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class MedicoAfiliadoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false,referencedColumnName = "idMedico")
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false,referencedColumnName = "idAfiliado")
    private AfiliadoEntity afiliado;

    public MedicoAfiliadoPK() {
        ;
    }

    public MedicoAfiliadoPK(MedicoEntity medico, AfiliadoEntity afiliado) {
        super();
        this.medico = medico;
        this.afiliado = afiliado;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }
}
