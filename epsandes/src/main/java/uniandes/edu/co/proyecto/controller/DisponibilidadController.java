package uniandes.edu.co.proyecto.controller;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.DisponibilidadEntity;
import uniandes.edu.co.proyecto.repositories.DisponibilidadRepository;
import uniandes.edu.co.proyecto.modelo.EstadoDisponibilidad;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping
    public String listar(Model model) {
        Collection<DisponibilidadEntity> lista = disponibilidadRepository.darDisponibilidades();
        model.addAttribute("disponibilidades", lista);
        return model.toString();
    }

    @GetMapping("/new")
    public String crearForm(Model model) {
        model.addAttribute("disponibilidad", new DisponibilidadEntity());
        model.addAttribute("estados", EstadoDisponibilidad.values());
        return "disponibilidadNuevo";
    }

    @PostMapping("/new/save")
    public String guardarNuevo(@ModelAttribute DisponibilidadEntity disponibilidad) {
        String inicio = disponibilidad.getFechaHoraInicio().format(FORMATTER);
        String fin    = disponibilidad.getFechaHoraFin().format(FORMATTER);
        int    idServ = disponibilidad.getServicio().getIdServicio();
        long   nitIps = disponibilidad.getIps().getNit();
        int    idMed  = disponibilidad.getMedico().getIdMedico();
        String estado = disponibilidad.getEstado().toString();

        disponibilidadRepository.insertarDisponibilidad(
            idServ, nitIps, idMed, inicio, fin, estado
        );
        return "redirect:/disponibilidades";
    }

    @GetMapping("/{id}/edit")
    public String editarForm(@PathVariable("id") int id, Model model) {
        DisponibilidadEntity d = disponibilidadRepository.darDisponibilidad(id);
        if (d != null) {
            model.addAttribute("disponibilidad", d);
            model.addAttribute("estados", EstadoDisponibilidad.values());
            return "disponibilidadEditar";
        }
        return "redirect:/disponibilidades";
    }

    @PostMapping("/{id}/edit/save")
    public String guardarEdicion(
        @PathVariable("id") int id,
        @ModelAttribute DisponibilidadEntity disponibilidad
    ) {
        String inicio = disponibilidad.getFechaHoraInicio().format(FORMATTER);
        String fin    = disponibilidad.getFechaHoraFin().format(FORMATTER);
        int    idServ = disponibilidad.getServicio().getIdServicio();
        long   nitIps = disponibilidad.getIps().getNit();
        int    idMed  = disponibilidad.getMedico().getIdMedico();
        String estado = disponibilidad.getEstado().toString();

        disponibilidadRepository.actualizarDisponibilidad(
            id, idServ, nitIps, idMed, inicio, fin, estado
        );
        return "redirect:/disponibilidades";
    }

    @GetMapping("/{id}/delete")
    public String eliminar(@PathVariable("id") int id) {
        disponibilidadRepository.eliminarDisponibilidad(id);
        return "redirect:/disponibilidades";
    }
}
