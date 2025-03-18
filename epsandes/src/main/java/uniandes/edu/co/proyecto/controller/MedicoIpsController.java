package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.MedicoIpsEntity;
import uniandes.edu.co.proyecto.repositories.MedicoIpsRepository;

@RestController
public class MedicoIpsController {

    @Autowired
    private MedicoIpsRepository medicoIpsRepository;

    @GetMapping("/medico-ips")
    public String listarMedicoIps(Model model) {
        Collection<MedicoIpsEntity> relaciones = medicoIpsRepository.darMedicoIps();
        model.addAttribute("relaciones", relaciones);
        return model.toString();
    }

    @GetMapping("/medico-ips/new")
    public String formularioNuevaRelacion(Model model) {
        model.addAttribute("medicoIps", new MedicoIpsEntity());
        return "medicoIpsNuevo";
    }

    @PostMapping("/medico-ips/new/save")
    public String guardarMedicoIps(@RequestParam("idMedico") Integer idMedico,
                                   @RequestParam("nit") Integer nit) {
        medicoIpsRepository.insertarMedicoIps(idMedico, nit);
        return "redirect:/medico-ips";
    }

    @GetMapping("/medico-ips/{idMedico}/{nit}/edit")
    public String formularioEditarRelacion(@PathVariable("idMedico") Integer idMedico,
                                           @PathVariable("nit") Integer nit,
                                           Model model) {
        MedicoIpsEntity entidad = medicoIpsRepository.darMedicoIpsPorId(idMedico, nit);
        if (entidad != null) {
            model.addAttribute("medicoIps", entidad);
            return "medicoIpsEditar";
        }
        return "redirect:/medico-ips";
    }

    @PostMapping("/medico-ips/{idMedico}/{nit}/edit/save")
    public String editarMedicoIps(@PathVariable("idMedico") Integer idMedico,
                                  @PathVariable("nit") Integer nit,
                                  @RequestParam("idMedico_actualizado") Integer idMedicoActualizado,
                                  @RequestParam("nit_actualizado") Integer nitActualizado) {
        medicoIpsRepository.actualizarMedicoIps(idMedico, nit, idMedicoActualizado, nitActualizado);
        return "redirect:/medico-ips";
    }

    @GetMapping("/medico-ips/{idMedico}/{nit}/delete")
    public String eliminarMedicoIps(@PathVariable("idMedico") Integer idMedico,
                                    @PathVariable("nit") Integer nit) {
        medicoIpsRepository.eliminarMedicoIps(idMedico, nit);
        return "redirect:/medico-ips";
    }
}
