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

    @Query(value = "SELECT * FROM Afiliado_Ips", nativeQuery = true)
    Collection<IpsAfiliadoEntity> darIpsAfiliados();

    @Query(value = "SELECT * FROM Afiliado_Ips WHERE idIps = :idIps AND idAfiliado = :idAfiliado", nativeQuery = true)
    IpsAfiliadoEntity darIpsAfiliadoPorId(@Param("idIps") Integer idIps,
                                          @Param("idAfiliado") Integer idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Afiliado_Ips (idIps, idAfiliado) VALUES (:idIps, :idAfiliado)", nativeQuery = true)
    void insertarIpsAfiliado(@Param("idIps") Integer idIps,
                             @Param("idAfiliado") Integer idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Afiliado_Ips WHERE idIps = :idIps AND idAfiliado = :idAfiliado", nativeQuery = true)
    void eliminarIpsAfiliado(@Param("idIps") Integer idIps,
                             @Param("idAfiliado") Integer idAfiliado);
}
