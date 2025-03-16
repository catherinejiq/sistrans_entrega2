package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.HospitalizacionEntity;

@Repository
public interface HospitalizacionRepository extends JpaRepository<HospitalizacionEntity, Integer> {
}

