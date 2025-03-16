package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Examen_IPS")
public class ExamenIpsEntity {

    @EmbeddedId
    private ExamenIpsPK id;

    public ExamenIpsEntity() {
        ;
    }

    public ExamenIpsEntity(ExamenDiagnosticoEntity examen, IpsEntity ips) {
        this.id = new ExamenIpsPK(examen, ips);
    }

    public ExamenIpsPK getId() {
        return id;
    }

    public void setId(ExamenIpsPK id) {
        this.id = id;
    }
}


