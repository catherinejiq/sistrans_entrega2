package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {

    @Query(value = "SELECT * FROM Medicos", nativeQuery = true)
    Collection<MedicoEntity> darMedicos();

    @Query(value = "SELECT * FROM Medicos WHERE idMedico = :id", nativeQuery = true)
    MedicoEntity darMedico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Medicos (identificacion, nombre, numRegistro, especialidad, nit) "
                 + "VALUES (:identificacion, :nombre, :numRegistro, :especialidad, :nit)", nativeQuery = true)
    void insertarMedico(@Param("identificacion") String identificacion,
                        @Param("nombre") String nombre,
                        @Param("numRegistro") String numRegistro,
                        @Param("especialidad") String especialidad,
                        @Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Medicos SET identificacion = :identificacion, nombre = :nombre, "
                 + "numRegistro = :numRegistro, especialidad = :especialidad, nit = :nit "
                 + "WHERE idMedico = :id", nativeQuery = true)
    void actualizarMedico(@Param("id") int id,
                          @Param("identificacion") String identificacion,
                          @Param("nombre") String nombre,
                          @Param("numRegistro") String numRegistro,
                          @Param("especialidad") String especialidad,
                          @Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Medicos WHERE idMedico = :id", nativeQuery = true)
    void eliminarMedico(@Param("id") int id);
}
