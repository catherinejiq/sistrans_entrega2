package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiario")
public class BeneficiarioEntity {

    @EmbeddedId
    private BeneficiarioEntityPK pk;

    @Column(name = "parentesco", nullable = false, length = 50)
    private String parentesco;

    public BeneficiarioEntity() {}

    public BeneficiarioEntity(AfiliadoEntity afiliado, AfiliadoEntity contribuyente, String parentesco) {
        this.pk = new BeneficiarioEntityPK(afiliado, contribuyente);
        this.parentesco = parentesco;
    }

    public BeneficiarioEntityPK getPk() {
        return pk;
    }

    public void setPk(BeneficiarioEntityPK pk) {
        this.pk = pk;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "afiliado=" + (pk != null ? pk.getAfiliado().getIdAfiliado() : "null") +
                ", contribuyente=" + (pk != null ? pk.getContribuyente().getIdAfiliado() : "null") +
                ", parentesco='" + parentesco + '\'' +
                '}';
    }
}
