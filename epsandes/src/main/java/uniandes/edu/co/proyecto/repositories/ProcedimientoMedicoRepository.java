package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoEntity;

@Repository
public interface ProcedimientoMedicoRepository extends JpaRepository<ProcedimientoMedicoEntity, Integer> {
}

