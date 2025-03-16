package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.OrdenServicioEntity;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicioEntity, Integer> {
}

