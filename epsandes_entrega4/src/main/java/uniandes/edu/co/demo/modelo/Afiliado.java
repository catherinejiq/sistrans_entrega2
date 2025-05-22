package uniandes.edu.co.demo.modelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "afiliados_collection")
public class Afiliado {

    @Id
    private String idAfiliado; // MongoDB ID interno
    private String tipo; // "contribuyente" o "beneficiario"
    private String tipoDocumento; 
    private String nombre;
    private Date fechaNacimiento;
    private String direccion;

    // Solo si es beneficiario:
    private String parentesco;
    private String idContribuyente;

        // Solo si es contribuyente
    private List<String> beneficiarios;

    public Afiliado() {}

    // Getters y setters

    public String getTipo() { 
        return tipo; 
    }
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }

    public String getIdAfiliado() { 
        return idAfiliado; 
    }
    public void setIdAfiliado(String idAfiliado) { 
        this.idAfiliado= idAfiliado; 
    }

    public String getTipoDocumento() { 
        return tipoDocumento; 
    }
    public void setTipoDocumento(String tipoDocumento) { 
        this.tipoDocumento= tipoDocumento; 
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

    public String getParentesco() { 
        return parentesco; 
    }
    public void setParentesco(String parentesco) { 
        this.parentesco = parentesco; 
    }

    public String getIdContribuyente() { 
        return idContribuyente; 
    }
    public void setIdContribuyente(String idContribuyente) { 
        this.idContribuyente = idContribuyente; 
    }

    public List<String> getBeneficiarios() { 
        return beneficiarios;
    }
    public void setBeneficiarios(List<String> beneficiarios) { 
        this.beneficiarios = beneficiarios;
    }
}
