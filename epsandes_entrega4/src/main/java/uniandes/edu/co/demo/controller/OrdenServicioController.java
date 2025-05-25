package uniandes.edu.co.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.Medico;
import uniandes.edu.co.demo.modelo.OrdenServicio;
import uniandes.edu.co.demo.modelo.ServicioSalud;
import uniandes.edu.co.demo.repository.ServicioSaludRepository;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;
import uniandes.edu.co.demo.repository.MedicoRepository;  
import uniandes.edu.co.demo.repository.AfiliadoRepository;  

@RestController
@RequestMapping("/orden-servicio")
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Autowired
    private ServicioSaludRepository servicioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;


    @PostMapping("/new/save")
    public ResponseEntity<String> registrarOrdenServicio(@RequestBody OrdenServicio orden) {
    if (orden.getIdOrden()==null || orden.getTipoOrden() == null || orden.getReceta() == null || orden.getEstado() == null ||
        orden.getFecha() == null || orden.getIdAfiliado() == null || orden.getIdMedico() == null ||
        orden.getServicios() == null || orden.getServicios().isEmpty()) {
        return ResponseEntity.badRequest().body("Error: Todos los campos son obligatorios.");
    }

    Optional<Afiliado> afOpt = afiliadoRepository.findByIdAfiliado(orden.getIdAfiliado());
        Optional<Medico> medOpt = medicoRepository.findById(orden.getIdMedico());

        if (afOpt.isEmpty()) return ResponseEntity.badRequest().body("Afiliado no encontrado.");
        if (medOpt.isEmpty()) return ResponseEntity.badRequest().body("Médico no encontrado.");

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

    OrdenServicio ordenFinal = new OrdenServicio();
    ordenFinal.setIdOrden(orden.getIdOrden());
    ordenFinal.setTipoOrden(orden.getTipoOrden());
    ordenFinal.setReceta(orden.getReceta());
    ordenFinal.setEstado(orden.getEstado());
    ordenFinal.setFecha(orden.getFecha());
    ordenFinal.setAfiliado(afOpt.get()); // embebido
    ordenFinal.setMedico(medOpt.get());  // embebido
    ordenFinal.setServicios(orden.getServicios()); // referenciado
    
    ordenServicioRepository.save(ordenFinal);

    return ResponseEntity.ok("ORDEN-SERVICIO creada exitosamente con servicios referenciados.");
    }
}

