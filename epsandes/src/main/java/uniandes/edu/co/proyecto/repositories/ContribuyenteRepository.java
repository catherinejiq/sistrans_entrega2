package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ContribuyenteEntity;

public interface ContribuyenteRepository extends JpaRepository<ContribuyenteEntity, Integer> {

    @Query(value = "SELECT * FROM CONTRIBUYENTE", nativeQuery = true)
    Collection<ContribuyenteEntity> getContribuyentes();

    @Query(value = "SELECT * FROM CONTRIBUYENTE WHERE AFILIADO = :afiliado", nativeQuery = true)
    ContribuyenteEntity getContribuyente(@Param("afiliado") int afiliado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CONTRIBUYENTE (AFILIADO) VALUES (:afiliado)", nativeQuery = true)
    void insertContribuyente(@Param("afiliado") int afiliado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CONTRIBUYENTE WHERE AFILIADO = :afiliado", nativeQuery = true)
    void eliminarContribuyente(@Param("afiliado") int afiliado);

    
}
