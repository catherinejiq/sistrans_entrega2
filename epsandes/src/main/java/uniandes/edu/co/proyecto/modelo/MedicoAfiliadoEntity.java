package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "MEDICO_AFILIADO")
public class MedicoAfiliadoEntity {

    @EmbeddedId
    private MedicoAfiliadoPK id;

    public MedicoAfiliadoEntity() {}

    public MedicoAfiliadoEntity(MedicoEntity medico, AfiliadoEntity afiliado) {
        this.id = new MedicoAfiliadoPK(medico, afiliado);
    }

    public MedicoAfiliadoPK getId() {
        return id;
    }

    public void setId(MedicoAfiliadoPK id) {
        this.id = id;
    }
}
