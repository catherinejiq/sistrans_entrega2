package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Citas")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "idDisponibilidad", nullable = false, referencedColumnName = "idDisponibilidad")
    private DisponibilidadEntity disponibilidad;

    @ManyToOne
    @JoinColumn(name = "idAfiliado", nullable = false, referencedColumnName = "idAfiliado")
    private AfiliadoEntity afiliado;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;

    public CitaEntity() {
;    }

    public CitaEntity(DisponibilidadEntity disponibilidad, AfiliadoEntity afiliado, LocalDateTime fechaReserva) {
        this.disponibilidad = disponibilidad;
        this.afiliado = afiliado;
        this.fechaReserva = fechaReserva;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public DisponibilidadEntity getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(DisponibilidadEntity disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
