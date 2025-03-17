package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.HospitalizacionMedico;
import uniandes.edu.co.proyecto.repositories.HospitalizacionMedicoRepository;

@RestController
public class HospitalizacionMedicoController {

    @Autowired
    private HospitalizacionMedicoRepository hospitalizacionMedicoRepository;

    @GetMapping("/hospitalizacion-medico")
    public String listarHospitalizacionMedico(Model model) {
        Collection<HospitalizacionMedico> lista = hospitalizacionMedicoRepository.darHospitalizacionMedicos();
        model.addAttribute("hospitalizacionMedicos", lista);
        return model.toString();
    }

    @GetMapping("/hospitalizacion-medico/new")
    public String formularioNuevaRelacion(Model model) {
        model.addAttribute("hospitalizacionMedico", new HospitalizacionMedico());
        return "hospitalizacionMedicoNuevo";
    }

    @PostMapping("/hospitalizacion-medico/new/save")
    public String guardarHospitalizacionMedico(@RequestParam("idHospitalizacion") Integer idHospitalizacion,
                                               @RequestParam("idMedico") Integer idMedico) {
        hospitalizacionMedicoRepository.insertarHospitalizacionMedico(idHospitalizacion, idMedico);
        return "redirect:/hospitalizacion-medico";
    }

    @GetMapping("/hospitalizacion-medico/{idHospitalizacion}/{idMedico}/edit")
    public String formularioEditarRelacion(@PathVariable("idHospitalizacion") Integer idHospitalizacion,
                                           @PathVariable("idMedico") Integer idMedico,
                                           Model model) {
        HospitalizacionMedico entidad = hospitalizacionMedicoRepository.darHospitalizacionMedicoPorId(idHospitalizacion, idMedico);
        if (entidad != null) {
            model.addAttribute("hospitalizacionMedico", entidad);
            return "hospitalizacionMedicoEditar";
        }
        return "redirect:/hospitalizacion-medico";
    }

    @PostMapping("/hospitalizacion-medico/{idHospitalizacion}/{idMedico}/edit/save")
    public String editarHospitalizacionMedico(@PathVariable("idHospitalizacion") Integer idHospitalizacion,
                                              @PathVariable("idMedico") Integer idMedico,
                                              @RequestParam("idHospitalizacion_actualizado") Integer idHospitalizacionActualizado,
                                              @RequestParam("idMedico_actualizado") Integer idMedicoActualizado) {
        hospitalizacionMedicoRepository.actualizarHospitalizacionMedico(idHospitalizacion, idMedico, idHospitalizacionActualizado, idMedicoActualizado);
        return "redirect:/hospitalizacion-medico";
    }

    @GetMapping("/hospitalizacion-medico/{idHospitalizacion}/{idMedico}/delete")
    public String eliminarHospitalizacionMedico(@PathVariable("idHospitalizacion") Integer idHospitalizacion,
                                                @PathVariable("idMedico") Integer idMedico) {
        hospitalizacionMedicoRepository.eliminarHospitalizacionMedico(idHospitalizacion, idMedico);
        return "redirect:/hospitalizacion-medico";
    }
}
