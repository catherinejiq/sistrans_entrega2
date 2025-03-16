package uniandes.edu.co.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collection;

import uniandes.edu.co.proyecto.repositories.IpsRepository;
import uniandes.edu.co.proyecto.modelo.IpsEntity;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private IpsRepository ipsRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Ejecutando CommandLineRunner...");
		
		Collection<IpsEntity> ips = ipsRepository.darIps();
		System.out.println("Ipsrecuperadas: " + ips.size());
	
		for (IpsEntity ip : ips) {
			System.out.println(ip);
		}
		
		System.out.println("Finalizando CommandLineRunner...");
	}
	

}
