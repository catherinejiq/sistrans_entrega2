package uniandes.edu.co.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.modelo.ServicioSalud;
import uniandes.edu.co.demo.repository.ServicioSaludRepository;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;
import uniandes.edu.co.demo.repository.MedicoRepository;    

@RestController
@RequestMapping("/orden-servicio")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Autowired
    private ServicioSaludRepository servicioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/new/save")
    public ResponseEntity<String> registrarOrdenServicio(@RequestBody OrdenServicio orden) {
    if (orden.getIdOrden()==null || orden.getTipoOrden() == null || orden.getReceta() == null || orden.getEstado() == null ||
        orden.getFecha() == null || orden.getIdAfiliado() == null || orden.getIdMedico() == null ||
        orden.getServicios() == null || orden.getServicios().isEmpty()) {
        return ResponseEntity.badRequest().body("Error: Todos los campos son obligatorios.");
    }

    // Validar que todos los servicios referenciados existan
    for (Integer idServicio : orden.getServicios()) {
        Optional<ServicioSalud> servicio = servicioRepository.findByIdServicio(idServicio);
        if (servicio.isEmpty()) {
        return ResponseEntity.badRequest().body("Servicio no encontrado");
    }

    }

    if (orden.getIdMedico() == null || medicoRepository.findById(orden.getIdMedico()).isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Medico con ID " + orden.getIdMedico() + " no encontrado.");
        }
            // Guardar la orden con solo IDs referenciados
    ordenServicioRepository.save(orden);
    return ResponseEntity.ok("ORDEN-SERVICIO creada exitosamente con servicios referenciados.");
    }



    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarOrden(@PathVariable("id") String id, @RequestBody OrdenServicio orden) {
        try {
            ordenServicioRepository.actualizarOrden(
                id,
                orden.getTipoOrden(),
                orden.getReceta(),
                orden.getEstado(),
                orden.getFecha(),
                orden.getIdAfiliado(),
                orden.getIdMedico(),
                orden.getServicios()
            );
            return new ResponseEntity<>("Orden actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el Orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("")
    public ResponseEntity<List<OrdenServicio>> obtenerTodasLasOrdenes() {
        try {
            List<OrdenServicio> ordenes = ordenServicioRepository.buscarTodasLasOrdenes();
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrdenServicio>> obtenerOrdenPorId(@PathVariable("id") String id) {
        try {
            List<OrdenServicio> ordenes = ordenServicioRepository.buscarPorId(id);
            if (ordenes != null && !ordenes.isEmpty()) {
                return ResponseEntity.ok(ordenes);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarOrden(@PathVariable("id") String id) {
        try {
            ordenServicioRepository.eliminarOrdenPorId(id);
            return new ResponseEntity<>("Orden eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el Orden: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

