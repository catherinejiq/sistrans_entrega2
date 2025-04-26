package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.BeneficiarioEntity;
import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;
import uniandes.edu.co.proyecto.repositories.BeneficiarioRepository;

@RestController
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    // Obtener todos los beneficiarios
    @GetMapping("/beneficiarios")
    public ResponseEntity<Collection<BeneficiarioEntity>> getBeneficiarios() {
        try {
            Collection<BeneficiarioEntity> beneficiarios = beneficiarioRepository.getBeneficiarios();
            return ResponseEntity.ok(beneficiarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Obtener un beneficiario específico
    @GetMapping("/beneficiarios/{idAfiliado}/{idContribuyente}")
    public ResponseEntity<BeneficiarioEntity> getBeneficiario(@PathVariable("idAfiliado") int idAfiliado, 
                                                            @PathVariable("idContribuyente") int idContribuyente) {
        try {
            AfiliadoEntity afiliado = afiliadoRepository.findById(idAfiliado).orElse(null);
            AfiliadoEntity contribuyente = afiliadoRepository.findById(idContribuyente).orElse(null);

            if (afiliado != null && contribuyente != null) {
                BeneficiarioEntity beneficiario = beneficiarioRepository.getBeneficiario(idAfiliado, idContribuyente);
                if (beneficiario != null) {
                    return ResponseEntity.ok(beneficiario);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Crear un nuevo beneficiario
    @PostMapping("/beneficiarios/new/save")
    public ResponseEntity<String> saveBeneficiario(@RequestBody BeneficiarioEntity beneficiario) {
        try {
            AfiliadoEntity afiliado = beneficiario.getPk().getAfiliado();
            AfiliadoEntity contribuyente = beneficiario.getPk().getContribuyente();

            if (afiliadoRepository.existsById(afiliado.getIdAfiliado()) && 
                afiliadoRepository.existsById(contribuyente.getIdAfiliado())) {

                beneficiarioRepository.insertBeneficiario(afiliado.getIdAfiliado(),
                                                           contribuyente.getIdAfiliado(),
                                                           beneficiario.getParentesco());
                return new ResponseEntity<>("Beneficiario creado exitosamente", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Afiliado o contribuyente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error detallado en los logs
            return new ResponseEntity<>("Error al crear el beneficiario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Editar un beneficiario
    @PostMapping("/beneficiarios/{idAfiliado}/{idContribuyente}/edit/save")
    public ResponseEntity<String> editarBeneficiario(@PathVariable("idAfiliado") int idAfiliado, 
                                                     @PathVariable("idContribuyente") int idContribuyente, 
                                                     @RequestBody BeneficiarioEntity beneficiario) {
        try {
            AfiliadoEntity afiliado = afiliadoRepository.findById(idAfiliado).orElse(null);
            AfiliadoEntity contribuyente = afiliadoRepository.findById(idContribuyente).orElse(null);

            if (afiliado != null && contribuyente != null) {
                beneficiarioRepository.updateBeneficiario(idAfiliado, idContribuyente, beneficiario.getParentesco());
                return new ResponseEntity<>("Beneficiario actualizado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Afiliado o contribuyente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el beneficiario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un beneficiario
    @GetMapping("/beneficiarios/{idAfiliado}/{idContribuyente}/delete")
    public ResponseEntity<String> eliminarBeneficiario(@PathVariable("idAfiliado") int idAfiliado, 
                                                       @PathVariable("idContribuyente") int idContribuyente) {
        try {
            AfiliadoEntity afiliado = afiliadoRepository.findById(idAfiliado).orElse(null);
            AfiliadoEntity contribuyente = afiliadoRepository.findById(idContribuyente).orElse(null);

            if (afiliado != null && contribuyente != null) {
                beneficiarioRepository.deleteBeneficiario(idAfiliado, idContribuyente);
                return new ResponseEntity<>("Beneficiario eliminado exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Afiliado o contribuyente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el beneficiario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
