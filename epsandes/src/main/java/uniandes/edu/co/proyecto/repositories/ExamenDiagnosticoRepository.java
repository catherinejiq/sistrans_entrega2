package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ExamenDiagnosticoEntity;

public interface ExamenDiagnosticoRepository extends JpaRepository<ExamenDiagnosticoEntity, Integer> {

    @Query(value = "SELECT * FROM ExamenesDiagnosticos", nativeQuery = true)
    Collection<ExamenDiagnosticoEntity> darExamenesDiagnosticos();
    
    @Query(value = "SELECT * FROM ExamenesDiagnosticos WHERE idExamen = :id", nativeQuery = true)
    ExamenDiagnosticoEntity darExamenDiagnostico(@Param("id") int id);
    

    @Modifying
    @Transactional
    @Query(value = "UPDATE ExamenesDiagnosticos SET resultados = :resultados, muestras = :muestras "
                 + "WHERE idExamen = :id", nativeQuery = true)
    void actualizarExamenDiagnostico(@Param("id") int id,
                                     @Param("resultados") String resultados,
                                     @Param("muestras") String muestras);
    
  
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM ExamenesDiagnosticos WHERE idExamen = :id", nativeQuery = true)
    void eliminarExamenDiagnostico(@Param("id") int id);
}
