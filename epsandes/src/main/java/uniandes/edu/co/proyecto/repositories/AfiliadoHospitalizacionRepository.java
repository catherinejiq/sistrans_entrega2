package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.AfiliadoHospitalizacionEntity;
import uniandes.edu.co.proyecto.modelo.AfiliadoHospitalizacionPK;

public interface AfiliadoHospitalizacionRepository extends JpaRepository<AfiliadoHospitalizacionEntity, AfiliadoHospitalizacionPK> {

    @Query(value = "SELECT * FROM Hospitalizacion_Afiliado", nativeQuery = true)
    Collection<AfiliadoHospitalizacionEntity> darAfiliadoHospitalizaciones();

    @Query(value = "SELECT * FROM Hospitalizacion_Afiliado WHERE idAfiliado = :idAfiliado AND idHospitalizacion = :idHospitalizacion", nativeQuery = true)
    AfiliadoHospitalizacionEntity darAfiliadoHospitalizacionPorId(@Param("idAfiliado") Integer idAfiliado,
                                                                  @Param("idHospitalizacion") Integer idHospitalizacion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Hospitalizacion_Afiliado WHERE idAfiliado = :idAfiliado AND idHospitalizacion = :idHospitalizacion", nativeQuery = true)
    void eliminarAfiliadoHospitalizacion(@Param("idAfiliado") Integer idAfiliado,
                                         @Param("idHospitalizacion") Integer idHospitalizacion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Hospitalizacion_Afiliado SET idAfiliado = :idAfiliado_actualizado, idHospitalizacion = :idHospitalizacion_actualizado WHERE idAfiliado = :idAfiliado AND idHospitalizacion = :idHospitalizacion", nativeQuery = true)
    void actualizarAfiliadoHospitalizacion(@Param("idAfiliado") Integer idAfiliado,
                                           @Param("idHospitalizacion") Integer idHospitalizacion,
                                           @Param("idAfiliado_actualizado") Integer idAfiliado_actualizado,
                                           @Param("idHospitalizacion_actualizado") Integer idHospitalizacion_actualizado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Hospitalizacion_Afiliado (idAfiliado, idHospitalizacion) VALUES (:idAfiliado, :idHospitalizacion)", nativeQuery = true)
    void insertarAfiliadoHospitalizacion(@Param("idAfiliado") Integer idAfiliado,
                                         @Param("idHospitalizacion") Integer idHospitalizacion);
}
