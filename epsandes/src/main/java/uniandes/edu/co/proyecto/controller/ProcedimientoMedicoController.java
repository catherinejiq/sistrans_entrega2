package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ProcedimientoMedicoEntity;
import uniandes.edu.co.proyecto.repositories.ProcedimientoMedicoRepository;

@RestController
public class ProcedimientoMedicoController {

    @Autowired
    private ProcedimientoMedicoRepository procedimientoMedicoRepository;

    @GetMapping("/procedimientos-medicos")
    public String procedimientosMedicos(Model model) {
        Collection<ProcedimientoMedicoEntity> procedimientos = procedimientoMedicoRepository.darProcedimientosMedicos();
        model.addAttribute("procedimientos", procedimientos);
        return model.toString();
    }

    @GetMapping("/procedimientos-medicos/new")
    public String procedimientoMedicoForm(Model model) {
        model.addAttribute("procedimientoMedico", new ProcedimientoMedicoEntity());
        return "procedimientoMedicoNuevo";
    }

    @PostMapping("/procedimientos-medicos/new/save")
    public String procedimientoMedicoGuardar(@ModelAttribute ProcedimientoMedicoEntity procedimientoMedico) {
        procedimientoMedicoRepository.insertarProcedimientoMedico(procedimientoMedico.getTipo(), procedimientoMedico.getServicio().getIdServicio());
        return "redirect:/procedimientos-medicos";
    }

    @GetMapping("/procedimientos-medicos/{id}/edit")
    public String procedimientoMedicoEditarForm(@PathVariable("id") int id, Model model) {
        ProcedimientoMedicoEntity procedimientoMedico = procedimientoMedicoRepository.darProcedimientoMedico(id);
        if (procedimientoMedico != null) {
            model.addAttribute("procedimientoMedico", procedimientoMedico);
            return "procedimientoMedicoEditar";
        } else {
            return "redirect:/procedimientos-medicos";
        }
    }

    @PostMapping("/procedimientos-medicos/{id}/edit/save")
    public String procedimientoMedicoEditarGuardar(@PathVariable("id") int id, @ModelAttribute ProcedimientoMedicoEntity procedimientoMedico) {
        procedimientoMedicoRepository.actualizarProcedimientoMedico(id, procedimientoMedico.getTipo(), procedimientoMedico.getServicio().getIdServicio());
        return "redirect:/procedimientos-medicos";
    }

    @GetMapping("/procedimientos-medicos/{id}/delete")
    public String procedimientoMedicoEliminar(@PathVariable("id") int id) {
        procedimientoMedicoRepository.eliminarProcedimientoMedico(id);
        return "redirect:/procedimientos-medicos";
    }
}
