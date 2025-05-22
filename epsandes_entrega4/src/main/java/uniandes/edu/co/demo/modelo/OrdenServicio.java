package uniandes.edu.co.demo.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;



@Document(collection = "ordenServicio_collection")
public class OrdenServicio {

    @Id
    private String idOrden;

    private String tipoOrden;
    private String receta;
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private String idAfiliado; // referenciado como String
    private String identificacionMedico;

    // Servicios embebidos
    private List<Integer> servicios;

    // Getters, setters, constructor vacío...

    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(String idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getIdentificacionMedico() {
        return identificacionMedico;
    }

    public void setIdentificacionMedico(String identificacionMedico) {
        this.identificacionMedico = identificacionMedico;
    }

    public List<Integer> getServicios() {
        return servicios;
    }

    public void setServicios(List<Integer> servicios) {
        this.servicios = servicios;
    }
}
