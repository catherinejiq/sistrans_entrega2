package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import uniandes.edu.co.proyecto.modelo.ConsultaEntity;

@Entity
@Table(name = "ExamenesDiagnosticos")
public class ExamenDiagnosticoEntity extends ServicioSaludEntity {

    @Column(nullable = false)
    private String resultados;

    @Column(nullable = false)
    private String muestras;

    @ManyToMany
    @JoinTable(
        name = "CONSULTA_EXAMEN",
        joinColumns = @JoinColumn(name = "idExamen"),
        inverseJoinColumns = @JoinColumn(name = "idConsulta")
    )
    private List<ConsultaEntity> consultas = new ArrayList<>();

    public ExamenDiagnosticoEntity() {
        super();
    }

    public ExamenDiagnosticoEntity(Date fecha, String descripcion, String resultados, String muestras) {
        super(fecha, descripcion);
        this.resultados = resultados;
        this.muestras = muestras;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getMuestras() {
        return muestras;
    }

    public void setMuestras(String muestras) {
        this.muestras = muestras;
    }

    public List<ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaEntity> consultas) {
        this.consultas = consultas;
    }
}