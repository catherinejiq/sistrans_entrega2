package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoIpsEntity;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoIpsPK;

@Repository
public interface ProcedimientoMedicoIpsRepository extends JpaRepository<ProcedimientoMedicoIpsEntity, ProcedimientoMedicoIpsPK> {
}

