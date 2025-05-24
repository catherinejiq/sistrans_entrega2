package uniandes.edu.co.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.demo.modelo.Afiliado;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AfiliadoRepository extends MongoRepository<Afiliado, String> {

    // Consultar bebedor por su ID
    @Query("{}")
    List<Afiliado> buscarTodosLosAfiliados();

    // Buscar por ID (_id en Mongo)
    Optional<Afiliado> findByIdAfiliado(String idAfiliado);

    @Query("{idAfiliado:?0}")
    List<Afiliado> buscarPorId(String idAfiliado);

    @Query("{idAfiliado:?0}")
    @Update("{ $set: { tipo: ?1, tipoDocumento: ?2, nombre: ?3, fechaNacimiento: ?4, direccion: ?5, parentesco: ?6, idContribuyente: ?7 } }")
    void actualizarAfiliadoBeneficiario(String idAfiliado, String tipo, String tipoDocumento, String nombre, Date fechaNacimiento, String direccion, String parentesco, String idContribuyente);

    @Query("{idAfiliado:?0}")
    @Update("{ $set: { tipo: ?1, tipoDocumento: ?2, nombre: ?3, fechaNacimiento: ?4, direccion: ?5, beneficiarios: ?6 } }")
    void actualizarAfiliadoContribuyente(String idAfiliado, String tipo, String tipoDocumento, String nombre, Date fechaNacimiento, String direccion, List<String> beneficiarios);
     
    @Query(value ="{ idAfiliado: ?0}", delete = true)
    void eliminarAfiliado(String idAfiliado);
}

