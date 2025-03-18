package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.MedicoAfiliadoEntity;
import uniandes.edu.co.proyecto.repositories.MedicoAfiliadoRepository;

@RestController
public class MedicoAfiliadoController {

    @Autowired
    private MedicoAfiliadoRepository medicoAfiliadoRepository;

    @GetMapping("/medico-afiliado")
    public String listarMedicoAfiliado(Model model) {
        Collection<MedicoAfiliadoEntity> lista = medicoAfiliadoRepository.darMedicoAfiliados();
        model.addAttribute("medicoAfiliados", lista);
        return model.toString();
    }

    @GetMapping("/medico-afiliado/new")
    public String formularioNuevo(Model model) {
        model.addAttribute("medicoAfiliado", new MedicoAfiliadoEntity());
        return "medicoAfiliadoNuevo";
    }

    @PostMapping("/medico-afiliado/new/save")
    public String guardarMedicoAfiliado(@RequestParam("idMedico") Integer idMedico,
                                        @RequestParam("idAfiliado") Integer idAfiliado) {
        medicoAfiliadoRepository.insertarMedicoAfiliado(idMedico, idAfiliado);
        return "redirect:/medico-afiliado";
    }

    @GetMapping("/medico-afiliado/{idMedico}/{idAfiliado}/edit")
    public String formularioEditar(@PathVariable("idMedico") Integer idMedico,
                                   @PathVariable("idAfiliado") Integer idAfiliado,
                                   Model model) {
        MedicoAfiliadoEntity entidad = medicoAfiliadoRepository.darMedicoAfiliadoPorId(idMedico, idAfiliado);
        if (entidad != null) {
            model.addAttribute("medicoAfiliado", entidad);
            return "medicoAfiliadoEditar";
        }
        return "redirect:/medico-afiliado";
    }

    @PostMapping("/medico-afiliado/{idMedico}/{idAfiliado}/edit/save")
    public String editarMedicoAfiliado(@PathVariable("idMedico") Integer idMedico,
                                       @PathVariable("idAfiliado") Integer idAfiliado,
                                       @RequestParam("idMedico_actualizado") Integer idMedicoActualizado,
                                       @RequestParam("idAfiliado_actualizado") Integer idAfiliadoActualizado) {
        medicoAfiliadoRepository.actualizarMedicoAfiliado(idMedico, idAfiliado, idMedicoActualizado, idAfiliadoActualizado);
        return "redirect:/medico-afiliado";
    }

    @GetMapping("/medico-afiliado/{idMedico}/{idAfiliado}/delete")
    public String eliminarMedicoAfiliado(@PathVariable("idMedico") Integer idMedico,
                                         @PathVariable("idAfiliado") Integer idAfiliado) {
        medicoAfiliadoRepository.eliminarMedicoAfiliado(idMedico, idAfiliado);
        return "redirect:/medico-afiliado";
    }
}
