package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "Consultas")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsulta;

    @Column(nullable = false)
    private String tipoConsulta;

    @OneToOne
    @JoinColumn(name = "idServicio", nullable = false, referencedColumnName = "idServicio")
    private ServicioSaludEntity servicio;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false,referencedColumnName = "idMedico")
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false,referencedColumnName = "idAfiliado")
    private AfiliadoEntity afiliado;

    public ConsultaEntity() {
        ;
    }

    public ConsultaEntity(String tipoConsulta, ServicioSaludEntity servicio, MedicoEntity medico, AfiliadoEntity afiliado) {
        this.tipoConsulta = tipoConsulta;
        this.servicio = servicio;
        this.medico = medico;
        this.afiliado = afiliado;
    }

    public Integer getId() {
        return idConsulta;
    }

    public void setId(Integer id) {
        this.idConsulta = id;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public ServicioSaludEntity getServicio() {
        return servicio;
    }

    public void setServicio(ServicioSaludEntity servicio) {
        this.servicio = servicio;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }
}

