package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Afiliados")

public class AfiliadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAfiliado;
    private String tipoDocumento;
    private String nombre;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAfiliado tipoAfiliado;

    @ManyToOne
    @JoinColumn(name = "idContribuyente", nullable = true)
    private AfiliadoEntity contribuyente;

    public AfiliadoEntity() {
        ;
    }

    public AfiliadoEntity(String tipoDocumento, String nombre, String fechaNacimiento,
            String direccion, String telefono, TipoAfiliado tipoAfiliado, AfiliadoEntity contribuyente) {
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
        this.contribuyente = contribuyente;
    }

    public Integer getIdAfiliado() {
        return idAfiliado;
    }

    public void setIdAfiliado(Integer idAfiliado) {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoAfiliado getTipoAfiliado() {
        return tipoAfiliado;
    }

    public void setTipoAfiliado(TipoAfiliado tipoAfiliado) {
        this.tipoAfiliado = tipoAfiliado;
    }

    public AfiliadoEntity getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(AfiliadoEntity contribuyente) {
        this.contribuyente = contribuyente;
    }
}