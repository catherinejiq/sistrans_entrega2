package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.HospitalizacionEntity;
import uniandes.edu.co.proyecto.repositories.HospitalizacionRepository;

@RestController
public class HospitalizacionController {

    @Autowired
    private HospitalizacionRepository hospitalizacionRepository;

    @GetMapping("/hospitalizaciones")
    public String hospitalizaciones(Model model) {
        Collection<HospitalizacionEntity> hospitalizaciones = hospitalizacionRepository.darHospitalizaciones();
        model.addAttribute("hospitalizaciones", hospitalizaciones);
        return model.toString();
    }

    @GetMapping("/hospitalizaciones/new")
    public String hospitalizacionForm(Model model) {
        model.addAttribute("hospitalizacion", new HospitalizacionEntity());
        return "hospitalizacionNuevo";
    }

    @PostMapping("/hospitalizaciones/new/save")
    public String hospitalizacionGuardar(@ModelAttribute HospitalizacionEntity hospitalizacion) {
        hospitalizacionRepository.insertarHospitalizacion(
                hospitalizacion.getEstado(),
                hospitalizacion.getTratamiento(),
                hospitalizacion.getServicio().getIdServicio());
        return "redirect:/hospitalizaciones";
    }

    @GetMapping("/hospitalizaciones/{id}/edit")
    public String hospitalizacionEditarForm(@PathVariable("id") int id, Model model) {
        HospitalizacionEntity hospitalizacion = hospitalizacionRepository.darHospitalizacion(id);
        if (hospitalizacion != null) {
            model.addAttribute("hospitalizacion", hospitalizacion);
            return "hospitalizacionEditar";
        } else {
            return "redirect:/hospitalizaciones";
        }
    }

    @PostMapping("/hospitalizaciones/{id}/edit/save")
    public String hospitalizacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute HospitalizacionEntity hospitalizacion) {
        hospitalizacionRepository.actualizarHospitalizacion(
                id,
                hospitalizacion.getEstado(),
                hospitalizacion.getTratamiento(),
                hospitalizacion.getServicio().getIdServicio());
        return "redirect:/hospitalizaciones";
    }

    @GetMapping("/hospitalizaciones/{id}/delete")
    public String hospitalizacionEliminar(@PathVariable("id") int id) {
        hospitalizacionRepository.eliminarHospitalizacion(id);
        return "redirect:/hospitalizaciones";
    }
}
