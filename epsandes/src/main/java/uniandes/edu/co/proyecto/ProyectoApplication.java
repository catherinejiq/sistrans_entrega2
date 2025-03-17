package uniandes.edu.co.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collection;

import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;
import uniandes.edu.co.proyecto.repositories.IpsRepository;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.IpsEntity;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private IpsRepository afiliadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Ejecutando CommandLineRunner...");
		
		Collection<IpsEntity> afiliados = afiliadoRepository.darIps();
		System.out.println("Afiliados: " + afiliados.size());
		//AfiliadoEntity afiliado = afiliadoRepository.darAfiliado(1);
		//System.out.println(afiliado);
		for (IpsEntity a : afiliados) {
			System.out.println(a);
		}
		//AfiliadoEntity afiliado = afiliadoRepository.darAfiliado(1);
		//System.out.println(afiliado);
		//afiliadoRepository.eliminarAfiliado(9);
		//AfiliadoEntity afiliado = afiliadoRepository.darAfiliado(9);
		//System.out.println(afiliado);
		System.out.println("Finalizando CommandLineRunner...");
	}
	

}
