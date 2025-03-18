package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.IpsEntity;

import java.util.Collection;

public interface IpsRepository extends JpaRepository<IpsEntity, Integer> {

    @Query(value = "SELECT * FROM IPSs", nativeQuery = true)
    Collection<IpsEntity> darIps();

    @Query(value = "SELECT * FROM IPSs WHERE nit = :nit", nativeQuery = true)
    IpsEntity darIp(@Param("nit") int nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPSS (nit, nombre, direccion, telefono, horario) VALUES (IPS_SEQUENCE.nextval, :nombre, :direccion, :telefono, :horario)", nativeQuery = true)
    void insertarIp(@Param("nombre") String nombre,
                    @Param("direccion") String direccion,
                    @Param("telefono") String telefono,
                    @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE IPSS SET nombre = :nombre, direccion = :direccion, telefono = :telefono, horario = :horario WHERE nit = :nit", nativeQuery = true)
    void actualizarIp(@Param("nit") int nit,
                      @Param("nombre") String nombre,
                      @Param("direccion") String direccion,
                      @Param("telefono") String telefono,
                      @Param("horario") String horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPSS WHERE nit = :nit", nativeQuery = true)
    void eliminarIp(@Param("nit") int nit);
}