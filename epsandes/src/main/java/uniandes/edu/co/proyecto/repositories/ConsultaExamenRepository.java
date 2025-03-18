package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ConsultaExamenEntity;
import uniandes.edu.co.proyecto.modelo.ConsultaExamenPK;

public interface ConsultaExamenRepository extends JpaRepository<ConsultaExamenEntity, ConsultaExamenPK> {

    @Query(value = "SELECT * FROM Consulta_Examen", nativeQuery = true)
    Collection<ConsultaExamenEntity> darConsultaExamenes();

    @Query(value = "SELECT * FROM Consulta_Examen WHERE idConsulta = :idConsulta AND idExamen = :idExamen", nativeQuery = true)
    ConsultaExamenEntity darConsultaExamenPorId(@Param("idConsulta") Integer idConsulta,
                                                @Param("idExamen") Integer idExamen);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consulta_Examen WHERE idConsulta = :idConsulta AND idExamen = :idExamen", nativeQuery = true)
    void eliminarConsultaExamen(@Param("idConsulta") Integer idConsulta,
                                @Param("idExamen") Integer idExamen);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Consulta_Examen SET idConsulta = :idConsulta_actualizado, idExamen = :idExamen_actualizado "
                 + "WHERE idConsulta = :idConsulta AND idExamen = :idExamen", nativeQuery = true)
    void actualizarConsultaExamen(@Param("idConsulta") Integer idConsulta,
                                  @Param("idExamen") Integer idExamen,
                                  @Param("idConsulta_actualizado") Integer idConsulta_actualizado,
                                  @Param("idExamen_actualizado") Integer idExamen_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consulta_Examen (idConsulta, idExamen) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
    void insertarConsultaExamen(@Param("idConsulta") Integer idConsulta,
                                @Param("idExamen") Integer idExamen);
}
