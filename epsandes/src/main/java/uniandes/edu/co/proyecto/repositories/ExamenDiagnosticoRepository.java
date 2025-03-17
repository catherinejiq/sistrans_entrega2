package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.ExamenDiagnosticoEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ExamenDiagnosticoRepository extends JpaRepository<ExamenDiagnosticoEntity, Integer> {

    @Query(value = "SELECT * FROM ExamenesDiagnosticos", nativeQuery = true)
    Collection<ExamenDiagnosticoEntity> darExamenesDiagnosticos();

    @Query(value = "SELECT * FROM ExamenesDiagnosticos WHERE idExamen = :id", nativeQuery = true)
    ExamenDiagnosticoEntity darExamenDiagnostico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO ExamenesDiagnosticos (resultados, muestras, idServicio) VALUES (:resultados, :muestras, :idServicio)", nativeQuery = true)
    void insertarExamenDiagnostico(@Param("resultados") String resultados,
                                   @Param("muestras") String muestras,
                                   @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ExamenesDiagnosticos SET resultados = :resultados, muestras = :muestras, idServicio = :idServicio WHERE idExamen = :id", nativeQuery = true)
    void actualizarExamenDiagnostico(@Param("id") int id,
                                     @Param("resultados") String resultados,
                                     @Param("muestras") String muestras,
                                     @Param("idServicio") int idServicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ExamenesDiagnosticos WHERE idExamen = :id", nativeQuery = true)
    void eliminarExamenDiagnostico(@Param("id") int id);
}
