package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.HospitalizacionEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

public interface HospitalizacionRepository extends JpaRepository<HospitalizacionEntity, Integer> {

    @Query(value = "SELECT * FROM Hospitalizaciones", nativeQuery = true)
    Collection<HospitalizacionEntity> darHospitalizaciones();

    @Query(value = "SELECT * FROM Hospitalizaciones WHERE idHospitalizacion = :id", nativeQuery = true)
    HospitalizacionEntity darHospitalizacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Hospitalizaciones (estado, tratamiento, idServicio) VALUES (:estado, :tratamiento, :idServicio)", nativeQuery = true)
    void insertarHospitalizacion(@Param("estado") String estado,
                                 @Param("tratamiento") String tratamiento,
                                 @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Hospitalizaciones SET estado = :estado, tratamiento = :tratamiento, idServicio = :idServicio WHERE idHospitalizacion = :id", nativeQuery = true)
    void actualizarHospitalizacion(@Param("id") int id,
                                   @Param("estado") String estado,
                                   @Param("tratamiento") String tratamiento,
                                   @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Hospitalizaciones WHERE idHospitalizacion = :id", nativeQuery = true)
    void eliminarHospitalizacion(@Param("id") int id);
}
