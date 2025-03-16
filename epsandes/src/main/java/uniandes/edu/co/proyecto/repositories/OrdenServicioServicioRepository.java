package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ServicioEntity;
import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;

import java.util.List;

@Repository
public interface OrdenServicioServicioRepository extends JpaRepository<OrdenServicioEntity, Integer> {

    // Obtener todos los servicios asociados a una orden específica
    @Query("SELECT s FROM ServicioEntity s JOIN s.ordenesServicio o WHERE o.idOrden = :idOrden")
    List<ServicioEntity> obtenerServiciosPorOrden(@Param("idOrden") Integer idOrden);

    // Obtener todas las órdenes asociadas a un servicio específico
    @Query("SELECT o FROM OrdenServicioEntity o JOIN o.servicios s WHERE s.idServicio = :idServicio")
    List<OrdenServicioEntity> obtenerOrdenesPorServicio(@Param("idServicio") Integer idServicio);
}
