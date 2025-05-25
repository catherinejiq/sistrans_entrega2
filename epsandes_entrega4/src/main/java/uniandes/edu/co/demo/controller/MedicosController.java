package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.demo.modelo.Medico;
import uniandes.edu.co.demo.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository medicoRepository;


    // Crear un nuevo 
    @PostMapping("/new/save")
    public ResponseEntity<String> crearMedico(@RequestBody Medico medico) {
        if (medico.getIdMedico() == null || medico.getIdentificacion() == null || medico.getNombre() == null ||
            medico.getNumRegistro() == null || medico.getEspecialidad() == null || medico.getIps() == null || medico.getIps().isEmpty()) {
            return ResponseEntity.badRequest().body("Error: Todos los campos son obligatorios.");
        }

        medicoRepository.save(medico);
        return ResponseEntity.ok("Médico creado exitosamente");
    }

    // Obtener un medico por ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Medico>> obtenerMedicoPorId(@PathVariable("id") String idMedico) {
        try {
            List<Medico> medicos = medicoRepository.buscarPorId(idMedico);
            if (medicos != null && !medicos.isEmpty()) {
                return ResponseEntity.ok(medicos);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Actualizar un medico existente
    @PostMapping("/{id}/edit/save")
    public ResponseEntity<String> actualizarMedico(@PathVariable("id") String idMedico, @RequestBody Medico medico) {
        try {
            medicoRepository.actualizarMedico(
                idMedico,
                medico.getIdentificacion(),
                medico.getNombre(),
                medico.getNumRegistro(),
                medico.getEspecialidad(),
                medico.getIps()
            );
            return new ResponseEntity<>("Medico actualizado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el medico: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todos los medicos
    @GetMapping("")
    public ResponseEntity<List<Medico>> obtenerTodosMedicos() {
        try {
            List<Medico> medicos = medicoRepository.buscarTodosLosMedicos();
            return ResponseEntity.ok(medicos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Eliminar un medico por su ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarMedico(@PathVariable("id") String idMedico) {
        try {
            medicoRepository.eliminarMedicoPorId(idMedico);
            return new ResponseEntity<>("Medico eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el medico: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}