package uniandes.edu.co.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import uniandes.edu.co.demo.modelo.Cita;
import uniandes.edu.co.demo.modelo.Disponibilidad;
import uniandes.edu.co.demo.repository.CitaRepository;
import uniandes.edu.co.demo.repository.DisponibilidadRepository;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;

@RestController
@RequestMapping("/citas")
public class AgendaController {

    @Autowired
    private DisponibilidadRepository dispRepo;

    @Autowired
    private CitaRepository citaRepo;

    @Autowired
    private OrdenServicioRepository ordenRepo;

    
    // RFC1: Consultar disponibilidad de un servicio
   
    @GetMapping("/agenda/{idServicio}")
    public ResponseEntity<List<Disponibilidad>> consultarAgenda(
            @PathVariable int idServicio) {

        
        Date ahora = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(ahora);
        cal.add(Calendar.WEEK_OF_YEAR, 4);
        Date dentroDe4Semanas = cal.getTime();

        
        List<Disponibilidad> franjas = dispRepo
            .findByIdServicioAndEstadoAndFechaHoraInicioBetween(
                idServicio,
                "LIBRE",
                ahora,
                dentroDe4Semanas
            );

        return ResponseEntity.ok(franjas);
    }

    
    // RF7: Agendar un servicio de salud
    
    @PostMapping("/agendar")
    public ResponseEntity<?> agendarCita(@RequestBody Map<String,String> payload) {
        String dispId = payload.get("disponibilidadId");
        String afiId  = payload.get("afiliadoId");
        String ordId  = payload.get("ordenId");

        
        Disponibilidad d = dispRepo.findByIdAndEstado(dispId, "LIBRE")
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.CONFLICT, "Franja no disponible o ya ocupada"
            ));

        
        if (d.getIdServicio() != 1 && d.getIdServicio() != 2) {
            if (ordId == null || !ordenRepo.existsById(ordId)) {
                throw new ResponseStatusException(
                  HttpStatus.BAD_REQUEST, "Orden inválida o faltante"
                );
            }
        }

        
        d.setEstado("OCUPADO");
        dispRepo.save(d);

        
        Cita c = new Cita();
        c.setDisponibilidadId(dispId);
        c.setAfiliadoId(afiId);
        c.setFechaReserva(new Date());
        if (d.getIdServicio() != 1 && d.getIdServicio() != 2) {
            c.setOrdenId(ordId);
        }
        citaRepo.save(c);

        
        return ResponseEntity.ok(Map.of("message","Cita agendada"));
    }
}
