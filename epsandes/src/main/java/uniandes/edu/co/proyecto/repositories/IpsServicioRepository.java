package uniandes.edu.co.proyecto.repositories;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.IpsServicioEntity;
import uniandes.edu.co.proyecto.modelo.IpsServicioPK;

public interface IpsServicioRepository extends JpaRepository<IpsServicioEntity, IpsServicioPK> {

    @Query(value = "SELECT * FROM IPS_SERVICIO", nativeQuery = true)
    Collection<IpsServicioEntity> getIpsServicios();

    @Query(value = "SELECT * FROM IPS_SERVICIO WHERE IPSS = :ips AND idServicio = :idServicio", nativeQuery = true)
    IpsServicioEntity getIpsServicio(@Param("ips") Integer ips, @Param("idServicio") Integer servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO IPS_SERVICIO (IPSS, idServicio) VALUES (:ips, :idServicio)", nativeQuery = true)
    void insertIpsServicio(@Param("ips") Integer ips, @Param("idServicio") Integer servicio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM IPS_SERVICIO WHERE IPSS = :ips AND idServicio = :idServicio", nativeQuery = true)
    void deleteIpsServicio(@Param("ips") Integer ips, @Param("idServicio") Integer servicio);
}

