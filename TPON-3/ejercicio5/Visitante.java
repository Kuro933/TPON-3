package ejercicio5;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class Visitante implements Runnable{
	private String nombre;
	private Exchanger<Regalo> intercambio;
	private Regalo regalo;
	private Random r;		//Random para el tiempo de accion
	
	public Visitante(Exchanger<Regalo> intercambio) {
		this.nombre = NameGenerator.generarNombre();
		this.intercambio = intercambio;
		this.regalo = new Regalo();
		this.r = new Random();
	}
	
	public void run() {
		try {
			System.out.println(nombre + " entro con " + regalo.toString());
			regalo = intercambio.exchange(regalo);
			Thread.sleep(r.nextInt(5000));		//Se queda dando vueltas durante un tiempo indeterminado.
			System.out.println(nombre + " salio con " + regalo.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
