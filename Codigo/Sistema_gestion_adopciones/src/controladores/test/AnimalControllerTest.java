package controladores.test;

import java.util.Date;

import controladores.AnimalController;
import controladores.ClienteController;
import modelo.dto.AnimalDto;
import modelo.enumeraciones.EstadoAnimal;
import modelo.enumeraciones.TipoAnimal;
import vistas.AnimalView;
import vistas.ClienteView;
import vistas.VentanaPrincipalAnimal;
import vistas.VentanaRegistroAnimal;

public class AnimalControllerTest {
	public static void main(String[] args) {
		System.out.println("AnimalControllerTest BEGIN");
		
		AnimalController controlador = new AnimalController();
		
		//Animales de prueba
		controlador.cargarAnimal(new AnimalDto(199,5000,new Date(), "Perro",EstadoAnimal.EN_TRATAMIENTO, TipoAnimal.DOMESTICO));
		controlador.cargarAnimal(new AnimalDto(120,3021,new Date(), "Gato",EstadoAnimal.SALUDABLE, TipoAnimal.SALVAJE));
		
		
		VentanaPrincipalAnimal ventanaPrincipal = new VentanaPrincipalAnimal();
		VentanaRegistroAnimal ventanaRegistro = new VentanaRegistroAnimal();
		
		ventanaPrincipal.setController(controlador);
		ventanaRegistro.setController(controlador);
		
		controlador.setVentanaPrincipal(ventanaPrincipal);
		controlador.setVentanaRegistro(ventanaRegistro);
		
		controlador.mostrarVentanaPrincipal();
		

		
	}
}
