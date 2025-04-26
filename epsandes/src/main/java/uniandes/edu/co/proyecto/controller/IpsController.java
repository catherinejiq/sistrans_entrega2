package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.IpsEntity;
import uniandes.edu.co.proyecto.repositories.IpsRepository;

@RestController
public class IpsController {

    @Autowired
    private IpsRepository ipsRepository;

    @GetMapping("/ips")
    public String ips(Model model) {
        Collection<IpsEntity> ipsList = ipsRepository.darIps();
        model.addAttribute("ips", ipsList);
        return model.toString();
    }

    @GetMapping("/ips/new")
    public String ipsForm(Model model) {
        
        model.addAttribute("ips", new IpsEntity());
        return "ipsNuevo";
    }

   
    @PostMapping("/ips/new/save")
    public ResponseEntity<String> ipsGuardar(@RequestBody IpsEntity ips) {
        System.out.println("Datos recibidos: " + ips);
        System.out.println("nombre: " + ips.getNombre());
        System.out.println("dirección: " + ips.getDireccion());
        System.out.println("teléfono: " + ips.getTelefono());
        System.out.println("horario: " + ips.getHorario());
    
        if (ips.getNombre() == null || ips.getDireccion() == null || ips.getTelefono() == null || ips.getHorario() == null) {
            return ResponseEntity.badRequest().body("Error: Todos los campos son obligatorios");
        }
    
        ipsRepository.insertarIp(ips.getNombre(), ips.getDireccion(), ips.getTelefono(), ips.getHorario());
        return ResponseEntity.ok("IPS creada correctamente");
    }
    


    @GetMapping("/ips/{nit}/edit")
    public String ipsEditarForm(@PathVariable("nit") int nit, Model model) {
        IpsEntity ips = ipsRepository.darIp(nit);
        if (ips != null) {
            model.addAttribute("ips", ips);
            return "ipsEditar"; 
        } else {
            return "redirect:/ips";
        }
    }

    
    @PostMapping("/ips/{nit}/edit/save")
    public String ipsEditarGuardar(@PathVariable("nit") int nit, @ModelAttribute IpsEntity ips) {
        
        ipsRepository.actualizarIp(nit, ips.getNombre(), ips.getDireccion(), ips.getTelefono(), ips.getHorario());
        return "redirect:/ips";
    }

    
    @GetMapping("/ips/{nit}/delete")
    public String ipsEliminar(@PathVariable("nit") int nit) {
        ipsRepository.eliminarIp(nit);
        return "redirect:/ips";
    }
}
