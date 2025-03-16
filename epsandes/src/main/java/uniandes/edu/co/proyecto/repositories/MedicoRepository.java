package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.MedicoEntity;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {
}

