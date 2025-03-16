package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.TerapiaIpsEntity;
import uniandes.edu.co.proyecto.modelo.TerapiaIpsPK;

@Repository
public interface TerapiaIpsRepository extends JpaRepository<TerapiaIpsEntity, TerapiaIpsPK> {
}

