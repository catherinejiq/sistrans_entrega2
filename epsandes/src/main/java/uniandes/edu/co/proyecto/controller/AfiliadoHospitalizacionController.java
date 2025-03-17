package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.AfiliadoHospitalizacionEntity;
import uniandes.edu.co.proyecto.repositories.AfiliadoHospitalizacionRepository;

@RestController
public class AfiliadoHospitalizacionController {

    @Autowired
    private AfiliadoHospitalizacionRepository afiliadoHospitalizacionRepository;

    @GetMapping("/afiliado-hospitalizacion")
    public String listarAfiliadoHospitalizacion(Model model) {
        Collection<AfiliadoHospitalizacionEntity> relaciones = afiliadoHospitalizacionRepository.darAfiliadoHospitalizaciones();
        model.addAttribute("relaciones", relaciones);
        return model.toString();
    }

    @GetMapping("/afiliado-hospitalizacion/new")
    public String formularioNuevaRelacion(Model model) {
        model.addAttribute("afiliadoHospitalizacion", new AfiliadoHospitalizacionEntity());
        return "afiliadoHospitalizacionNuevo";
    }

    @PostMapping("/afiliado-hospitalizacion/new/save")
    public String guardarAfiliadoHospitalizacion(@RequestParam("idAfiliado") Integer idAfiliado,
                                                 @RequestParam("idHospitalizacion") Integer idHospitalizacion) {
        afiliadoHospitalizacionRepository.insertarAfiliadoHospitalizacion(idAfiliado, idHospitalizacion);
        return "redirect:/afiliado-hospitalizacion";
    }

    @GetMapping("/afiliado-hospitalizacion/{idAfiliado}/{idHospitalizacion}/edit")
    public String formularioEditarRelacion(@PathVariable("idAfiliado") Integer idAfiliado,
                                           @PathVariable("idHospitalizacion") Integer idHospitalizacion,
                                           Model model) {
        AfiliadoHospitalizacionEntity entidad = afiliadoHospitalizacionRepository.darAfiliadoHospitalizacionPorId(idAfiliado, idHospitalizacion);
        if (entidad != null) {
            model.addAttribute("afiliadoHospitalizacion", entidad);
            return "afiliadoHospitalizacionEditar";
        }
        return "redirect:/afiliado-hospitalizacion";
    }

    @PostMapping("/afiliado-hospitalizacion/{idAfiliado}/{idHospitalizacion}/edit/save")
    public String editarAfiliadoHospitalizacion(@PathVariable("idAfiliado") Integer idAfiliado,
                                                @PathVariable("idHospitalizacion") Integer idHospitalizacion,
                                                @RequestParam("idAfiliado_actualizado") Integer idAfiliadoActualizado,
                                                @RequestParam("idHospitalizacion_actualizado") Integer idHospitalizacionActualizado) {
        afiliadoHospitalizacionRepository.actualizarAfiliadoHospitalizacion(idAfiliado, idHospitalizacion, idAfiliadoActualizado, idHospitalizacionActualizado);
        return "redirect:/afiliado-hospitalizacion";
    }

    @GetMapping("/afiliado-hospitalizacion/{idAfiliado}/{idHospitalizacion}/delete")
    public String eliminarAfiliadoHospitalizacion(@PathVariable("idAfiliado") Integer idAfiliado,
                                                  @PathVariable("idHospitalizacion") Integer idHospitalizacion) {
        afiliadoHospitalizacionRepository.eliminarAfiliadoHospitalizacion(idAfiliado, idHospitalizacion);
        return "redirect:/afiliado-hospitalizacion";
    }
}
