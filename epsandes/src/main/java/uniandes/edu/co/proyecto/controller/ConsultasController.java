package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.ConsultaEntity;
import uniandes.edu.co.proyecto.repositories.ConsultaRepository;

@RestController
public class ConsultasController {

    @Autowired
    private ConsultaRepository consultaRepository;


    @GetMapping("/consultas")
    public String consultas(Model model) {
        Collection<ConsultaEntity> consultas = consultaRepository.darConsultas();
        model.addAttribute("consultas", consultas);

        return model.toString();
    }


    @GetMapping("/consultas/new")
    public String consultaForm(Model model) {
        model.addAttribute("consulta", new ConsultaEntity());
        return "consultaNuevo"; // Nombre de la vista para crear una consulta
    }


    @PostMapping("/consultas/new/save")
    public String consultaGuardar(@ModelAttribute ConsultaEntity consulta) {

        int idServicio = consulta.getServicio().getIdServicio();
        int idMedico = consulta.getMedico().getIdMedico();
        int idAfiliado = consulta.getAfiliado().getIdAfiliado();
        
        consultaRepository.insertarConsulta(consulta.getTipoConsulta(), idServicio, idMedico, idAfiliado);
        return "redirect:/consultas";
    }


    @GetMapping("/consultas/{id}/edit")
    public String consultaEditarForm(@PathVariable("id") int id, Model model) {
        ConsultaEntity consulta = consultaRepository.darConsulta(id);
        if (consulta != null) {
            model.addAttribute("consulta", consulta);
            return "consultaEditar"; 
        } else {
            return "redirect:/consultas";
        }
    }

    @PostMapping("/consultas/{id}/edit/save")
    public String consultaEditarGuardar(@PathVariable("id") int id, @ModelAttribute ConsultaEntity consulta) {
        int idServicio = consulta.getServicio().getIdServicio();
        int idMedico = consulta.getMedico().getIdMedico();
        int idAfiliado = consulta.getAfiliado().getIdAfiliado();

        consultaRepository.actualizarConsulta(id, consulta.getTipoConsulta(), idServicio, idMedico, idAfiliado);
        return "redirect:/consultas";
    }

    @GetMapping("/consultas/{id}/delete")
    public String consultaEliminar(@PathVariable("id") int id) {
        consultaRepository.eliminarConsulta(id);
        return "redirect:/consultas";
    }
}
