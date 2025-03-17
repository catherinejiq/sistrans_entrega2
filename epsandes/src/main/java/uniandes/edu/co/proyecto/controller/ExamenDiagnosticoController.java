package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ExamenDiagnosticoEntity;
import uniandes.edu.co.proyecto.repositories.ExamenDiagnosticoRepository;

@RestController
public class ExamenDiagnosticoController {

    @Autowired
    private ExamenDiagnosticoRepository examenRepository;

    @GetMapping("/examenes")
    public String examenes(Model model) {
        Collection<ExamenDiagnosticoEntity> examenes = examenRepository.darExamenesDiagnosticos();
        model.addAttribute("examenes", examenes);
        return model.toString();
    }

    @GetMapping("/examenes/new")
    public String examenForm(Model model) {
        model.addAttribute("examen", new ExamenDiagnosticoEntity());
        return "examenNuevo";
    }

    @PostMapping("/examenes/new/save")
    public String examenGuardar(@ModelAttribute ExamenDiagnosticoEntity examen) {
        examenRepository.insertarExamenDiagnostico(examen.getResultados(), examen.getMuestras(), examen.getServicio().getIdServicio());
        return "redirect:/examenes";
    }

    @GetMapping("/examenes/{id}/edit")
    public String examenEditarForm(@PathVariable("id") int id, Model model) {
        ExamenDiagnosticoEntity examen = examenRepository.darExamenDiagnostico(id);
        if (examen != null) {
            model.addAttribute("examen", examen);
            return "examenEditar";
        } else {
            return "redirect:/examenes";
        }
    }

    @PostMapping("/examenes/{id}/edit/save")
    public String examenEditarGuardar(@PathVariable("id") int id, @ModelAttribute ExamenDiagnosticoEntity examen) {
        examenRepository.actualizarExamenDiagnostico(id, examen.getResultados(), examen.getMuestras(), examen.getServicio().getIdServicio());
        return "redirect:/examenes";
    }

    @GetMapping("/examenes/{id}/delete")
    public String examenEliminar(@PathVariable("id") int id) {
        examenRepository.eliminarExamenDiagnostico(id);
        return "redirect:/examenes";
    }
}
