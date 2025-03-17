package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.ServicioSaludEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ServicioSaludRepository extends JpaRepository<ServicioSaludEntity, Integer> {

    @Query(value = "SELECT * FROM ServiciosSalud", nativeQuery = true)
    Collection<ServicioSaludEntity> darServiciosSalud();

    @Query(value = "SELECT * FROM ServiciosSalud WHERE idServicio = :id", nativeQuery = true)
    ServicioSaludEntity darServicioSalud(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ServiciosSalud (fecha, descripcion) VALUES (TO_DATE(:fecha, 'YYYY-MM-DD'), :descripcion)", nativeQuery = true)
    void insertarServicioSalud(@Param("fecha") String fecha,
                               @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ServiciosSalud SET fecha = TO_DATE(:fecha, 'YYYY-MM-DD'), descripcion = :descripcion WHERE idServicio = :id", nativeQuery = true)
    void actualizarServicioSalud(@Param("id") int id,
                                 @Param("fecha") String fecha,
                                 @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ServiciosSalud WHERE idServicio = :id", nativeQuery = true)
    void eliminarServicioSalud(@Param("id") int id);
}
