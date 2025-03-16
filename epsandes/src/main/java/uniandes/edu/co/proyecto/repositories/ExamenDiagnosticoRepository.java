package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ExamenDiagnosticoEntity;

@Repository
public interface ExamenDiagnosticoRepository extends JpaRepository<ExamenDiagnosticoEntity, Integer> {
}

