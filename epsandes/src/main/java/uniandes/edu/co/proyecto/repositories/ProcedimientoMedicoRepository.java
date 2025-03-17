package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoEntity;

public interface ProcedimientoMedicoRepository extends JpaRepository<ProcedimientoMedicoEntity, Integer> {

    @Query(value = "SELECT * FROM PROCEDIMIENTOS_MEDICOS", nativeQuery = true)
    Collection<ProcedimientoMedicoEntity> darProcedimientosMedicos();

    @Query(value = "SELECT * FROM PROCEDIMIENTOS_MEDICOS WHERE id = :id", nativeQuery = true)
    ProcedimientoMedicoEntity darProcedimientoMedico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PROCEDIMIENTOS_MEDICOS SET tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarProcedimientoMedico(@Param("id") int id,
                                       @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PROCEDIMIENTOS_MEDICOS WHERE id = :id", nativeQuery = true)
    void eliminarProcedimientoMedico(@Param("id") int id);
}