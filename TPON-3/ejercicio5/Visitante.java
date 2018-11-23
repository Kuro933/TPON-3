package ejercicio5;

import java.util.concurrent.Exchanger;

public class Visitante implements Runnable{
	private String nombre;
	private Exchanger intercambio;
	private Regalo regalo;
	
	public Visitante(String nombre , Exchanger intercambio) {
		this.nombre = nombre;
		this.intercambio = intercambio;
	}
	
	public void run() {
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
