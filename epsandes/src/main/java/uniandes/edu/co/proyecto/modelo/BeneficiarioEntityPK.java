package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class BeneficiarioEntityPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "AFILIADO", referencedColumnName = "idAfiliado", nullable = false)
    private AfiliadoEntity afiliado;

    @ManyToOne
    @JoinColumn(name = "CONTRIBUYENTE", referencedColumnName = "idAfiliado", nullable = false)
    private AfiliadoEntity contribuyente;

    public BeneficiarioEntityPK() {}

    public BeneficiarioEntityPK(AfiliadoEntity afiliado, AfiliadoEntity contribuyente) {
        this.afiliado = afiliado;
        this.contribuyente = contribuyente;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }

    public AfiliadoEntity getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(AfiliadoEntity contribuyente) {
        this.contribuyente = contribuyente;
    }

}
