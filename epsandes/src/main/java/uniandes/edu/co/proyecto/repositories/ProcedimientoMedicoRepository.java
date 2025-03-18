package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

public interface ProcedimientoMedicoRepository extends JpaRepository<ProcedimientoMedicoEntity, Integer> {

    @Query(value = "SELECT * FROM ProcedimientosMedicos", nativeQuery = true)
    Collection<ProcedimientoMedicoEntity> darProcedimientosMedicos();

    @Query(value = "SELECT * FROM ProcedimientosMedicos WHERE idProcedimiento = :id", nativeQuery = true)
    ProcedimientoMedicoEntity darProcedimientoMedico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ProcedimientosMedicos (tipo, idServicio) VALUES (:tipo, :idServicio)", nativeQuery = true)
    void insertarProcedimientoMedico(@Param("tipo") String tipo,
                                     @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ProcedimientosMedicos SET tipo = :tipo, idServicio = :idServicio WHERE idProcedimiento = :id", nativeQuery = true)
    void actualizarProcedimientoMedico(@Param("id") int id,
                                       @Param("tipo") String tipo,
                                       @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ProcedimientosMedicos WHERE idProcedimiento = :id", nativeQuery = true)
    void eliminarProcedimientoMedico(@Param("id") int id);
}
