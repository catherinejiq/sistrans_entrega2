package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.BeneficiarioEntity;
import uniandes.edu.co.proyecto.modelo.BeneficiarioEntityPK;

public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, BeneficiarioEntityPK> {

    @Query(value = "SELECT * FROM beneficiario", nativeQuery = true)
    Collection<BeneficiarioEntity> getBeneficiarios();

    @Query(value = "SELECT * FROM beneficiario WHERE AFILIADO = :afiliado AND CONTRIBUYENTE = :contribuyente", nativeQuery = true)
    BeneficiarioEntity getBeneficiario(@Param("afiliado") int afiliado, @Param("contribuyente") int contribuyente);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO beneficiario (AFILIADO, CONTRIBUYENTE, PARENTESCO) VALUES (:afiliado, :contribuyente, :parentesco)", nativeQuery = true)
    void insertBeneficiario(@Param("afiliado") int afiliado, @Param("contribuyente") int contribuyente, @Param("parentesco") String parentesco);

    @Modifying
    @Transactional
    @Query(value = "UPDATE beneficiario SET PARENTESCO = :parentesco WHERE AFILIADO = :afiliado AND CONTRIBUYENTE = :contribuyente", nativeQuery = true)
    void updateBeneficiario(@Param("afiliado") int afiliado, @Param("contribuyente") int contribuyente, @Param("parentesco") String parentesco);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM beneficiario WHERE AFILIADO = :afiliado AND CONTRIBUYENTE = :contribuyente", nativeQuery = true)
    void deleteBeneficiario(@Param("afiliado") int afiliado, @Param("contribuyente") int contribuyente);
}
