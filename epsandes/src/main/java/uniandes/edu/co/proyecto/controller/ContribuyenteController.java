package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ContribuyenteEntity;
import uniandes.edu.co.proyecto.repositories.ContribuyenteRepository;


@RestController
public class ContribuyenteController {

    @Autowired
    private ContribuyenteRepository contribuyenteRepository;

    @GetMapping("/contribuyentes")
    public ResponseEntity<Collection<ContribuyenteEntity>> getContribuyentes() {
        try {
            Collection<ContribuyenteEntity> contribuyentes = contribuyenteRepository.getContribuyentes();
            return ResponseEntity.ok(contribuyentes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/contribuyentes/{afiliado}")
    public ResponseEntity<ContribuyenteEntity> getContribuyente(@PathVariable("afiliado") int afiliado) {
        try {
            ContribuyenteEntity contribuyente = contribuyenteRepository.getContribuyente(afiliado);
            if (contribuyente != null) {
                return ResponseEntity.ok(contribuyente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/contribuyentes/new/save")
    public ResponseEntity<String> saveContribuyente(@RequestBody ContribuyenteEntity contribuyente) {
        try {
            contribuyenteRepository.insertContribuyente(contribuyente.getId());
            return new ResponseEntity<>("Contribuyente creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error detallado en los logs
            return new ResponseEntity<>("Error al crear el contribuyente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contribuyentes/{afiliado}/delete")
    public ResponseEntity<String> deleteContribuyente(@PathVariable("afiliado") int afiliado) {
        try {
            contribuyenteRepository.eliminarContribuyente(afiliado);
            return new ResponseEntity<>("Contribuyente eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el contribuyente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
