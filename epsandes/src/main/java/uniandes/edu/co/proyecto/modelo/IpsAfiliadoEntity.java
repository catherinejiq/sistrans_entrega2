package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Afiliado_Ips")
public class IpsAfiliadoEntity {

    @EmbeddedId
    private IpsAfiliadoPK id;

    public IpsAfiliadoEntity() {}

    public IpsAfiliadoEntity(IpsEntity ips, AfiliadoEntity afiliado) {
        this.id = new IpsAfiliadoPK(ips, afiliado);
    }

    public IpsAfiliadoPK getId() {
        return id;
    }

    public void setId(IpsAfiliadoPK id) {
        this.id = id;
    }
}
