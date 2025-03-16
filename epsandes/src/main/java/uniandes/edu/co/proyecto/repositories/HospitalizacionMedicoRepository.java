package uniandes.edu.co.epsandes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.epsandes.modelo.HospitalizacionMedico;
import uniandes.edu.co.epsandes.modelo.HospitalizacionMedicoPK;

@Repository
public interface HospitalizacionMedicoRepository extends JpaRepository<HospitalizacionMedico, HospitalizacionMedicoPK> {
}

