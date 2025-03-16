package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.ServicioEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer> {

    @Query("SELECT s FROM ServicioEntity s WHERE s.ordenServicio.idOrden = :idOrden")
    List<ServicioEntity> darServicios();
}
