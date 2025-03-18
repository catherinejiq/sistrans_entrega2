package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.ServicioSaludEntity;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ServicioSaludRepository extends JpaRepository<ServicioSaludEntity, Integer> {

    @Query(value = "SELECT * FROM ServiciosSalud", nativeQuery = true)
    Collection<ServicioSaludEntity> darServiciosSalud();

    @Query(value = "SELECT * FROM ServiciosSalud WHERE idServicio = :idServicio", nativeQuery = true)
    ServicioSaludEntity darServicioSalud(@Param("idServicio") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) VALUES (SERVICIO_SEQ.nextval, TO_DATE(:fecha, 'YYYY-MM-DD'), :descripcion)", nativeQuery = true)
    void insertarServicioSalud(@Param("fecha") java.util.Date fechaDate, @Param("descripcion") String descripcion);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE ServiciosSalud SET fecha = TO_DATE(:fecha, 'YYYY-MM-DD'), descripcion = :descripcion WHERE idServicio = :idServicio", nativeQuery = true)
    void actualizarServicioSalud(@Param("idServicio") int idServicio,
                                 @Param("fecha") String fecha,
                                 @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ServiciosSalud WHERE idServicio = :idServicio", nativeQuery = true)
    void eliminarServicioSalud(@Param("idServicio") int id);
}
