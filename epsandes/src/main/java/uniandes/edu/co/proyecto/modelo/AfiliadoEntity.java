package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder.In;


@Entity
@Table(name = "Afiliados")
public class AfiliadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AFILIADO_SEQ")
    @SequenceGenerator(name = "AFILIADO_SEQ", sequenceName = "AFILIADO_SEQ", allocationSize = 1)
    @Column(name = "idAfiliado", nullable = false, updatable = false)
    private Integer idAfiliado;
    private String tipoDocumento;
    private String nombre;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String parentesco;
    @Column(nullable = true)
    private Integer idContribuyente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAfiliado tipoAfiliado;

    public AfiliadoEntity(String tipoDocumento, String nombre, String fechaNacimiento,
            String direccion, String telefono, TipoAfiliado tipoAfiliado, Integer idContribuyente, String parentesco) {
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoAfiliado = tipoAfiliado;
        this.idContribuyente = idContribuyente;
        this.parentesco = parentesco;
    }
    public AfiliadoEntity() {
        ;
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

    public Integer getIdContribuyente() {
        return idContribuyente;
    }
    public void setIdContribuyente(Integer idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public String getParentesco() {
        return parentesco;
    }
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    @Override
    public String toString() {
    return "AfiliadoEntity [idAfiliado=" + idAfiliado +
           ", tipoDocumento=" + tipoDocumento +
           ", nombre=" + nombre +
           ", fechaNacimiento=" + fechaNacimiento +
           ", direccion=" + direccion +
           ", telefono=" + telefono +
           ", parentesco=" + parentesco +
           ", tipoAfiliado=" + tipoAfiliado + ", idContribuyente=" + idContribuyente + "]";
}
}