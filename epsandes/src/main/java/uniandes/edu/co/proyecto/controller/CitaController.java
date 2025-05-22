package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.CitaEntity;
import uniandes.edu.co.proyecto.modelo.DisponibilidadEntity;
import uniandes.edu.co.proyecto.modelo.EstadoDisponibilidad;
import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;
import uniandes.edu.co.proyecto.repositories.CitaRepository;
import uniandes.edu.co.proyecto.repositories.DisponibilidadRepository;
import uniandes.edu.co.proyecto.repositories.OrdenServicioRepository;
import uniandes.edu.co.proyecto.repositories.OrdenServicioServiciosRepository;

@RestController
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private DisponibilidadRepository disponibilidadRepository;
    @Autowired
    private OrdenServicioRepository ordenServicioRepository;
    @Autowired
    private OrdenServicioServiciosRepository ordenServicioServiciosRepository;


    @GetMapping("/citas")
    public String citas(Model model) {
        Collection<CitaEntity> citas = citaRepository.darCitas();
        model.addAttribute("citas", citas);

        return model.toString();
    }

    @GetMapping("/citas/new")
    public String citaForm(Model model) {
        model.addAttribute("cita", new CitaEntity());
        return "citaNuevo";
    }

    @PostMapping("/citas/new/save")
    public String citaGuardar(@ModelAttribute CitaEntity cita) {
        int idDisponibilidad = cita.getDisponibilidad().getIdDisponibilidad();
        int idAfiliado = cita.getAfiliado().getIdAfiliado();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String fechaReservaStr = cita.getFechaReserva().format(formatter);

        citaRepository.insertarCita(idDisponibilidad, idAfiliado, fechaReservaStr);
        return "redirect:/citas";
    }

    @GetMapping("/citas/{id}/edit")
    public String citaEditarForm(@PathVariable("id") int id, Model model) {
        CitaEntity cita = citaRepository.darCita(id);
        if (cita != null) {
            model.addAttribute("cita", cita);
            return "citaEditar";
        } else {
            return "redirect:/citas";
        }
    }

    @PostMapping("/citas/{id}/edit/save")
    public String citaEditarGuardar(@PathVariable("id") int id, @ModelAttribute CitaEntity cita) {
        int idDisponibilidad = cita.getDisponibilidad().getIdDisponibilidad();
        int idAfiliado = cita.getAfiliado().getIdAfiliado();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String fechaReservaStr = cita.getFechaReserva().format(formatter);

        citaRepository.actualizarCita(id, idDisponibilidad, idAfiliado, fechaReservaStr);
        return "redirect:/citas";
    }

    @GetMapping("/citas/{id}/delete")
    public String citaEliminar(@PathVariable("id") int id) {
        citaRepository.eliminarCita(id);
        return "redirect:/citas";
    }



    ///-----------RF9------------------
    
    @PostMapping("/citas/agendar")
    @Transactional
    public ResponseEntity<?> agendarCita(@RequestBody Map<String,Object> payload) {
        
        int idDisp    = ((Number) payload.get("idDisponibilidad")).intValue();
        int idAfiliado= ((Number) payload.get("idAfiliado")).intValue();
        String receta = (String) payload.get("receta");

        
        DisponibilidadEntity d = disponibilidadRepository.darDisponibilidad(idDisp);
        if (d == null) {
            return ResponseEntity.status(404)
                                 .body(Map.of("error","Disponibilidad no encontrada"));
        }
        if (d.getEstado() != EstadoDisponibilidad.LIBRE) {
            return ResponseEntity.status(409)
                                 .body(Map.of("error","Franja ya ocupada"));
        }

        
        OrdenServicioEntity orden = new OrdenServicioEntity();
        orden.setTipoOrden("Agendamiento Servicio");
        orden.setReceta(receta);
        orden.setEstado("VIGENTE");
        orden.setFecha(LocalDate.now());
        AfiliadoEntity af = new AfiliadoEntity();
        af.setIdAfiliado(idAfiliado);
        orden.setAfiliado(af);
        orden.setMedico(d.getMedico());
        orden = ordenServicioRepository.save(orden);

        
        ordenServicioServiciosRepository.insertarOrdenServicioServicio(
            orden.getIdOrden(),
            d.getServicio().getIdServicio()
        );

        
        d.setEstado(EstadoDisponibilidad.OCUPADO);
        disponibilidadRepository.save(d);

        
        return ResponseEntity.ok(Map.of("idOrden", orden.getIdOrden()));
    }
}
