package uniandes.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.demo.modelo.Cita;

public interface CitaRepository
    extends MongoRepository<Cita, String> { 

        @Query("{}")
        List<Cita> obtenerCitas();

    }