package uniandes.edu.co.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.modelo.ServicioSalud;

public interface OrdenServicioRepository extends MongoRepository<OrdenServicio, String> {
    
    // Obtener todos los médicos (equivalente a findAll)
    @Query("{}")
    List<OrdenServicio> buscarTodasLasOrdenes();

    // Buscar por ID (_id en Mongo)
    @Query("{ '_id': ?0 }")
    Optional<OrdenServicio> buscarPorId(String id);

    // Insertar orden
    @Query("{ $insert: { _id: ?0, tipoOrden: ?1, receta: ?2, estado: ?3, fecha: ?4, idMedico: ?5, idAfiliado: ?6, servicios: ?7 } }")
    void insertarMedico(int id, String tipoOrden, String receta, String estado, String fecha, String idMedico, Integer idAfiliado, List<Integer> servicios);

    @Query("{ _id: ?0 }")
    @Update("{ $set: { tipoOrden: ?1, receta: ?2, estado: ?3, fecha: ?4, idMedico: ?5, idAfiliado: ?6, servicios: ?7}}")
    void actualizarMedico(int id, String tipoOrden, String receta, String estado, String fecha, String idMedico, String idAfiliado, List<Integer> servicios);  

   // Eliminar un medico por su ID
    @Query(value = "{_id: ?0}", delete = true)
    void eliminarMedicoPorId(int id);


}
