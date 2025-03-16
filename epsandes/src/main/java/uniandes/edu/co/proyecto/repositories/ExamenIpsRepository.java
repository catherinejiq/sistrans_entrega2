package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ExamenIpsEntity;
import uniandes.edu.co.proyecto.modelo.ExamenIpsPK;

@Repository
public interface ExamenIpsRepository extends JpaRepository<ExamenIpsEntity, ExamenIpsPK> {
}