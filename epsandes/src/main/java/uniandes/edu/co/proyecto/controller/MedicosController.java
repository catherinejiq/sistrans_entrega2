package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.MedicoEntity;
import uniandes.edu.co.proyecto.repositories.MedicoRepository;

@RestController
public class MedicosController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/medicos")
    public String medicos(Model model) {
        Collection<MedicoEntity> medicos = medicoRepository.darMedicos();
        model.addAttribute("medicos", medicos);
        
        return model.toString();
    }

    
    @GetMapping("/medicos/new")
    public String medicoForm(Model model) {
        model.addAttribute("medico", new MedicoEntity());
        return "medicoNuevo"; 
    }

   
    @PostMapping("/medicos/new/save")
    public String medicoGuardar(@ModelAttribute MedicoEntity medico) {
        medicoRepository.insertarMedico(medico.getIdentificacion(),
                                        medico.getNombre(),
                                        medico.getNumRegistro(),
                                        medico.getEspecialidad());
        return "redirect:/medicos";
    }

   
    @GetMapping("/medicos/{id}/edit")
    public String medicoEditarForm(@PathVariable("id") int id, Model model) {
        MedicoEntity medico = medicoRepository.darMedico(id);
        if (medico != null) {
            model.addAttribute("medico", medico);
            return "medicoEditar"; 
        } else {
            return "redirect:/medicos";
        }
    }

    @PostMapping("/medicos/{id}/edit/save")
    public String medicoEditarGuardar(@PathVariable("id") int id, @ModelAttribute MedicoEntity medico) {
        medicoRepository.actualizarMedico(id,
                                            medico.getIdentificacion(),
                                            medico.getNombre(),
                                            medico.getNumRegistro(),
                                            medico.getEspecialidad());
        return "redirect:/medicos";
    }

    @GetMapping("/medicos/{id}/delete")
    public String medicoEliminar(@PathVariable("id") int id) {
        medicoRepository.eliminarMedico(id);
        return "redirect:/medicos";
    }
}
