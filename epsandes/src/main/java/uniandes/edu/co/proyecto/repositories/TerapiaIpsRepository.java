package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.TerapiaIpsEntity;
import uniandes.edu.co.epsandes.modelo.TerapiaIpsPK;

@Repository
public interface TerapiaIpsRepository extends JpaRepository<TerapiaIpsEntity, TerapiaIpsPK> {
}

