package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio_IPS")

public class IpsServicioEntity {

    @EmbeddedId
    private IpsServicioPK id;

    public IpsServicioEntity() {
        ;
    }

    public IpsServicioEntity(IpsEntity ips, ServicioSaludEntity servicio) {
        this.id = new IpsServicioPK(ips, servicio);
    }

    public IpsServicioPK getId() {
        return id;
    }

    public void setId(IpsServicioPK id) {
        this.id = id;
    }
}
