package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ServicioSaludEntity;
import uniandes.edu.co.proyecto.repositories.ServicioSaludRepository;

@RestController
public class ServicioSaludController {

    @Autowired
    private ServicioSaludRepository servicioSaludRepository;


    @GetMapping("/servicios-salud")
    public String serviciosSalud(Model model) {
        Collection<ServicioSaludEntity> servicios = servicioSaludRepository.darServiciosSalud();
        model.addAttribute("servicios", servicios);

        return model.toString();
    }


    @GetMapping("/servicios-salud/new")
    public String servicioSaludForm(Model model) {
        model.addAttribute("servicioSalud", new ServicioSaludEntity());
        return "servicioSaludNuevo"; 
    }


    @PostMapping("/servicios-salud/new/save")
    public ResponseEntity<String> servicioSaludGuardar(@RequestBody ServicioSaludEntity servicioSalud) {
        System.out.println("Fecha recibida: " + servicioSalud.getFecha());
        System.out.println("Descripción recibida: " + servicioSalud.getDescripcion());
    
        if (servicioSalud.getFecha() == null || servicioSalud.getDescripcion() == null) {
            return ResponseEntity.badRequest().body("Error: La fecha y la descripción son obligatorias.");
        }
    
        // Convertir LocalDate a Date
        java.util.Date fechaDate = Date.from(servicioSalud.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant());
    
        java.sql.Date fechaSqlDate = new java.sql.Date(fechaDate.getTime());
        servicioSaludRepository.insertarServicioSalud(fechaSqlDate, servicioSalud.getDescripcion());
    
        return ResponseEntity.ok("Servicio creado exitosamente");
    }
    
       

    @GetMapping("/servicios-salud/{id}/edit")
    public String servicioSaludEditarForm(@PathVariable("id") int id, Model model) {
        ServicioSaludEntity servicio = servicioSaludRepository.darServicioSalud(id);
        if (servicio != null) {
            model.addAttribute("servicioSalud", servicio);
            return "servicioSaludEditar"; 
        } else {
            return "redirect:/servicios-salud";
        }
    }

    @PostMapping("/servicios-salud/{id}/edit/save")
    public String servicioSaludEditarGuardar(@PathVariable("id") int id, @ModelAttribute ServicioSaludEntity servicioSalud) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr = sdf.format(servicioSalud.getFecha());
        
        servicioSaludRepository.actualizarServicioSalud(id, fechaStr, servicioSalud.getDescripcion());
        return "redirect:/servicios-salud";
    }

    @GetMapping("/servicios-salud/{id}/delete")
    public String servicioSaludEliminar(@PathVariable("id") int id) {
        servicioSaludRepository.eliminarServicioSalud(id);
        return "redirect:/servicios-salud";
    }
}
