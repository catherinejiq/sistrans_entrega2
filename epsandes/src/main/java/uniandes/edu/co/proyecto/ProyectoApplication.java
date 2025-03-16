package uniandes.edu.co.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collection;

import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private AfiliadoRepository afiliadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Ejecutando CommandLineRunner...");
		
		Collection<AfiliadoEntity> afiliados = afiliadoRepository.darAfiliados();
		System.out.println("Afiliados: " + afiliados.size());
	
		for (AfiliadoEntity a : afiliados) {
			System.out.println(a);
		}
		
		System.out.println("Finalizando CommandLineRunner...");
	}
	

}
