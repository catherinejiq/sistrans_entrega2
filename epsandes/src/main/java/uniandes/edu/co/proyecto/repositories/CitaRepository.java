package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CitaEntity;

public interface CitaRepository extends JpaRepository<CitaEntity, Integer> {

    @Query(value = "SELECT * FROM Citas", nativeQuery = true)
    Collection<CitaEntity> darCitas();

    @Query(value = "SELECT * FROM Citas WHERE idCita = :id", nativeQuery = true)
    CitaEntity darCita(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva) " +
                   "VALUES (:idDisponibilidad, :idAfiliado, TO_TIMESTAMP(:fechaReserva, 'YYYY-MM-DD HH24:MI:SS'))", nativeQuery = true)
    void insertarCita(@Param("idDisponibilidad") int idDisponibilidad,
                      @Param("idAfiliado") int idAfiliado,
                      @Param("fechaReserva") String fechaReserva);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Citas SET idDisponibilidad = :idDisponibilidad, idAfiliado = :idAfiliado, " +
                   "fechaReserva = TO_TIMESTAMP(:fechaReserva, 'YYYY-MM-DD HH24:MI:SS') WHERE idCita = :id", nativeQuery = true)
    void actualizarCita(@Param("id") int id,
                        @Param("idDisponibilidad") int idDisponibilidad,
                        @Param("idAfiliado") int idAfiliado,
                        @Param("fechaReserva") String fechaReserva);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Citas WHERE idCita = :id", nativeQuery = true)
    void eliminarCita(@Param("id") int id);
}
