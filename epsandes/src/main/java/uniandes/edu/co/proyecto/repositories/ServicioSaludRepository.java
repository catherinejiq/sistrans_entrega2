package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.ServicioSaludEntity;

public interface ServicioSaludRepository extends JpaRepository<ServicioSaludEntity, Integer> {

    @Query(value = "SELECT * FROM ServiciosSalud", nativeQuery = true)
    Collection<ServicioSaludEntity> darServiciosSalud();

    @Query(value = "SELECT * FROM ServiciosSalud WHERE idServicio = :id", nativeQuery = true)
    ServicioSaludEntity darServicioSalud(@Param("id") int id);
}
