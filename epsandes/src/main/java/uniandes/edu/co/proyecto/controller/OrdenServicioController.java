package uniandes.edu.co.proyecto.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;
import uniandes.edu.co.proyecto.repositories.OrdenServicioRepository;



@RestController
@RequestMapping("/orden-servicio")  // Prefijo para las rutas
public class OrdenServicioController {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    // 🔹 Obtener todas las órdenes de servicio
    @GetMapping
    public ResponseEntity<Collection<OrdenServicioEntity>> obtenerOrdenes() {
        try {
            Collection<OrdenServicioEntity> ordenes = ordenServicioRepository.darOrdenesServicio();
            return ResponseEntity.ok(ordenes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 🔹 Obtener una orden de servicio por su ID
    @GetMapping("/{idOrden}")
    public ResponseEntity<OrdenServicioEntity> obtenerOrden(@PathVariable("idOrden") int idOrden) {
        try {
            OrdenServicioEntity orden = ordenServicioRepository.darOrdenServicio(idOrden);
            return (orden != null) ? ResponseEntity.ok(orden) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 🔹 Insertar una nueva orden de servicio
    @PostMapping("/new/save")
    public ResponseEntity<String> guardarOrden(@RequestBody OrdenServicioEntity orden) {
        try {
            ordenServicioRepository.insertarOrdenServicio(
                orden.getTipoOrden(),
                orden.getReceta(),
                orden.getEstado(),
                orden.getFecha(),
                orden.getAfiliado().getIdAfiliado(),
                orden.getMedico().getIdMedico()
            );
            return new ResponseEntity<>("Orden de servicio creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al crear la orden de servicio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 🔹 Editar una orden de servicio existente
    @PostMapping("/{idOrden}/edit/save")
    public ResponseEntity<String> editarOrden(@PathVariable("idOrden") int idOrden, 
                                              @RequestBody OrdenServicioEntity orden) {
        try {
            ordenServicioRepository.actualizarOrdenServicio(
                idOrden,
                orden.getTipoOrden(),
                orden.getReceta(),
                orden.getEstado(),
                orden.getFecha(),
                orden.getAfiliado().getIdAfiliado(),
                orden.getMedico().getIdMedico()
            );
            return new ResponseEntity<>("Orden de servicio actualizada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la orden de servicio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 🔹 Eliminar una orden de servicio
    @DeleteMapping("/{idOrden}/delete")
    public ResponseEntity<String> eliminarOrden(@PathVariable("idOrden") int idOrden) {
        try {
            ordenServicioRepository.eliminarOrdenServicio(idOrden);
            return new ResponseEntity<>("Orden de servicio eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar la orden de servicio", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

