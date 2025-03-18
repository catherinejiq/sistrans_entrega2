package uniandes.edu.co.proyecto.modelo;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*;

@Entity
@Table(name = "IPSs")
public class IpsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ips_seq")
    @SequenceGenerator(name = "ips_seq", sequenceName = "IPS_SEQUENCE", allocationSize = 1)
    @Column(name = "nit")
    private Integer nit;


    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;


    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;


    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "horario", nullable = false, length = 50)
    private String horario;

    public IpsEntity(String nombre, String direccion, String telefono, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
    }
    public IpsEntity() {
        
    }


    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
