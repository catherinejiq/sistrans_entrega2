package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.IpsEntity;

public interface IpsRepository extends JpaRepository<IpsEntity, Integer> {

    @Query(value = "SELECT * FROM IPSS", nativeQuery = true)
    Collection<IpsEntity> darIps();

    @Query(value = "SELECT * FROM IPSS WHERE nit = :nit", nativeQuery = true)
    IpsEntity darIpsPorNit(@Param("nit") int nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPSS (nit, nombre, direccion, telefono, horario) VALUES (:nit, :nombre, :direccion, :telefono, :horario)", nativeQuery = true)
    void insertarIps(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("direccion") String direccion,
                     @Param("telefono") String telefono, @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE IPSS SET nombre = :nombre, direccion = :direccion, telefono = :telefono, horario = :horario WHERE nit = :nit", nativeQuery = true)
    void actualizarIps(@Param("nit") Integer nit, @Param("nombre") String nombre, @Param("direccion") String direccion,
                       @Param("telefono") String telefono, @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPSS WHERE nit = :nit", nativeQuery = true)
    void eliminarIps(@Param("nit") Integer nit);
}