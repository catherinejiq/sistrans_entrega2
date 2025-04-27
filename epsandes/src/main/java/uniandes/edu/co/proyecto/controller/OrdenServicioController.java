package uniandes.edu.co.proyecto.controller;

import java.util.Date;

import java.text.SimpleDateFormat;

import java.util.Collection;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;


import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;
import uniandes.edu.co.proyecto.repositories.OrdenServicioRepository;
import uniandes.edu.co.proyecto.repositories.OrdenServicioServiciosRepository;



@RestController
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Autowired
    private OrdenServicioServiciosRepository ordenServicioServiciosRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      sdf.setLenient(false);
      binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }


    @GetMapping("/ordenes-servicio")
    public String ordenesServicio(Model model) {
        Collection<OrdenServicioEntity> ordenes = ordenServicioRepository.darOrdenesServicio();
        model.addAttribute("ordenes", ordenes);

        return model.toString();
    }


    @GetMapping("/ordenes-servicio/new")
    public String ordenServicioForm(Model model) {
        model.addAttribute("ordenServicio", new OrdenServicioEntity());
        return "ordenServicioNuevo";
    }


    @PostMapping("/ordenes-servicio/new/save")
    public String ordenServicioGuardar(@ModelAttribute OrdenServicioEntity ordenServicio) {

        String tipoOrden = ordenServicio.getTipoOrden();
        String receta = ordenServicio.getReceta();
        String estado = ordenServicio.getEstado().toString();
        

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr = sdf.format(ordenServicio.getFecha());
        

        int idAfiliado = ordenServicio.getAfiliado().getIdAfiliado();
        int idMedico = ordenServicio.getMedico().getIdMedico();
        
        ordenServicioRepository.insertarOrdenServicio(tipoOrden, receta, estado, fechaStr, idAfiliado, idMedico);
        return "redirect:/ordenes-servicio";
    }

    @GetMapping("/ordenes-servicio/{id}/edit")
    public String ordenServicioEditarForm(@PathVariable("id") int id, Model model) {
        OrdenServicioEntity orden = ordenServicioRepository.darOrdenServicio(id);
        if (orden != null) {
            model.addAttribute("ordenServicio", orden);
            return "ordenServicioEditar"; 
        } else {
            return "redirect:/ordenes-servicio";
        }
    }

    @PostMapping("/ordenes-servicio/{id}/edit/save")
    public String ordenServicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute OrdenServicioEntity ordenServicio) {
        String tipoOrden = ordenServicio.getTipoOrden();
        String receta = ordenServicio.getReceta();
        String estado = ordenServicio.getEstado().toString();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaStr = sdf.format(ordenServicio.getFecha());
        
        int idAfiliado = ordenServicio.getAfiliado().getIdAfiliado();
        int idMedico = ordenServicio.getMedico().getIdMedico();
        
        ordenServicioRepository.actualizarOrdenServicio(id, tipoOrden, receta, estado, fechaStr, idAfiliado, idMedico);
        return "redirect:/ordenes-servicio";
    }


    @GetMapping("/ordenes-servicio/{id}/delete")
    public String ordenServicioEliminar(@PathVariable("id") int id) {
        ordenServicioRepository.eliminarOrdenServicio(id);
        return "redirect:/ordenes-servicio";
        }


        ///RF6
        @PostMapping("/ordenes-servicio/registrar")
        public String registrarOrdenServicio(@RequestBody Map<String, Object> payload) {
            try {
                
                String tipoOrden = (String) payload.get("tipoOrden");
                String receta = (String) payload.get("receta");
                String estado = (String) payload.get("estado");
                String fecha = (String) payload.get("fecha");
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
                
                return "redirect:/ordenes-servicio";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            }
        }
    


 } 

