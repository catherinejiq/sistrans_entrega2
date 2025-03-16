package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoEntity;

public interface ProcedimientoMedicoRepository extends JpaRepository<ProcedimientoMedicoEntity, Integer> {

    @Query(value = "SELECT * FROM ProcedimientosMedicos", nativeQuery = true)
    Collection<ProcedimientoMedicoEntity> darProcedimientosMedicos();

    @Query(value = "SELECT * FROM ProcedimientosMedicos WHERE idServicio = :id", nativeQuery = true)
    ProcedimientoMedicoEntity darProcedimientoMedico(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE ProcedimientosMedicos SET tipo = :tipo, idOrden = :idOrden WHERE idServicio = :id", nativeQuery = true)
    void actualizarProcedimientoMedico(@Param("id") int id,
                                       @Param("tipo") String tipo,
                                       @Param("idOrden") int idOrden);

    // Elimina un procedimiento médico por su id
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ProcedimientosMedicos WHERE idServicio = :id", nativeQuery = true)
    void eliminarProcedimientoMedico(@Param("id") int id);
}
