package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.MedicoIps;
import uniandes.edu.co.epsandes.modelo.MedicoIpsPK;

@Repository
public interface MedicoIpsRepository extends JpaRepository<MedicoIps, MedicoIpsPK> {
}

