package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;

import java.util.List;
import java.util.Optional;

public interface AfiliadoRepository extends MongoRepository<Afiliado, String> {

    // Consultar bebedor por su ID
    @Query("{}")
    List<Afiliado> buscarTodosLosAfiliados();

    // Buscar por ID (_id en Mongo)
    Optional<Afiliado> findByIdAfiliado(String idAfiliado);

}

