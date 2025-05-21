package uniandes.edu.co.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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

}