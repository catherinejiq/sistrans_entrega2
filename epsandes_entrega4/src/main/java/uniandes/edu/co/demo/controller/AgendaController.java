package uniandes.edu.co.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import uniandes.edu.co.demo.modelo.Afiliado;
import uniandes.edu.co.demo.modelo.Cita;
import uniandes.edu.co.demo.modelo.Disponibilidad;
import uniandes.edu.co.demo.modelo.ServicioCustom;
import uniandes.edu.co.demo.repository.CitaRepository;
import uniandes.edu.co.demo.repository.DisponibilidadRepository;
import uniandes.edu.co.demo.repository.OrdenServicioRepository;
import uniandes.edu.co.demo.repository.ServicioRepositoryCustom;



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


    @GetMapping("disponibilidades")
    public ResponseEntity<List<Disponibilidad>> obtenerDisponibilidades() {
        try {
            List<Disponibilidad> disponibilidades = dispRepo.obtenerDisponibilidades();
            return ResponseEntity.ok(disponibilidades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

}

    @GetMapping("")
    public ResponseEntity<List<Cita>> obtenerTodosLosAfiliados() {
        try {
            List<Cita> citas = citaRepo.obtenerCitas();
            return ResponseEntity.ok(citas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Autowired
    private ServicioRepositoryCustom servicioRepositoryCustom;

    private static final SimpleDateFormat ISO_DATE = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/mas-usados")
    public ResponseEntity<List<Document>> obtenerServiciosMasUsados(
        @RequestParam("desde")
        @DateTimeFormat(iso =DateTimeFormat.ISO.DATE) String desde,
        @RequestParam("hasta")
        @DateTimeFormat(iso =DateTimeFormat.ISO.DATE) String hasta
    ) {
        try {
            
            Date fechaInicio = ISO_DATE.parse(desde);
            Date fechaFin = ISO_DATE.parse(hasta);

            List<Document> lista = servicioRepositoryCustom.obtenerServiciosMasUsadosEntreFechas(fechaInicio, fechaFin);

            // Retornar el resultado de la consulta
            return ResponseEntity.ok(lista);
        }  catch (ParseException pe) {
            // Mal formato de fecha
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
    }
    
}
}