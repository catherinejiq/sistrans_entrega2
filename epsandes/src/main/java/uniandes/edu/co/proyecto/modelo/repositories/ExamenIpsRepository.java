package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.ExamenIpsEntity;
import uniandes.edu.co.epsandes.modelo.ExamenIpsPK;

@Repository
public interface ExamenIpsRepository extends JpaRepository<ExamenIpsEntity, ExamenIpsPK> {
}

