package uniandes.edu.co.proyecto.controller;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.CitaEntity;
import uniandes.edu.co.proyecto.repositories.CitaRepository;

@RestController
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

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
}
