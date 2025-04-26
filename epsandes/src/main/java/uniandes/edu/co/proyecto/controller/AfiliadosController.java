package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;

@RestController
public class AfiliadosController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping("/afiliados")
    public ResponseEntity<Collection<AfiliadoEntity>> getAfiliados() {
        try {
            Collection<AfiliadoEntity> afiliados = afiliadoRepository.darAfiliados();
            return ResponseEntity.ok(afiliados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/afiliados/{idAfiliado}")
    public ResponseEntity<AfiliadoEntity> getAfiliado(@PathVariable("idAfiliado") int idAfiliado) {
        try {
            AfiliadoEntity afiliado = afiliadoRepository.getAfiliado(idAfiliado);
            if (afiliado != null) {
                return ResponseEntity.ok(afiliado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/afiliados/new/save")
    public ResponseEntity<String> saveAfiliado(@RequestBody AfiliadoEntity afiliado) {
        try {
            afiliadoRepository.insertAfiliado(
                afiliado.getIdAfiliado(), 
                afiliado.getTipoDocumento(), 
                afiliado.getNombre(), 
                afiliado.getFechaNacimiento(), 
                afiliado.getDireccion()
            );
            return new ResponseEntity<>("Afiliado creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error detallado en los logs
            return new ResponseEntity<>("Error al crear el afiliado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/afiliados/{idAfiliado}/edit/save")
    public ResponseEntity<String> editAfiliado(@PathVariable("idAfiliado") int idAfiliado, 
                                                @RequestBody AfiliadoEntity afiliado) {
         try {
            afiliadoRepository.updateAfiliado(
                    idAfiliado, 
                    afiliado.getTipoDocumento(),
                    afiliado.getNombre(), 
                    afiliado.getFechaNacimiento(), 
                    afiliado.getDireccion()
            );
            return new ResponseEntity<>("Afiliado actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el afiliado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/afiliados/{idAfiliado}/delete")
    public ResponseEntity<String> deleteAfiliado(@PathVariable("idAfiliado") int idAfiliado) {
        try {
            afiliadoRepository.deleteAfiliado(idAfiliado);
            return new ResponseEntity<>("Afiliado eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el afiliado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
