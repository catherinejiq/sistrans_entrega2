package uniandes.edu.co.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.TipoAfiliado;

import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface AfiliadoRepository extends JpaRepository<AfiliadoEntity, Integer> {

    @Query(value = "SELECT * FROM Afiliados", nativeQuery = true)
    Collection<AfiliadoEntity> darAfiliados();
    
    @Query(value = "SELECT * FROM Afiliados WHERE idAfiliado = :id", nativeQuery = true)
    AfiliadoEntity darAfiliado(@Param("id") int id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) "
                 + "VALUES (AFILIADO_SEQ.nextval, :tipoDocumento, :nombre, :fechaNacimiento, :direccion, :telefono, :parentesco, :tipoAfiliado, :idContribuyente)", 
           nativeQuery = true)
    void insertarAfiliado(@Param("tipoDocumento") String tipoDocumento,
                          @Param("nombre") String nombre,
                          @Param("fechaNacimiento") String fechaNacimiento,
                          @Param("direccion") String direccion,
                          @Param("telefono") String telefono,
                          @Param("parentesco") String parentesco,
                          @Param("tipoAfiliado") TipoAfiliado tipoAfiliado,
                          @Param("idContribuyente") Integer idContribuyente);
 
    @Modifying
    @Transactional
    @Query(value = "UPDATE Afiliados SET tipoDocumento = :tipoDocumento, nombre = :nombre, fechaNacimiento = TO_DATE(:fechaNacimiento, 'YYYY-MM-DD'), "
                 + "direccion = :direccion, telefono = :telefono, parentesco = :parentesco, tipoAfiliado = :tipoAfiliado, idContribuyente = :idContribuyente "
                 + "WHERE idAfiliado = :id", nativeQuery = true)
    void actualizarAfiliado(@Param("id") int id,
                            @Param("tipoDocumento") String tipoDocumento,
                            @Param("nombre") String nombre,
                            @Param("fechaNacimiento") String fechaNacimiento,
                            @Param("direccion") String direccion,
                            @Param("telefono") String telefono,
                            @Param("parentesco") String parentesco,
                            @Param("tipoAfiliado") String tipoAfiliado,
                            @Param("idContribuyente") Integer idContribuyente);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Afiliados WHERE idAfiliado = :id", nativeQuery = true)
    void eliminarAfiliado(@Param("id") int id);
    
}