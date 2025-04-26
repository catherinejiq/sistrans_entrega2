package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AFILIADO")
public class AfiliadoEntity {

    @Id
    @Column(name = "idAfiliado", nullable = false)
    private int idAfiliado;

    @Column(name = "tipoDocumento", nullable = false)
    private String tipoDocumento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    public AfiliadoEntity() {}

    public AfiliadoEntity(int idAfiliado, String tipoDocumento, String nombre, Date fechaNacimiento, String direccion) {
        this.idAfiliado = idAfiliado;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public int getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
