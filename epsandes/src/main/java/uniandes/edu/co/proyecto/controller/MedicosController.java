package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> guardarMedico(@RequestBody MedicoEntity medico) {
    System.out.println("Identificación recibida: " + medico.getIdentificacion());
    System.out.println("Nombre recibido: " + medico.getNombre());
    System.out.println("Número de registro recibido: " + medico.getNumRegistro());
    System.out.println("Especialidad recibida: " + medico.getEspecialidad());

    if (medico.getIdentificacion() == null || medico.getNombre() == null || 
        medico.getNumRegistro() == null || medico.getEspecialidad() == null) {
        return ResponseEntity.badRequest().body("Error: Todos los campos son obligatorios.");
    }

    medicoRepository.insertarMedico(medico.getIdentificacion(), medico.getNombre(), 
                                    medico.getNumRegistro(), medico.getEspecialidad());

    return ResponseEntity.ok("Médico creado exitosamente");
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
