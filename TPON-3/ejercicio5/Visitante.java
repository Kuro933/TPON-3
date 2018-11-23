package ejercicio5;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Visitante implements Runnable{
	private String nombre;					//Nombre de la persona
	private Exchanger<Regalo> intercambio;	//"zona" de intercambio
	private Regalo regalo;					//Regalo que va a intercambiar la persona
	private Random r;						//Random para el tiempo de accion
	
	public Visitante(Exchanger<Regalo> intercambio) {
		this.nombre = NameGenerator.generarNombre();
		this.intercambio = intercambio;
		this.regalo = new Regalo();
		this.r = new Random();
	}
	
	public void run() {
		try {
			//La persona entra al salon con su regalo.
			System.out.println(nombre + " entro con " + regalo.toString());
			Thread.sleep(r.nextInt(5000));	//Se queda dando vueltas durante un tiempo indeterminado.
			regalo = intercambio.exchange(regalo);
			//Se va del salon con el regalo de otro.
			System.out.println(nombre + " salio con " + regalo.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
