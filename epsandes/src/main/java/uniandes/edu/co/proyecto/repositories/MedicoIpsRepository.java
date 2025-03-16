package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.MedicoIpsEntity;
import uniandes.edu.co.proyecto.modelo.MedicoIpsPK;

public interface MedicoIpsRepository extends JpaRepository<MedicoIpsEntity, MedicoIpsPK> {

    @Query(value = "SELECT * FROM Medico_Ips", nativeQuery = true)
    Collection<MedicoIpsEntity> darMedicoIps();

    @Query(value = "SELECT * FROM Medico_Ips WHERE idMedico = :idMedico AND nit = :nit", nativeQuery = true)
    MedicoIpsEntity darMedicoIpsPorId(@Param("idMedico") Integer idMedico, 
                                      @Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Medico_Ips (idMedico, nit) VALUES (:idMedico, :nit)", nativeQuery = true)
    void insertarMedicoIps(@Param("idMedico") Integer idMedico, 
                           @Param("nit") Integer nit);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Medico_Ips WHERE idMedico = :idMedico AND nit = :nit", nativeQuery = true)
    void eliminarMedicoIps(@Param("idMedico") Integer idMedico, 
                           @Param("nit") Integer nit);
}
