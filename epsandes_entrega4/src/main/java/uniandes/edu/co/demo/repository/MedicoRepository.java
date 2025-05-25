package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.demo.modelo.Medico;

import java.util.List;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {

    // Obtener todos los médicos (equivalente a findAll)
    @Query("{}")
    List<Medico> buscarTodosLosMedicos();

    @Query("{_id: ?0}")
    List<Medico> buscarPorId(String id);

    // Insertar medico
    @Query("{ $insert: { idMedico: ?0, identificacion: ?1, nombre: ?2, numRegistro: ?3, especialidad: ?4, ips: ?5 } }")
    void insertarMedico(String idMedico, String identificacion, String nombre, String numRegistro, String especialidad, List<Integer> ips);

    @Query("{idMedico:?0}")
    @Update("{ $set: { identificacion: ?1, nombre: ?2, numRegistro: ?3, especialidad: ?4, ips: ?5 } }")
    void actualizarMedico(String idMedico, String identificacion, String nombre, String numRegistro, String especialidad, List<Integer> ips);

   // Eliminar un medico por su ID
    @Query(value = "{idMedico: ?0}", delete = true)
    void eliminarMedicoPorId(String idMedico);
}