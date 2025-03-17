package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class IpsAfiliadoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "nit", nullable = false, referencedColumnName = "nit")
    private IpsEntity ips;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false,referencedColumnName = "idAfiliado")
    private AfiliadoEntity afiliado;

    public IpsAfiliadoPK() {
        ;
    }

    public IpsAfiliadoPK(IpsEntity ips, AfiliadoEntity afiliado) {
        super();
        this.ips = ips;
        this.afiliado = afiliado;
    }

    public IpsEntity getIps() {
        return ips;
    }

    public void setIps(IpsEntity ips) {
        this.ips = ips;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }
}
