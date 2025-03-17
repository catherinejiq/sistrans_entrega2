package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class OrdenServicioServiciosPK implements Serializable {
    
    @ManyToOne
    @JoinColumn(name="idOrden",nullable=false,referencedColumnName = "idOrden")
    private OrdenServicioEntity ordenServicioEntity;

    @ManyToOne
    @JoinColumn(name = "idServicio",nullable =false,referencedColumnName = "idServicio")
    private ServicioSaludEntity servicioSaludEntity;

    public OrdenServicioServiciosPK() {
        ;
    }

    public OrdenServicioServiciosPK(OrdenServicioEntity ordenServicioEntity, ServicioSaludEntity servicioSaludEntity) {
        super();
        this.ordenServicioEntity = ordenServicioEntity;
        this.servicioSaludEntity= servicioSaludEntity;
    }

    public OrdenServicioEntity getOrdenServicioEntity() {
        return ordenServicioEntity;
    }

    public void setOrdenServicioEntity(OrdenServicioEntity ordenServicioEntity) {
        this.ordenServicioEntity = ordenServicioEntity;
    }

    public ServicioSaludEntity getServicioSaludEntity() {
        return servicioSaludEntity;
    }

    public void setServicioSaludEntity(ServicioSaludEntity servicioSaludEntity) {
        this.servicioSaludEntity = servicioSaludEntity;
    }
    
}
