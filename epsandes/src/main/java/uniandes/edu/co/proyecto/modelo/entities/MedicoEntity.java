package uniandes.edu.co.epsandes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicos")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMedico;
    private String identificacion;
    private String nombre;
    private String numRegistro;
    private String especialidad;



    public MedicoEntity() {
        ;
    }

    public MedicoEntity(String identificacion, String nombre, String numRegistro, String especialidad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.numRegistro = numRegistro;
        this.especialidad = especialidad;
    }

   

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "MedicoEntity [idMedico=" + idMedico + ", identificacion=" + identificacion +
                ", nombre=" + nombre + ", numRegistro=" + numRegistro +
                ", especialidad=" + especialidad + "]";
    }
}

