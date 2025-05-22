package uniandes.edu.co.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    if (orden.getTipoOrden() == null || orden.getReceta() == null || orden.getEstado() == null ||
        orden.getFecha() == null || orden.getIdAfiliado() == null || orden.getIdentificacionMedico() == null ||
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

    if (orden.getIdentificacionMedico() == null || medicoRepository.findByIdentificacion(orden.getIdentificacionMedico()).isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Servicio con ID " + orden.getIdentificacionMedico() + " no encontrado.");
        }
            // Guardar la orden con solo IDs referenciados
    ordenServicioRepository.save(orden);
    return ResponseEntity.ok("ORDEN-SERVICIO creada exitosamente con servicios referenciados.");
    }
}

