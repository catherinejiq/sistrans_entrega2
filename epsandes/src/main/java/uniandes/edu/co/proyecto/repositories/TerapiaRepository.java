package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.TerapiaEntity;

public interface TerapiaRepository extends JpaRepository<TerapiaEntity, Integer> {

    @Query(value = "SELECT * FROM TERAPIAS", nativeQuery = true)
    Collection<TerapiaEntity> darTerapias();

    @Query(value = "SELECT * FROM TERAPIAS WHERE id = :id", nativeQuery = true)
    TerapiaEntity darTerapia(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TERAPIAS SET tipo = :tipo, cantidadSesiones = :cantidadSesiones WHERE id = :id", nativeQuery = true)
    void actualizarTerapia(@Param("id") int id,
                           @Param("tipo") String tipo,
                           @Param("cantidadSesiones") int cantidadSesiones);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TERAPIAS WHERE id = :id", nativeQuery = true)
    void eliminarTerapia(@Param("id") int id);
}