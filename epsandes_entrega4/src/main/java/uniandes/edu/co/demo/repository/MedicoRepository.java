package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.demo.modelo.Medico;
import uniandes.edu.co.demo.modelo.ServicioSalud;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {

    // Obtener todos los médicos (equivalente a findAll)
    @Query("{}")
    List<Medico> buscarTodosLosMedicos();

    // Buscar por ID (_id en Mongo)
    @Query("{ '_id': ?0 }")
    Optional<Medico> buscarPorId(String id);

    Optional<String> findByIdentificacion(String identificacion);

    // Insertar medico
    @Query("{ $insert: { _id: ?0, identificacion: ?1, nombre: ?2, numRegistro: ?3, especialidad: ?4 } }")
    void insertarMedico(int id, String identificacion, String nombre, String numRegistro, String especialidad);

    @Query("{ _id: ?0 }")
    @Update("{ $set: { identificacion: ?1, nombre: ?2, numRegistro: ?3, especialidad: ?4}}")
    void actualizarMedico(int id, String identificacion, String nombre, String numRegistro, String especialidad);  

   // Eliminar un medico por su ID
    @Query(value = "{_id: ?0}", delete = true)
    void eliminarMedicoPorId(int id);
}