package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.IpsServicioEntity;
import uniandes.edu.co.proyecto.modelo.IpsServicioPK;

public interface IpsServicioRepository extends JpaRepository<IpsServicioEntity, IpsServicioPK> {

    @Query(value = "SELECT * FROM Servicio_IPS", nativeQuery = true)
    Collection<IpsServicioEntity> darIpsServicios();

    @Query(value = "SELECT * FROM Servicio_IPS WHERE nit = :nit AND idServicio = :idServicio", nativeQuery = true)
    IpsServicioEntity darIpsServicioPorId(@Param("nit") Integer nit, 
                                          @Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicio_IPS (nit, idServicio) VALUES (:nit, :idServicio)", nativeQuery = true)
    void insertarIpsServicio(@Param("nit") Integer nit, 
                             @Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicio_IPS WHERE nit = :nit AND idServicio = :idServicio", nativeQuery = true)
    void eliminarIpsServicio(@Param("nit") Integer nit, 
                             @Param("idServicio") Integer idServicio);
}
