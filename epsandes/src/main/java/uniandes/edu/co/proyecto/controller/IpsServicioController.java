package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.IpsServicioEntity;
import uniandes.edu.co.proyecto.repositories.IpsServicioRepository;

@RestController
public class IpsServicioController {

    @Autowired
    private IpsServicioRepository ipsServicioRepository;

    @GetMapping("/ips-servicio")
    public String listarIpsServicio(Model model) {
        Collection<IpsServicioEntity> lista = ipsServicioRepository.darIpsServicios();
        model.addAttribute("ipsServicios", lista);
        return model.toString();
    }

    @GetMapping("/ips-servicio/new")
    public String formularioNuevaIpsServicio(Model model) {
        model.addAttribute("ipsServicio", new IpsServicioEntity());
        return "ipsServicioNuevo";
    }

    @PostMapping("/ips-servicio/new/save")
    public String guardarIpsServicio(@RequestParam("nit") Integer nit,
                                     @RequestParam("idServicio") Integer idServicio) {
        ipsServicioRepository.insertarIpsServicio(nit, idServicio);
        return "redirect:/ips-servicio";
    }

    @GetMapping("/ips-servicio/{nit}/{idServicio}/edit")
    public String formularioEditarIpsServicio(@PathVariable("nit") Integer nit,
                                              @PathVariable("idServicio") Integer idServicio,
                                              Model model) {
        IpsServicioEntity entidad = ipsServicioRepository.darIpsServicioPorId(nit, idServicio);
        if (entidad != null) {
            model.addAttribute("ipsServicio", entidad);
            return "ipsServicioEditar";
        }
        return "redirect:/ips-servicio";
    }

    @PostMapping("/ips-servicio/{nit}/{idServicio}/edit/save")
    public String editarIpsServicio(@PathVariable("nit") Integer nit,
                                    @PathVariable("idServicio") Integer idServicio,
                                    @RequestParam("nit_actualizado") Integer nitActualizado,
                                    @RequestParam("idServicio_actualizado") Integer idServicioActualizado) {
        ipsServicioRepository.actualizarIpsServicio(nit, idServicio, nitActualizado, idServicioActualizado);
        return "redirect:/ips-servicio";
    }

    @GetMapping("/ips-servicio/{nit}/{idServicio}/delete")
    public String eliminarIpsServicio(@PathVariable("nit") Integer nit,
                                      @PathVariable("idServicio") Integer idServicio) {
        ipsServicioRepository.eliminarIpsServicio(nit, idServicio);
        return "redirect:/ips-servicio";
    }
}
