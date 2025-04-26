package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "IPS_SERVICIO")
public class IpsServicioEntity {

    @EmbeddedId
    private IpsServicioPK pk;

    public IpsServicioEntity() {}

    public IpsServicioEntity(IpsEntity ips, ServicioSaludEntity servicio) {
        this.pk = new IpsServicioPK(ips, servicio);
    }

    public IpsServicioPK getPk() {
        return pk;
    }

    public void setPk(IpsServicioPK pk) {
        this.pk = pk;
    }
}
