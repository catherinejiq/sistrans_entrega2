package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ConsultaEntity;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {

    @Query(value = "SELECT * FROM Consultas", nativeQuery = true)
    Collection<ConsultaEntity> darConsultas();

    @Query(value = "SELECT * FROM Consultas WHERE id = :id", nativeQuery = true)
    ConsultaEntity darConsulta(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Consultas SET tipoConsulta = :tipoConsulta, idAfiliado = :idAfiliado, idMedico = :idMedico WHERE id = :id", nativeQuery = true)
    void actualizarConsulta(@Param("id") int id,
                            @Param("tipoConsulta") String tipoConsulta,
                            @Param("idAfiliado") int idAfiliado,
                            @Param("idMedico") int idMedico);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consultas WHERE id = :id", nativeQuery = true)
    void eliminarConsulta(@Param("id") int id);
}