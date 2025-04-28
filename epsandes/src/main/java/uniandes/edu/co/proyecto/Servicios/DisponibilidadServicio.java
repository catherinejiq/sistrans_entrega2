package uniandes.edu.co.proyecto.Servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import uniandes.edu.co.proyecto.modelo.DisponibilidadSlot;
import uniandes.edu.co.proyecto.repositories.AgendaDisponibilidad;
import uniandes.edu.co.proyecto.repositories.DisponibilidadRepository;

@Service
public class DisponibilidadServicio {

    private final DisponibilidadRepository repo;
    public DisponibilidadServicio(DisponibilidadRepository repo) {
        this.repo = repo;
    }
    @Transactional(
    isolation   = Isolation.SERIALIZABLE,
    readOnly    = true,
    rollbackFor = Exception.class
)
public List<AgendaDisponibilidad> consultarAgenda(
        LocalDateTime inicio,
        LocalDateTime fin,
        Integer medicoId,
        Integer servicioId) {
    try {
        // Pausa de 30 segundos (30,000 ms) antes de lanzar la consulta
        System.out.println("Iniciando consulta con parámetros: " +
            "inicio=" + inicio + ", fin=" + fin + 
            ", medicoId=" + medicoId + ", servicioId=" + servicioId);
        Thread.sleep(30_000); // 30 segundos como especifica el requisito
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        throw new RuntimeException("Consulta interrumpida", e);
    }

    try {
        // Usa el método nativo si prefieres esa aproximación
        // List<AgendaDisponibilidad> resultado = repo.consultarAgendaNativa(inicio, fin, medicoId, servicioId);
        List<AgendaDisponibilidad> resultado = repo.consultarAgenda(inicio, fin, medicoId, servicioId);
        System.out.println("Consulta ejecutada. Resultados obtenidos: " + resultado.size());
        return resultado;
    } catch (Exception ex) {
        System.err.println("Error al consultar agenda: " + ex.getMessage());
        ex.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        throw new RuntimeException(
            "Error al consultar agenda: " + ex.getMessage(), ex
        );
    }
}
@Transactional(
    isolation   = Isolation.READ_COMMITTED,
    readOnly    = true,
    rollbackFor = Exception.class
)
public List<AgendaDisponibilidad> consultarAgendaReadCommitted(
        LocalDateTime inicio,
        LocalDateTime fin,
        Integer medicoId,
        Integer servicioId) {
    try {
        // Pausa de 30 segundos (30,000 ms) antes de lanzar la consulta
        System.out.println("Iniciando consulta con parámetros: " +
            "inicio=" + inicio + ", fin=" + fin + 
            ", medicoId=" + medicoId + ", servicioId=" + servicioId);
        Thread.sleep(30_000); // 30 segundos como especifica el requisito
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        throw new RuntimeException("Consulta interrumpida", e);
    }

    try {
        // Usa el método nativo si prefieres esa aproximación
        // List<AgendaDisponibilidad> resultado = repo.consultarAgendaNativa(inicio, fin, medicoId, servicioId);
        List<AgendaDisponibilidad> resultado = repo.consultarAgenda(inicio, fin, medicoId, servicioId);
        System.out.println("Consulta ejecutada. Resultados obtenidos: " + resultado.size());
        return resultado;
    } catch (Exception ex) {
        System.err.println("Error al consultar agenda: " + ex.getMessage());
        ex.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        throw new RuntimeException(
            "Error al consultar agenda: " + ex.getMessage(), ex
        );
    }
}
@Transactional(readOnly = true)
    public List<DisponibilidadSlot> consultarAgendaProximas4Semanas(Integer codigoServicio) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fourWeeksLater = now.plusWeeks(4);
        return repo.findNext4Weeks(codigoServicio, now, fourWeeksLater);
    }
}
