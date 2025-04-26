package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "CONTRIBUYENTE")
public class ContribuyenteEntity {

    @Id
    @Column(name = "AFILIADO")
    private int id;

    @OneToOne
    @JoinColumn(name = "AFILIADO", referencedColumnName = "idAfiliado", insertable = false, updatable = false)
    private AfiliadoEntity afiliado;

    public ContribuyenteEntity() {}

    public ContribuyenteEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AfiliadoEntity getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(AfiliadoEntity afiliado) {
        this.afiliado = afiliado;
        if (afiliado != null) {
            this.id = afiliado.getIdAfiliado();
        }
    }
}
