package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.MedicoAfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.MedicoAfiliadoPK;

public interface MedicoAfiliadoRepository extends JpaRepository<MedicoAfiliadoEntity, MedicoAfiliadoPK> {

    @Query(value = "SELECT * FROM Medico_Afiliado", nativeQuery = true)
    Collection<MedicoAfiliadoEntity> darMedicoAfiliados();

    @Query(value = "SELECT * FROM Medico_Afiliado WHERE idMedico = :idMedico AND idAfiliado = :idAfiliado", nativeQuery = true)
    MedicoAfiliadoEntity darMedicoAfiliadoPorId(@Param("idMedico") Integer idMedico,
                                                @Param("idAfiliado") Integer idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Medico_Afiliado WHERE idMedico = :idMedico AND idAfiliado = :idAfiliado", nativeQuery = true)
    void eliminarMedicoAfiliado(@Param("idMedico") Integer idMedico,
                                 @Param("idAfiliado") Integer idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Medico_Afiliado SET idMedico = :idMedico_actualizado, idAfiliado = :idAfiliado_actualizado "
                 + "WHERE idMedico = :idMedico AND idAfiliado = :idAfiliado", nativeQuery = true)
    void actualizarMedicoAfiliado(@Param("idMedico") Integer idMedico,
                                  @Param("idAfiliado") Integer idAfiliado,
                                  @Param("idMedico_actualizado") Integer idMedico_actualizado,
                                  @Param("idAfiliado_actualizado") Integer idAfiliado_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (:idMedico, :idAfiliado)", nativeQuery = true)
    void insertarMedicoAfiliado(@Param("idMedico") Integer idMedico,
                                @Param("idAfiliado") Integer idAfiliado);
}
