package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;

public interface OrdenServicioRepository extends JpaRepository<OrdenServicioEntity, Integer> {

    @Query(value = "SELECT * FROM OrdenServicios", nativeQuery = true)
    Collection<OrdenServicioEntity> darOrdenesServicios();
    
    @Query(value = "SELECT * FROM OrdenServicios WHERE idOrden = :id", nativeQuery = true)
    OrdenServicioEntity darOrdenServicio(@Param("id") int id);
    

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO OrdenServicios (tipoOrden, receta, estado, fecha, idAfiliado, idMedico) " +
                   "VALUES (:tipoOrden, :receta, :estado, TO_DATE(:fecha, 'YYYY-MM-DD'), :idAfiliado, :idMedico)", 
           nativeQuery = true)
    void insertarOrdenServicio(@Param("tipoOrden") String tipoOrden,
                               @Param("receta") String receta,
                               @Param("estado") String estado,
                               @Param("fecha") String fecha,
                               @Param("idAfiliado") int idAfiliado,
                               @Param("idMedico") int idMedico);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrdenServicios SET tipoOrden = :tipoOrden, receta = :receta, estado = :estado, " +
                   "fecha = TO_DATE(:fecha, 'YYYY-MM-DD'), idAfiliado = :idAfiliado, idMedico = :idMedico " +
                   "WHERE idOrden = :id", nativeQuery = true)
    void actualizarOrdenServicio(@Param("id") int id,
                                 @Param("tipoOrden") String tipoOrden,
                                 @Param("receta") String receta,
                                 @Param("estado") String estado,
                                 @Param("fecha") String fecha,
                                 @Param("idAfiliado") int idAfiliado,
                                 @Param("idMedico") int idMedico);
    

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM OrdenServicios WHERE idOrden = :id", nativeQuery = true)
    void eliminarOrdenServicio(@Param("id") int id);
}
