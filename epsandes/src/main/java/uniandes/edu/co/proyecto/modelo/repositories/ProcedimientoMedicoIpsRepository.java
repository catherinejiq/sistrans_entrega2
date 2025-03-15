package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoIpsEntity;
import uniandes.edu.co.epsandes.modelo.ProcedimientoMedicoIpsPK;

@Repository
public interface ProcedimientoMedicoIpsRepository extends JpaRepository<ProcedimientoMedicoIpsEntity, ProcedimientoMedicoIpsPK> {
}

