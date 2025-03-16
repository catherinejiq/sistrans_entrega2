package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ServicioIpsEntity;
import uniandes.edu.co.proyecto.modelo.ServicioIpsPK;

@Repository
public interface ServicioIpsRepository extends JpaRepository<ServicioIpsEntity, ServicioIpsPK> {
}

