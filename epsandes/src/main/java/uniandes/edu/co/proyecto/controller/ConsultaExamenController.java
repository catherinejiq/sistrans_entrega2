package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ConsultaExamenEntity;
import uniandes.edu.co.proyecto.repositories.ConsultaExamenRepository;

@RestController
public class ConsultaExamenController {

    @Autowired
    private ConsultaExamenRepository consultaExamenRepository;

    @GetMapping("/consulta-examen")
    public String listarConsultaExamen(Model model) {
        Collection<ConsultaExamenEntity> lista = consultaExamenRepository.darConsultaExamenes();
        model.addAttribute("consultaExamenes", lista);
        return model.toString();
    }

    @GetMapping("/consulta-examen/new")
    public String formularioNuevaConsultaExamen(Model model) {
        model.addAttribute("consultaExamen", new ConsultaExamenEntity());
        return "consultaExamenNuevo";
    }

    @PostMapping("/consulta-examen/new/save")
    public String guardarConsultaExamen(@RequestParam("idConsulta") Integer idConsulta,
                                        @RequestParam("idExamen") Integer idExamen) {
        consultaExamenRepository.insertarConsultaExamen(idConsulta, idExamen);
        return "redirect:/consulta-examen";
    }

    @GetMapping("/consulta-examen/{idConsulta}/{idExamen}/edit")
    public String formularioEditarConsultaExamen(@PathVariable("idConsulta") Integer idConsulta,
                                                 @PathVariable("idExamen") Integer idExamen,
                                                 Model model) {
        ConsultaExamenEntity entidad = consultaExamenRepository.darConsultaExamenPorId(idConsulta, idExamen);
        if (entidad != null) {
            model.addAttribute("consultaExamen", entidad);
            return "consultaExamenEditar";
        }
        return "redirect:/consulta-examen";
    }

    @PostMapping("/consulta-examen/{idConsulta}/{idExamen}/edit/save")
    public String editarConsultaExamen(@PathVariable("idConsulta") Integer idConsulta,
                                       @PathVariable("idExamen") Integer idExamen,
                                       @RequestParam("idConsulta_actualizado") Integer idConsultaActualizado,
                                       @RequestParam("idExamen_actualizado") Integer idExamenActualizado) {
        consultaExamenRepository.actualizarConsultaExamen(idConsulta, idExamen, idConsultaActualizado, idExamenActualizado);
        return "redirect:/consulta-examen";
    }

    @GetMapping("/consulta-examen/{idConsulta}/{idExamen}/delete")
    public String eliminarConsultaExamen(@PathVariable("idConsulta") Integer idConsulta,
                                         @PathVariable("idExamen") Integer idExamen) {
        consultaExamenRepository.eliminarConsultaExamen(idConsulta, idExamen);
        return "redirect:/consulta-examen";
    }
}
