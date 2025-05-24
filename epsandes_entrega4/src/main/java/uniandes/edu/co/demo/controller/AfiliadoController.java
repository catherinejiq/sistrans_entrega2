package uniandes.edu.co.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.repository.AfiliadoRepository;

@RestController
@RequestMapping("/afiliado")
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> crearAfiliado(@RequestBody Afiliado afiliado) {
        if (afiliado.getTipo() == null || afiliado.getIdAfiliado() == null || afiliado.getTipoDocumento() == null || afiliado.getNombre() == null ||
            afiliado.getFechaNacimiento() == null || afiliado.getDireccion() == null) {
            return ResponseEntity.badRequest().body("Campos obligatorios faltantes");
        }

        String idAfiliado = afiliado.getIdAfiliado();
        boolean esBeneficiario = "beneficiario".equals(afiliado.getTipo());
    
        if (esBeneficiario) {
            if (afiliado.getParentesco() == null || afiliado.getIdContribuyente() == null) {
                return ResponseEntity.badRequest().body("Beneficiarios deben tener parentesco e idContribuyente");
            }

            afiliadoRepository.findByIdAfiliado(afiliado.getIdContribuyente()).ifPresentOrElse(contribuyente -> {
                if (contribuyente.getBeneficiarios() == null) {
                    contribuyente.setBeneficiarios(new ArrayList<>());
                }
                if (!contribuyente.getBeneficiarios().contains(idAfiliado)) {
                    contribuyente.getBeneficiarios().add(idAfiliado);
                    afiliadoRepository.save(contribuyente);
                }
            }, () -> {
                System.out.println("Contribuyente con idAfiliado " + afiliado.getIdContribuyente() + " no encontrado.");
            });
        }
        
        afiliadoRepository.save(afiliado);
    
        return ResponseEntity.ok("Afiliado creado correctamente");
    }


        @GetMapping("")
    public ResponseEntity<List<Afiliado>> obtenerTodosLosAfiliados() {
        try {
            List<Afiliado> afiliados = afiliadoRepository.buscarTodosLosAfiliados();
            return ResponseEntity.ok(afiliados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

        @GetMapping("/{id}")
    public ResponseEntity<List<Afiliado>> obtenerAfiliadoPorId(@PathVariable("id") String id) {
        try {
            List<Afiliado> afiliados = afiliadoRepository.buscarPorId(id);
            if (afiliados != null && !afiliados.isEmpty()) {
                return ResponseEntity.ok(afiliados);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
        @PostMapping("/{id}/beneficiario/save")
    public ResponseEntity<String> actualizarAfiliadoBeneficiario(@PathVariable("id") String id, @RequestBody Afiliado afiliado) {
        try {
            afiliadoRepository.actualizarAfiliadoBeneficiario(
                id,
                afiliado.getTipo(),
                afiliado.getTipoDocumento(),
                afiliado.getNombre(),
                afiliado.getFechaNacimiento(),
                afiliado.getDireccion(),
                afiliado.getParentesco(),
                afiliado.getIdContribuyente()
            );
            return new ResponseEntity<>("Afiliado actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el Afiliado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/contribuyente/save")
    public ResponseEntity<String> actualizarAfiliadoContribuyente(@PathVariable("id") String id, @RequestBody Afiliado afiliado) {
        try {
            afiliadoRepository.actualizarAfiliadoContribuyente(
                id,
                afiliado.getTipo(),
                afiliado.getTipoDocumento(),
                afiliado.getNombre(),
                afiliado.getFechaNacimiento(),
                afiliado.getDireccion(),
                afiliado.getBeneficiarios()
            );
            return new ResponseEntity<>("Afiliado actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el Afiliado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarAfiliado(@PathVariable("id") String id) {
        try {
            afiliadoRepository.eliminarAfiliado(id);
            return new ResponseEntity<>("Afiliado eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el Afiliado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}