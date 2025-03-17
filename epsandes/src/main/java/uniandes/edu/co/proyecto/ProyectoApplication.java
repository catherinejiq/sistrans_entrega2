package uniandes.edu.co.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collection;

import uniandes.edu.co.proyecto.repositories.AfiliadoRepository;
import uniandes.edu.co.proyecto.repositories.ExamenDiagnosticoRepository;
import uniandes.edu.co.proyecto.repositories.IpsAfiliadoRepository;
import uniandes.edu.co.proyecto.repositories.IpsRepository;
import uniandes.edu.co.proyecto.repositories.OrdenServicioRepository;
import uniandes.edu.co.proyecto.modelo.AfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.ExamenDiagnosticoEntity;
import uniandes.edu.co.proyecto.modelo.IpsAfiliadoEntity;
import uniandes.edu.co.proyecto.modelo.IpsEntity;
import uniandes.edu.co.proyecto.modelo.OrdenServicioEntity;


@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private IpsAfiliadoRepository afiliadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Ejecutando CommandLineRunner...");
		
		Collection<IpsAfiliadoEntity> afiliados = afiliadoRepository.darIpsAfiliados();
		System.out.println("Afiliados: " + afiliados.size());
		//AfiliadoEntity afiliado = afiliadoRepository.darAfiliado(1);
		//System.out.println(afiliado);
		for (IpsAfiliadoEntity a : afiliados) {
			System.out.println(a);
		}
		IpsAfiliadoEntity afiliado = afiliadoRepository.darIpsAfiliadoPorId(2,2);
		System.out.println(afiliado);
		afiliadoRepository.eliminarIpsAfiliado(2,2);
		IpsAfiliadoEntity afiliado1 = afiliadoRepository.darIpsAfiliadoPorId(2,2);
		System.out.println(afiliado1);
		//AfiliadoEntity afiliado = afiliadoRepository.darAfiliado(9);
		//System.out.println(afiliado);
		System.out.println("Finalizando CommandLineRunner...");
	}
	

}
