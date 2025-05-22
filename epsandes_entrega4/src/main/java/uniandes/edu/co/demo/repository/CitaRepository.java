package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.demo.modelo.Cita;

public interface CitaRepository
    extends MongoRepository<Cita, String> { }