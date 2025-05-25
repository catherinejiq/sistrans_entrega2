package uniandes.edu.co.demo.modelo;

public class ServicioCustom {

    private String idServicio;
    private String descripcion;
    private int total;

    public ServicioCustom() {
        ;
    }   
    public ServicioCustom(String idServicio, String descripcion, int total) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.total = total;
    }
    public String getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

}