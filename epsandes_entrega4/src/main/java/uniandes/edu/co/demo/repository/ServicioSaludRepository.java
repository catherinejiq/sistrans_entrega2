package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.demo.modelo.ServicioSalud;


import java.util.List;
import java.util.Optional;

@Repository
public interface ServicioSaludRepository extends MongoRepository<ServicioSalud, String> {

    // Obtener todos los médicos (equivalente a findAll)
    @Query("{}")
    List<ServicioSalud> buscarTodosLosServicios();

    Optional<ServicioSalud> findByIdServicio(Integer idServicio);
}