package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.TerapiaEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TerapiaRepository extends JpaRepository<TerapiaEntity, Integer> {

    @Query(value = "SELECT * FROM Terapias", nativeQuery = true)
    Collection<TerapiaEntity> darTerapias();

    @Query(value = "SELECT * FROM Terapias WHERE idTerapia = :id", nativeQuery = true)
    TerapiaEntity darTerapia(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Terapias (tipo, cantidadSesiones, idServicio) VALUES (:tipo, :cantidadSesiones, :idServicio)", nativeQuery = true)
    void insertarTerapia(@Param("tipo") String tipo,
                         @Param("cantidadSesiones") Integer cantidadSesiones,
                         @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Terapias SET tipo = :tipo, cantidadSesiones = :cantidadSesiones, idServicio = :idServicio WHERE idTerapia = :id", nativeQuery = true)
    void actualizarTerapia(@Param("id") int id,
                           @Param("tipo") String tipo,
                           @Param("cantidadSesiones") Integer cantidadSesiones,
                           @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Terapias WHERE idTerapia = :id", nativeQuery = true)
    void eliminarTerapia(@Param("id") int id);
}
