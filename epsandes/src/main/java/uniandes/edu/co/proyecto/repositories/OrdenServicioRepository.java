package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrdenServicioRepository extends JpaRepository<OrdenServicioEntity, Integer> {

    @Query(value = "SELECT * FROM OrdenServicios", nativeQuery = true)
    Collection<OrdenServicioEntity> darOrdenesServicio();

    @Query(value = "SELECT * FROM OrdenServicios WHERE idOrden = :id", nativeQuery = true)
    OrdenServicioEntity darOrdenServicio(@Param("id") int id);

    // Consulta para obtener órdenes de servicio por afiliado 
    @Query(value = "SELECT * FROM OrdenServicios WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    Collection<OrdenServicioEntity> darOrdenesPorAfiliado(@Param("idAfiliado") int idAfiliado);


    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenServicios SET tipoOrden = :tipoOrden, receta = :receta, estado = :estado, " +
                   "fecha = :fecha, idAfiliado = :idAfiliado, idMedico = :idMedico " +
                   "WHERE idOrden = :idOrden", nativeQuery = true)
    void actualizarOrdenServicio(@Param("idOrden") int id,
                                 @Param("tipoOrden") String tipoOrden,
                                 @Param("receta") String receta,
                                 @Param("estado") String estado,
                                 @Param("fecha") LocalDate fecha,
                                 @Param("idAfiliado") int idAfiliado,
                                 @Param("idMedico") int idMedico);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenServicios WHERE idOrden = :id", nativeQuery = true)
    void eliminarOrdenServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenServicios (tipoOrden, receta, estado, fecha, idAfiliado, idMedico) " +
                   "VALUES (:tipoOrden, :receta, :estado, :fecha, :idAfiliado, :idMedico)", 
           nativeQuery = true)
    void insertarOrdenServicio(@Param("tipoOrden") String tipoOrden,
                              @Param("receta") String receta,
                              @Param("estado") String estado, 
                              @Param("fecha") LocalDate fecha, 
                              @Param("idAfiliado") int idAfiliado,
                              @Param("idMedico") int idMedico);

    @Query(value = "SELECT MAX(idOrden) FROM OrdenServicios", nativeQuery = true)
    int obtenerUltimoId();
}

    

    

