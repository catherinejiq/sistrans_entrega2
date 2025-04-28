package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.OrdenServicioServiciosEntity;
import uniandes.edu.co.proyecto.repositories.OrdenServicioServiciosRepository;
import uniandes.edu.co.proyecto.repositories.OrdenServicioRepository;

@RestController
public class OrdenServicioServiciosController {

    @Autowired
    private OrdenServicioServiciosRepository ordenServicioServiciosRepository;

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

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

            ///RF6
        @PostMapping("/orden-servicio-servicios/registrar")
        public String registrarOrdenServicio(@RequestBody Map<String, Object> payload) {
            try {
                
                String tipoOrden = (String) payload.get("tipoOrden");
                String receta = (String) payload.get("receta");
                String estado = (String) payload.get("estado");
                String fechaStr = (String) payload.get("fecha"); // debes cambiar la clave
                LocalDate fecha = LocalDate.parse(fechaStr);
                Integer idAfiliado = ((Number) payload.get("idAfiliado")).intValue();
                Integer idMedico = ((Number) payload.get("idMedico")).intValue();
                List<Integer> idsServicios = (List<Integer>) payload.get("idsServicios");
                
                

                ordenServicioRepository.insertarOrdenServicio(tipoOrden, receta, estado, fecha, idAfiliado, idMedico);
                
                
                int idOrden = ordenServicioRepository.obtenerUltimoId();
                
                
                if (idsServicios != null && !idsServicios.isEmpty()) {
                    for (Integer idServicio : idsServicios) {
                        ordenServicioServiciosRepository.insertarOrdenServicioServicio(idOrden, idServicio);
                    }
                }
                
                return "redirect:/orden-servicio-servicios";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }
}
