package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.HospitalizacionMedico;
import uniandes.edu.co.proyecto.modelo.HospitalizacionMedicoPK;

public interface HospitalizacionMedicoRepository extends JpaRepository<HospitalizacionMedico, HospitalizacionMedicoPK> {

    @Query(value = "SELECT * FROM Hospitalizacion_Medico", nativeQuery = true)
    Collection<HospitalizacionMedico> darHospitalizacionMedicos();

    @Query(value = "SELECT * FROM Hospitalizacion_Medico WHERE idHospitalizacion = :idHospitalizacion AND idMedico = :idMedico", nativeQuery = true)
    HospitalizacionMedico darHospitalizacionMedicoPorId(@Param("idHospitalizacion") Integer idHospitalizacion,
                                                         @Param("idMedico") Integer idMedico);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Hospitalizacion_Medico WHERE idHospitalizacion = :idHospitalizacion AND idMedico = :idMedico", nativeQuery = true)
    void eliminarHospitalizacionMedico(@Param("idHospitalizacion") Integer idHospitalizacion,
                                       @Param("idMedico") Integer idMedico);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Hospitalizacion_Medico SET idHospitalizacion = :idHospitalizacion_actualizado, idMedico = :idMedico_actualizado "
                 + "WHERE idHospitalizacion = :idHospitalizacion AND idMedico = :idMedico", nativeQuery = true)
    void actualizarHospitalizacionMedico(@Param("idHospitalizacion") Integer idHospitalizacion,
                                         @Param("idMedico") Integer idMedico,
                                         @Param("idHospitalizacion_actualizado") Integer idHospitalizacion_actualizado,
                                         @Param("idMedico_actualizado") Integer idMedico_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Hospitalizacion_Medico (idHospitalizacion, idMedico) VALUES (:idHospitalizacion, :idMedico)", nativeQuery = true)
    void insertarHospitalizacionMedico(@Param("idHospitalizacion") Integer idHospitalizacion,
                                       @Param("idMedico") Integer idMedico);
}
