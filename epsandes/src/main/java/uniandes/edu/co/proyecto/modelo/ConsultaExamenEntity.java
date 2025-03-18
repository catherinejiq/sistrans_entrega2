package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consulta_Examen")
public class ConsultaExamenEntity {
    
    @EmbeddedId
    private ConsultaExamenPK pk;

    public  ConsultaExamenEntity(){
        ;
    }
    public ConsultaExamenEntity(ConsultaEntity consultaEntity, ExamenDiagnosticoEntity examenDiagnosticoEntity){

        this.pk = new ConsultaExamenPK(consultaEntity,examenDiagnosticoEntity);

    }
    public ConsultaExamenPK getPk() {
        return pk;
    }
    public void setPk(ConsultaExamenPK pk) {
        this.pk = pk;
    }
    
}
