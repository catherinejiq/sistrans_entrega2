package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.DisponibilidadEntity;

public interface DisponibilidadRepository extends JpaRepository<DisponibilidadEntity, Integer> {

    @Query(value = "SELECT * FROM Disponibilidad", nativeQuery = true)
    Collection<DisponibilidadEntity> darDisponibilidades();

    @Query(value = "SELECT * FROM Disponibilidad WHERE idDisponibilidad = :id", nativeQuery = true)
    DisponibilidadEntity darDisponibilidad(@Param("id") int id);

    @Query(value = "SELECT * FROM Disponibilidad WHERE idServicio = :idServicio", nativeQuery = true)
    Collection<DisponibilidadEntity> darPorServicio(@Param("idServicio") int idServicio);

    @Query(value = "SELECT * FROM Disponibilidad WHERE nitIps = :nitIps", nativeQuery = true)
    Collection<DisponibilidadEntity> darPorIps(@Param("nitIps") long nitIps);

    @Query(value = "SELECT * FROM Disponibilidad WHERE idMedico = :idMedico", nativeQuery = true)
    Collection<DisponibilidadEntity> darPorMedico(@Param("idMedico") int idMedico);

    @Modifying
    @Transactional
    @Query(value =
        "INSERT INTO Disponibilidad " +
        "(idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado) " +
        "VALUES " +
        "(:idServicio, :nitIps, :idMedico, " +
        " TO_TIMESTAMP(:fechaHoraInicio, 'YYYY-MM-DD HH24:MI:SS')," +
        " TO_TIMESTAMP(:fechaHoraFin,   'YYYY-MM-DD HH24:MI:SS')," +
        " :estado)",
        nativeQuery = true)
    void insertarDisponibilidad(
        @Param("idServicio")     int idServicio,
        @Param("nitIps")         long nitIps,
        @Param("idMedico")       int idMedico,
        @Param("fechaHoraInicio") String fechaHoraInicio,
        @Param("fechaHoraFin")    String fechaHoraFin,
        @Param("estado")          String estado
    );

    @Modifying
    @Transactional
    @Query(value =
        "UPDATE Disponibilidad SET " +
        "    idServicio      = :idServicio, " +
        "    nitIps          = :nitIps, " +
        "    idMedico        = :idMedico, " +
        "    fechaHoraInicio = TO_TIMESTAMP(:fechaHoraInicio, 'YYYY-MM-DD HH24:MI:SS'), " +
        "    fechaHoraFin    = TO_TIMESTAMP(:fechaHoraFin,   'YYYY-MM-DD HH24:MI:SS'), " +
        "    estado          = :estado " +
        "WHERE idDisponibilidad = :id",
        nativeQuery = true)
    void actualizarDisponibilidad(
        @Param("id")             int id,
        @Param("idServicio")     int idServicio,
        @Param("nitIps")         long nitIps,
        @Param("idMedico")       int idMedico,
        @Param("fechaHoraInicio") String fechaHoraInicio,
        @Param("fechaHoraFin")    String fechaHoraFin,
        @Param("estado")          String estado
    );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Disponibilidad WHERE idDisponibilidad = :id", nativeQuery = true)
    void eliminarDisponibilidad(@Param("id") int id);
}
