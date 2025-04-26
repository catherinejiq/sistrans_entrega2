package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.IpsServicioEntity;
import uniandes.edu.co.proyecto.repositories.IpsServicioRepository;

@RestController
public class IpsServicioController {

    @Autowired
    private IpsServicioRepository ipsServicioRepository;

    @GetMapping("/ips-servicio")
    public ResponseEntity<Collection<IpsServicioEntity>> obtenerIpsServicios() {
        try {
            Collection<IpsServicioEntity> servicios = ipsServicioRepository.getIpsServicios();
            return ResponseEntity.ok(servicios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/ips-servicio/{ips}/{servicio}")
    public ResponseEntity<IpsServicioEntity> obtenerIpsServicio(@PathVariable("ips") Integer ips, @PathVariable("servicio") Integer servicio) {
        try {
            IpsServicioEntity ipsServicio = ipsServicioRepository.getIpsServicio(ips, servicio);
            if (ipsServicio != null) {
                return ResponseEntity.ok(ipsServicio);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/ips-servicio/new/save")
    public ResponseEntity<String> guardarIpsServicio(@RequestBody IpsServicioEntity ipsServicio) {
        try {
            if (ipsServicio == null || ipsServicio.getPk() == null || ipsServicio.getPk().getIps() == null || ipsServicio.getPk().getServicio() == null) {
                return new ResponseEntity<>("Error: Datos incompletos para crear la relación", HttpStatus.BAD_REQUEST);
            }

            int ipsId = ipsServicio.getPk().getIps().getNit();
            int servicioId = ipsServicio.getPk().getServicio().getIdServicio();
            ipsServicioRepository.insertIpsServicio(ipsId, servicioId);
            return new ResponseEntity<>("IPS-Servicio creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al crear la relación IPS-Servicio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ips-servicio/{ips}/{servicio}/edit/save")
    public ResponseEntity<String> editarIpsServicio(@PathVariable("ips") Integer ips, @PathVariable("servicio") Integer servicio, 
                                                     @RequestBody IpsServicioEntity ipsServicio) {
        try {
            if (ipsServicio == null || ipsServicio.getPk() == null || ipsServicio.getPk().getIps() == null || ipsServicio.getPk().getServicio() == null) {
                return new ResponseEntity<>("Error: Datos incompletos para actualizar la relación", HttpStatus.BAD_REQUEST);
            }

            int ipsId = ipsServicio.getPk().getIps().getNit();
            int servicioId = ipsServicio.getPk().getServicio().getIdServicio();
            ipsServicioRepository.insertIpsServicio(ipsId, servicioId);
            return new ResponseEntity<>("IPS-Servicio actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la relación IPS-Servicio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ips-servicio/{ips}/{servicio}/delete")
    public ResponseEntity<String> eliminarIpsServicio(@PathVariable("ips") Integer ips, 
                                                      @PathVariable("servicio") Integer servicio) {
        try {
            ipsServicioRepository.deleteIpsServicio(ips, servicio);
            return new ResponseEntity<>("IPS-Servicio eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la IPS-Servicio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
