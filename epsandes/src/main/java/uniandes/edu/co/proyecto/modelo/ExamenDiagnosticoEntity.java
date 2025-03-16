package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "ExamenesDiagnosticos")
public class ExamenDiagnosticoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idExamen;
    private String resultados;
    private String muestras;

    @ManyToOne
    @JoinColumn(name = "idOrden", nullable = false)
    private OrdenServicioEntity ordenServicio;

    public ExamenDiagnostico() {;}

    public ExamenDiagnostico(String resultados, String muestras, OrdenServicioEntity ordenServicio) {
        this.resultados = resultados;
        this.muestras = muestras;
        this.ordenServicio = ordenServicio;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
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

    public OrdenServicioEntity getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(OrdenServicioEntity ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
}