package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.MedicoEntity;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {

    @Query(value = "SELECT * FROM Medicos", nativeQuery = true)
    Collection<MedicoEntity> darMedicos();

    @Query(value = "SELECT * FROM Medicos WHERE idMedico = :idMedico", nativeQuery = true)
    MedicoEntity darMedico(@Param("idMedico") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Medicos (idMedico, identificacion, nombre, numRegistro, especialidad) VALUES (MEDICO_SEQ.nextval, :identificacion, :nombre, :numRegistro, :especialidad)", nativeQuery = true)
    void insertarMedico(@Param("identificacion") String identificacion,
                         @Param("nombre") String nombre,
                         @Param("numRegistro") String numRegistro,
                         @Param("especialidad") String especialidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Medicos SET identificacion = :identificacion, nombre = :nombre, numRegistro = :numRegistro, especialidad = :especialidad WHERE idMedico = :idMedico", nativeQuery = true)
    void actualizarMedico(@Param("idMedico") int id,
                          @Param("identificacion") String identificacion,
                          @Param("nombre") String nombre,
                          @Param("numRegistro") String numRegistro,
                          @Param("especialidad") String especialidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Medicos WHERE idMedico = :idMedico", nativeQuery = true)
    void eliminarMedico(@Param("id") int id);
}
