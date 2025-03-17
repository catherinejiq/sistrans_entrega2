package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.OrdenServicioServiciosEntity;
import uniandes.edu.co.proyecto.repositories.OrdenServicioServiciosRepository;

@RestController
public class OrdenServicioServiciosController {

    @Autowired
    private OrdenServicioServiciosRepository ordenServicioServiciosRepository;

    @GetMapping("/orden-servicio-servicios")
    public String listarOrdenServicioServicios(Model model) {
        Collection<OrdenServicioServiciosEntity> lista = ordenServicioServiciosRepository.darOrdenServicioServicios();
        model.addAttribute("ordenServicioServicios", lista);
        return model.toString();
    }

    @GetMapping("/orden-servicio-servicios/new")
    public String formularioNuevaRelacion(Model model) {
        model.addAttribute("ordenServicioServicios", new OrdenServicioServiciosEntity());
        return "ordenServicioServiciosNuevo";
    }

    @PostMapping("/orden-servicio-servicios/new/save")
    public String guardarOrdenServicioServicios(@RequestParam("idOrden") Integer idOrden,
                                                @RequestParam("idServicio") Integer idServicio) {
        ordenServicioServiciosRepository.insertarOrdenServicioServicio(idOrden, idServicio);
        return "redirect:/orden-servicio-servicios";
    }

    @GetMapping("/orden-servicio-servicios/{idOrden}/{idServicio}/edit")
    public String formularioEditarRelacion(@PathVariable("idOrden") Integer idOrden,
                                           @PathVariable("idServicio") Integer idServicio,
                                           Model model) {
        OrdenServicioServiciosEntity entidad = ordenServicioServiciosRepository.darOrdenServicioServicioPorId(idOrden, idServicio);
        if (entidad != null) {
            model.addAttribute("ordenServicioServicios", entidad);
            return "ordenServicioServiciosEditar";
        }
        return "redirect:/orden-servicio-servicios";
    }

    @PostMapping("/orden-servicio-servicios/{idOrden}/{idServicio}/edit/save")
    public String editarOrdenServicioServicios(@PathVariable("idOrden") Integer idOrden,
                                               @PathVariable("idServicio") Integer idServicio,
                                               @RequestParam("idOrden_actualizado") Integer idOrdenActualizado,
                                               @RequestParam("idServicio_actualizado") Integer idServicioActualizado) {
        ordenServicioServiciosRepository.actualizarOrdenServicioServicio(idOrden, idServicio, idOrdenActualizado, idServicioActualizado);
        return "redirect:/orden-servicio-servicios";
    }

    @GetMapping("/orden-servicio-servicios/{idOrden}/{idServicio}/delete")
    public String eliminarOrdenServicioServicios(@PathVariable("idOrden") Integer idOrden,
                                                 @PathVariable("idServicio") Integer idServicio) {
        ordenServicioServiciosRepository.eliminarOrdenServicioServicio(idOrden, idServicio);
        return "redirect:/orden-servicio-servicios";
    }
}
