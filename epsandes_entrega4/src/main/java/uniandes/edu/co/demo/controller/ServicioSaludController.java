package uniandes.edu.co.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.demo.modelo.ServicioSalud;
import uniandes.edu.co.demo.repository.ServicioSaludRepository;

@RequestMapping("/servicios")
public class ServicioSaludController {

    @Autowired
    private ServicioSaludRepository servicioRepository;


    // Crear un nuevo 
    @PostMapping("/new/save")
    public ResponseEntity<String> crearServicio(@RequestBody ServicioSalud servicio) {
        if (servicio.getIdServicio() == null || servicio.getFecha() == null ||
            servicio.getDescripcion() == null) {
            return ResponseEntity.badRequest().body("Error: Todos los campos son obligatorios.");
        }

        servicioRepository.save(servicio);
        return ResponseEntity.ok("Servicio creado exitosamente");
    }

    // Obtener todos los servicios
    @GetMapping("")
    public ResponseEntity<List<ServicioSalud>> obtenerTodosServicios() {
        try {
            List<ServicioSalud> servicios = servicioRepository.buscarTodosLosServicios();
            return ResponseEntity.ok(servicios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Eliminar un servicios por su ID
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarServicio(@PathVariable("id") String id) {
        try {
          servicioRepository.deleteById(id);
            return new ResponseEntity<>("Servicio salud eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el servicio salud: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
    