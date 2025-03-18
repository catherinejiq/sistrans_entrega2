package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.ConsultaEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {

    @Query(value = "SELECT * FROM Consultas", nativeQuery = true)
    Collection<ConsultaEntity> darConsultas();

    @Query(value = "SELECT * FROM Consultas WHERE idConsulta = :id", nativeQuery = true)
    ConsultaEntity darConsulta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consultas (tipoConsulta, idServicio, idMedico, idAfiliado) VALUES (:tipoConsulta, :idServicio, :idMedico, :idAfiliado)", nativeQuery = true)
    void insertarConsulta(@Param("tipoConsulta") String tipoConsulta,
                          @Param("idServicio") int idServicio,
                          @Param("idMedico") int idMedico,
                          @Param("idAfiliado") int idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Consultas SET tipoConsulta = :tipoConsulta, idServicio = :idServicio, idMedico = :idMedico, idAfiliado = :idAfiliado WHERE idConsulta = :id", nativeQuery = true)
    void actualizarConsulta(@Param("id") int id,
                            @Param("tipoConsulta") String tipoConsulta,
                            @Param("idServicio") int idServicio,
                            @Param("idMedico") int idMedico,
                            @Param("idAfiliado") int idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consultas WHERE idConsulta = :id", nativeQuery = true)
    void eliminarConsulta(@Param("id") int id);
}
