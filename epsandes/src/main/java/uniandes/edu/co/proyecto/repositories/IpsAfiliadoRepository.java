package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.IpsAfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.IpsAfiliadoPK;

public interface IpsAfiliadoRepository extends JpaRepository<IpsAfiliadoEntity, IpsAfiliadoPK> {

    @Query(value = "SELECT * FROM Afiliado_IPS", nativeQuery = true)
    Collection<IpsAfiliadoEntity> darIpsAfiliados();

    @Query(value = "SELECT * FROM Afiliado_IPS WHERE nit = :nit AND idAfiliado = :idAfiliado", nativeQuery = true)
    IpsAfiliadoEntity darIpsAfiliadoPorId(@Param("nit") Integer nit,
                                          @Param("idAfiliado") Integer idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Afiliado_IPS WHERE nit = :nit AND idAfiliado = :idAfiliado", nativeQuery = true)
    void eliminarIpsAfiliado(@Param("nit") Integer nit,
                             @Param("idAfiliado") Integer idAfiliado);

    @Modifying
    @Transactional
    @Query(value =  "UPDATE Afiliado_IPS SET nit =: nit_actualizado, idAfiliado =: id_afiliado_actualizado WHERE nit =: nit AND idAfiliado =: idAfiliado ", nativeQuery = true)
    void actualizarIpsAfiliado(@Param("nit") Integer nit, @Param("idAfiliado") Integer idAfiliado, @Param("nit_actualizado") Integer nit_actualizado, @Param("id_afiliado_actualizado") Integer id_afiliado_actualizado);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Afiliado_IPS (nit, idAfiliado) VALUES (:nit, :idAfiliado)", nativeQuery = true)
    void insertarIpsAfiliado(@Param("nit") Integer nit,
                             @Param("idAfiliado") Integer idAfiliado);
    
}
