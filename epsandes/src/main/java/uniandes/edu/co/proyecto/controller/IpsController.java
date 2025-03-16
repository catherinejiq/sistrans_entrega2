package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.IpsEntity;
import uniandes.edu.co.proyecto.repositories.IpsRepository;

import java.util.Collection;

@RestController
public class IpsController {

    @Autowired
    private IpsRepository ipsRepository;

    /**
     * Obtener todas las IPS
     */
    @GetMapping("/ips")
    public ResponseEntity<Collection<IpsEntity>> obtenerTodasIps() {
        try {
            Collection<IpsEntity> ips = ipsRepository.darIps();
            return ResponseEntity.ok(ips);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Obtener una IPS por NIT
     */
    @GetMapping("/ips/{nit}")
    public ResponseEntity<?> obtenerIpsPorNit(@PathVariable Integer nit) {
        try {
            IpsEntity ips = ipsRepository.darIpsPorNit(nit);
            if (ips != null) {
                return ResponseEntity.ok(ips);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("IPS no encontrada");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Registrar una nueva IPS
     */
    @PostMapping("/ips/new/save")
    public ResponseEntity<String> registrarIps(@RequestBody IpsEntity ips) {
        try {
            ipsRepository.insertarIps(ips.getNit(), ips.getNombre(), ips.getDireccion(), ips.getTelefono(), ips.getHorario());
            return new ResponseEntity<>("IPS creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la IPS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualizar una IPS existente
     */
    @PostMapping("/ips/{nit}/edit/save")
    public ResponseEntity<String> actualizarIps(@PathVariable Integer nit, @RequestBody IpsEntity ips) {
        try {
            ipsRepository.actualizarIps(nit, ips.getNombre(), ips.getDireccion(), ips.getTelefono(), ips.getHorario());
            return new ResponseEntity<>("IPS actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la IPS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Eliminar una IPS por NIT
     */
    @GetMapping("/ips/{nit}/delete")
    public ResponseEntity<String> eliminarIps(@PathVariable Integer nit) {
        try {
            ipsRepository.eliminarIps(nit);
            return new ResponseEntity<>("IPS eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la IPS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
