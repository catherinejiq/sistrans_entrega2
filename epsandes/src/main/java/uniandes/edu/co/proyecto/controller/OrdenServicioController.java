package uniandes.edu.co.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;
import uniandes.edu.co.proyecto.repositories.OrdenServicioRepository;

@RestController
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;


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
}
