package uniandes.edu.co.demo.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "medicos_collection")
@ToString
public class Medico {

    @Id
    private String idMedico; 
    private String identificacion;
    private String nombre;
    private String numRegistro;
    private String especialidad;

    public Medico() {}

    public Medico(String idMedico, String identificacion, String nombre, String numRegistro, String especialidad) {
        this.idMedico = idMedico;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.numRegistro = numRegistro;
        this.especialidad = especialidad;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
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
}