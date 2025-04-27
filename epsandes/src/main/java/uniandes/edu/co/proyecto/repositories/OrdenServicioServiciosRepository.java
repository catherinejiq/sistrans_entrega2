package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ServicioSaludEntity;
import uniandes.edu.co.proyecto.modelo.OrdenServicioServiciosEntity;
import uniandes.edu.co.proyecto.modelo.OrdenServicioServiciosPK;

public interface OrdenServicioServiciosRepository extends JpaRepository<OrdenServicioServiciosEntity, OrdenServicioServiciosPK> {

    @Query(value = "SELECT * FROM Orden_Servicio", nativeQuery = true)
    Collection<OrdenServicioServiciosEntity> darOrdenServicioServicios();

    @Query(value = "SELECT * FROM Orden_Servicio WHERE idOrden = :idOrden AND idServicio = :idServicio", nativeQuery = true)
    OrdenServicioServiciosEntity darOrdenServicioServicioPorId(@Param("idOrden") Integer idOrden,
                                                               @Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Orden_Servicio WHERE idOrden = :idOrden AND idServicio = :idServicio", nativeQuery = true)
    void eliminarOrdenServicioServicio(@Param("idOrden") Integer idOrden,
                                       @Param("idServicio") Integer idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Orden_Servicio SET idOrden = :idOrden_actualizado, idServicio = :idServicio_actualizado " +
                   "WHERE idOrden = :idOrden AND idServicio = :idServicio", nativeQuery = true)
    void actualizarOrdenServicioServicio(@Param("idOrden") Integer idOrden,
                                         @Param("idServicio") Integer idServicio,
                                         @Param("idOrden_actualizado") Integer idOrden_actualizado,
                                         @Param("idServicio_actualizado") Integer idServicio_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (:idOrden, :idServicio)", 
           nativeQuery = true)
    void insertarOrdenServicioServicio(@Param("idOrden") Integer idOrden, 
                                      @Param("idServicio") Integer idServicio);
}

