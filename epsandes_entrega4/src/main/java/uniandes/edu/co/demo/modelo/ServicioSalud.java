package uniandes.edu.co.demo.modelo;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

import org.springframework.data.annotation.Id;



@Document(collection = "servicios_collection")
@ToString
public class ServicioSalud {

    @Id
    private String idServicio;
    private LocalDate fecha;
    private String descripcion;

    public ServicioSalud() {
        ;
    }

    public ServicioSalud(String idServicio, LocalDate fecha, String descripcion) {

        this.idServicio = idServicio;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }


    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}


