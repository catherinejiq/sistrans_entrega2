package uniandes.edu.co.demo.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.modelo.Disponibilidad;

public interface DisponibilidadRepository
    extends MongoRepository<Disponibilidad, String> {

    
    Optional<Disponibilidad> findByIdAndEstado(String id, String estado);
}