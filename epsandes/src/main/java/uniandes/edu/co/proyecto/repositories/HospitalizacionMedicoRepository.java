package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.HospitalizacionMedico;
import uniandes.edu.co.proyecto.modelo.HospitalizacionMedicoPK;

@Repository
public interface HospitalizacionMedicoRepository extends JpaRepository<HospitalizacionMedico, HospitalizacionMedicoPK> {
}

