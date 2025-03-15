package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.ExamenDiagnosticoEntity;

@Repository
public interface ExamenDiagnosticoRepository extends JpaRepository<ExamenDiagnosticoEntity, Integer> {
}

