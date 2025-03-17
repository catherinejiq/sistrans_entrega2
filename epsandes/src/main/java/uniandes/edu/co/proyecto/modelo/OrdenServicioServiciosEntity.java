package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Orden_Servicio")

public class OrdenServicioServiciosEntity {

    @EmbeddedId
    private OrdenServicioServiciosPK id;

    public OrdenServicioServiciosEntity() {
        ;
    }

    public OrdenServicioServiciosEntity(OrdenServicioEntity ordenServicio, ServicioSaludEntity servicio) {
        this.id = new OrdenServicioServiciosPK(ordenServicio, servicio);
    }

    public OrdenServicioServiciosPK getId() {
        return id;
    }

    public void setId(OrdenServicioServiciosPK id) {
        this.id = id;
    }


}
