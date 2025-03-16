package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.MedicoIps;
import uniandes.edu.co.proyecto.modelo.MedicoIpsPK;

@Repository
public interface MedicoIpsRepository extends JpaRepository<MedicoIps, MedicoIpsPK> {
}

