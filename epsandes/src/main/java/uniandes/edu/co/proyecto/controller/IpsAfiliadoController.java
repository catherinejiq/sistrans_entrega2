package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.IpsAfiliadoEntity;
import uniandes.edu.co.proyecto.repositories.IpsAfiliadoRepository;

@RestController
public class IpsAfiliadoController {

    @Autowired
    private IpsAfiliadoRepository ipsAfiliadoRepository;

    @GetMapping("/ips-afiliado")
    public String listarIpsAfiliado(Model model) {
        Collection<IpsAfiliadoEntity> relaciones = ipsAfiliadoRepository.darIpsAfiliados();
        model.addAttribute("relaciones", relaciones);
        return model.toString();
    }

    @GetMapping("/ips-afiliado/new")
    public String formularioNuevaRelacion(Model model) {
        model.addAttribute("ipsAfiliado", new IpsAfiliadoEntity());
        return "ipsAfiliadoNuevo";
    }

    @PostMapping("/ips-afiliado/new/save")
    public String guardarIpsAfiliado(@RequestParam("nit") Integer nit,
                                     @RequestParam("idAfiliado") Integer idAfiliado) {
        ipsAfiliadoRepository.insertarIpsAfiliado(nit, idAfiliado);
        return "redirect:/ips-afiliado";
    }

    @GetMapping("/ips-afiliado/{nit}/{idAfiliado}/edit")
    public String formularioEditarRelacion(@PathVariable("nit") Integer nit,
                                           @PathVariable("idAfiliado") Integer idAfiliado,
                                           Model model) {
        IpsAfiliadoEntity entidad = ipsAfiliadoRepository.darIpsAfiliadoPorId(nit, idAfiliado);
        if (entidad != null) {
            model.addAttribute("ipsAfiliado", entidad);
            return "ipsAfiliadoEditar";
        }
        return "redirect:/ips-afiliado";
    }

    @PostMapping("/ips-afiliado/{nit}/{idAfiliado}/edit/save")
    public String editarIpsAfiliado(@PathVariable("nit") Integer nit,
                                    @PathVariable("idAfiliado") Integer idAfiliado,
                                    @RequestParam("nit_actualizado") Integer nitActualizado,
                                    @RequestParam("id_afiliado_actualizado") Integer idAfiliadoActualizado) {
        ipsAfiliadoRepository.actualizarIpsAfiliado(nit, idAfiliado, nitActualizado, idAfiliadoActualizado);
        return "redirect:/ips-afiliado";
    }

    @GetMapping("/ips-afiliado/{nit}/{idAfiliado}/delete")
    public String eliminarIpsAfiliado(@PathVariable("nit") Integer nit,
                                      @PathVariable("idAfiliado") Integer idAfiliado) {
        ipsAfiliadoRepository.eliminarIpsAfiliado(nit, idAfiliado);
        return "redirect:/ips-afiliado";
    }
}
