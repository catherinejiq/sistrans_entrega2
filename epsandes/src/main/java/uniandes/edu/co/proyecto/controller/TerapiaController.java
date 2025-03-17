package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.TerapiaEntity;
import uniandes.edu.co.proyecto.repositories.TerapiaRepository;

@RestController
public class TerapiaController {

    @Autowired
    private TerapiaRepository terapiaRepository;

    @GetMapping("/terapias")
    public String terapias(Model model) {
        Collection<TerapiaEntity> terapias = terapiaRepository.darTerapias();
        model.addAttribute("terapias", terapias);
        return model.toString();
    }

    @GetMapping("/terapias/new")
    public String terapiaForm(Model model) {
        model.addAttribute("terapia", new TerapiaEntity());
        return "terapiaNuevo";
    }

    @PostMapping("/terapias/new/save")
    public String terapiaGuardar(@ModelAttribute TerapiaEntity terapia) {
        terapiaRepository.insertarTerapia(terapia.getTipo(), terapia.getCantidadSesiones(), terapia.getServicio().getIdServicio());
        return "redirect:/terapias";
    }

    @GetMapping("/terapias/{id}/edit")
    public String terapiaEditarForm(@PathVariable("id") int id, Model model) {
        TerapiaEntity terapia = terapiaRepository.darTerapia(id);
        if (terapia != null) {
            model.addAttribute("terapia", terapia);
            return "terapiaEditar";
        } else {
            return "redirect:/terapias";
        }
    }

    @PostMapping("/terapias/{id}/edit/save")
    public String terapiaEditarGuardar(@PathVariable("id") int id, @ModelAttribute TerapiaEntity terapia) {
        terapiaRepository.actualizarTerapia(id, terapia.getTipo(), terapia.getCantidadSesiones(), terapia.getServicio().getIdServicio());
        return "redirect:/terapias";
    }

    @GetMapping("/terapias/{id}/delete")
    public String terapiaEliminar(@PathVariable("id") int id) {
        terapiaRepository.eliminarTerapia(id);
        return "redirect:/terapias";
    }
}
