package uniandes.edu.co.proyecto.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;

public interface AfiliadoRepository extends JpaRepository<AfiliadoEntity, Integer> {

    @Query(value = "SELECT * FROM AFILIADO", nativeQuery = true)
    Collection<AfiliadoEntity> darAfiliados();

    @Query(value = "SELECT * FROM AFILIADO WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    AfiliadoEntity getAfiliado(@Param("idAfiliado") int idAfiliado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AFILIADO (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) VALUES (:idAfiliado, :tipoDocumento, :nombre, :fechaNacimiento, :direccion)", nativeQuery = true)
    void insertAfiliado(@Param("idAfiliado") int idAfiliado, 
                          @Param("tipoDocumento") String tipoDocumento, 
                          @Param("nombre") String nombre, 
                          @Param("fechaNacimiento") Date fechaNacimiento, 
                          @Param("direccion") String direccion); 

    @Modifying
    @Transactional
    @Query(value = "UPDATE AFILIADO SET tipoDocumento = :tipoDocumento, nombre = :nombre, fechaNacimiento = :fechaNacimiento, direccion = :direccion WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    void updateAfiliado(@Param("idAfiliado") int idAfiliado, 
                            @Param("tipoDocumento") String tipoDocumento, 
                            @Param("nombre") String nombre, 
                            @Param("fechaNacimiento") Date fechaNacimiento, 
                            @Param("direccion") String direccion); 

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM AFILIADO WHERE idAfiliado = :idAfiliado", nativeQuery = true)
    void deleteAfiliado(@Param("idAfiliado") int idAfiliado);
}
