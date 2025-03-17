package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;
import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class AfiliadosController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping("/afiliados")
    public String afiliados(Model model) {
        model.addAttribute("afiliados",afiliadoRepository.darAfiliados());
        return model.toString();
    }

    @GetMapping("/afiliados/new")
    public String afiliadoForm(Model model) {
        model.addAttribute("afiliado", new AfiliadoEntity());
        return "afiliadoNuevo";
    }

    @PostMapping("/afiliados/new/save")
    public String afiliadoGuardar(@ModelAttribute AfiliadoEntity afiliado) {
        afiliadoRepository.insertarAfiliado(afiliado.getTipoDocumento(), afiliado.getNombre(),afiliado.getFechaNacimiento(), afiliado.getDireccion(),afiliado.getTelefono(),afiliado.getParentesco(),afiliado.getTipoAfiliado().toString(),afiliado.getContribuyente().getIdAfiliado());

        return "redirect:/afiliados";
    }
    

    @GetMapping("afiliados/{id}/edit")
    public String afiliadoEditarForm(@PathVariable("id") int id, Model model) {
        AfiliadoEntity afiliado = afiliadoRepository.darAfiliado(id);
        if( afiliado!= null){
            model.addAttribute("afiliado", afiliado);
            return "afiliadoEditar";
        }else {
            return "redirect:/afiliados";
        }
    }
    
    @PostMapping("/afiliados/{id}/edit/save")
    public String afiliadoEditarGuardar(@PathVariable("id") int id, @ModelAttribute AfiliadoEntity afiliadoEntity ) {
        afiliadoRepository.actualizarAfiliado(id, afiliadoEntity.getTipoDocumento(), afiliadoEntity.getNombre(), afiliadoEntity.getFechaNacimiento(), afiliadoEntity.getDireccion(), afiliadoEntity.getTelefono(), afiliadoEntity.getParentesco(), afiliadoEntity.getTipoAfiliado().toString(), afiliadoEntity.getContribuyente().getIdAfiliado());
        return "redirect:/afiliados";
    }
    
    @GetMapping("/afiliados/{id}/delete")
    public String afiliadoEliminar(@PathVariable("id") int id) {
        afiliadoRepository.eliminarAfiliado(id);
        return "redirect:/afiliados";
    }
    
    "
    Listo commit
    "
    
}
