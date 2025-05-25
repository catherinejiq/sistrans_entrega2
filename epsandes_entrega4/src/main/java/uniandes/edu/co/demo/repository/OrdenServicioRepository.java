package uniandes.edu.co.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.OrdenServicio;

public interface OrdenServicioRepository extends MongoRepository<OrdenServicio, String> {
    
    // Obtener todos los médicos (equivalente a findAll)
    @Query("{}")
    List<OrdenServicio> buscarTodasLasOrdenes();

    // Buscar por ID (_id en Mongo)
    @Query("{ '_id': ?0 }")
    List<OrdenServicio> buscarPorId(String id);

    // Insertar orden
    @Query("{ $insert: { idOrden: ?0, tipoOrden: ?1, receta: ?2, estado: ?3, fecha: ?4, idAfiliado: ?5, idMedico: ?6, servicios: ?7 } }")
    void insertarOrden(String idOrden, String tipoOrden, String receta, String estado, String fecha, String idAfiliado, String idMedico, List<Integer> servicios);


    @Query("{ idOrden: ?0 }")
    @Update("{ $set: { tipoOrden: ?1, receta: ?2, estado: ?3, fecha: ?4, idAfiliado: ?5, idMedico: ?6, servicios: ?7}}")
    void actualizarOrden(String idOrden, String tipoOrden, String receta, String estado, LocalDate fecha, String idAfiliado, String idMedico, List<Integer> servicios);

    @Query(value= "{ idOrden: ?0 }", delete = true)
    void eliminarOrdenPorId(String idOrden);






}
