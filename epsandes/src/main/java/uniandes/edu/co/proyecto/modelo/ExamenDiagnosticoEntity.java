package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ExamenesDiagnosticos")
public class ExamenDiagnosticoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String resultados;

    @Column(nullable = false)
    private String muestras;

    @OneToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private ServicioSaludEntity servicio;

    @ManyToMany
    @JoinTable(
        name = "EXAMENES_CONSULTA",
        joinColumns = @JoinColumn(name = "idExamen"),
        inverseJoinColumns = @JoinColumn(name = "idConsulta")
    )
    private List<ConsultaEntity> consultas = new ArrayList<>();

    public ExamenDiagnosticoEntity() {
    }

    public ExamenDiagnosticoEntity(String resultados, String muestras, ServicioSaludEntity servicio) {
        this.resultados = resultados;
        this.muestras = muestras;
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ServicioSaludEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSaludEntity servicio) {
        this.servicio = servicio;
    }

    public List<ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaEntity> consultas) {
        this.consultas = consultas;
    }
}



