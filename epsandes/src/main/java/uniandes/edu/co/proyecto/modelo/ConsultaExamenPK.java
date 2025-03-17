package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsultaExamenPK implements Serializable{
    

    @ManyToOne
    @JoinColumn(name = "idConsulta",nullable = false,referencedColumnName = "idConsulta")
    private ConsultaEntity consultaEntity;

    @ManyToOne
    @JoinColumn(name = "idExamen",nullable = false,referencedColumnName = "idExamen")
    private ExamenDiagnosticoEntity examenDiagnosticoEntity;

    public ConsultaExamenPK(){
        ;
    }
    
    public ConsultaExamenPK(ConsultaEntity consultaEntity, ExamenDiagnosticoEntity examenDiagnosticoEntity){
        super();
        this.consultaEntity = consultaEntity;
        this.examenDiagnosticoEntity = examenDiagnosticoEntity;
    }

    public ConsultaEntity getConsultaEntity() {
        return consultaEntity;
    }

    public ExamenDiagnosticoEntity getExamenDiagnosticoEntity() {
        return examenDiagnosticoEntity;
    }

    public void setConsultaEntity(ConsultaEntity consultaEntity) {
        this.consultaEntity = consultaEntity;
    }

    public void setExamenDiagnosticoEntity(ExamenDiagnosticoEntity examenDiagnosticoEntity) {
        this.examenDiagnosticoEntity = examenDiagnosticoEntity;
    }
    

}
