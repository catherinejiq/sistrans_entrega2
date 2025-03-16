package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.repositories.IpsRepository;
import uniandes.edu.co.proyecto.modelo.IpsEntity;


@RestController
@RequestMapping("/ips")
public class IpsController {

    @Autowired
    private IpsRepository ipsRepository;

    // Endpoint para registrar una IPS
    @PostMapping("/registrar")
    public ResponseEntity<IpsEntity> registrarIps(@RequestBody IpsEntity ips) {
        IpsEntity nuevaIps = ipsRepository.save(ips);
        return new ResponseEntity<>(nuevaIps, HttpStatus.CREATED);
    }
}
