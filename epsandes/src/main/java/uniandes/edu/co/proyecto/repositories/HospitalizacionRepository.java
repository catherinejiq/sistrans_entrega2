package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.HospitalizacionEntity;

public interface HospitalizacionRepository extends JpaRepository<HospitalizacionEntity, Integer> {

    @Query(value = "SELECT * FROM Hospitalizaciones", nativeQuery = true)
    Collection<HospitalizacionEntity> darHospitalizaciones();

    @Query(value = "SELECT * FROM Hospitalizaciones WHERE id = :id", nativeQuery = true)
    HospitalizacionEntity darHospitalizacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Hospitalizaciones SET estado = :estado, tratamiento = :tratamiento WHERE id = :id", nativeQuery = true)
    void actualizarHospitalizacion(@Param("id") int id,
                                   @Param("estado") String estado,
                                   @Param("tratamiento") String tratamiento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Hospitalizaciones WHERE id = :id", nativeQuery = true)
    void eliminarHospitalizacion(@Param("id") int id);
}