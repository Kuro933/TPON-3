package ejercicio5;

import java.util.concurrent.Exchanger;

public class Visitante implements Runnable{
	private String nombre;
	private Alimento alimento;
	private Exchanger intercambio;
	private Object bono;
	
	public Visitante(String nombre , Exchanger intercambio , Object bono) {
		this.nombre = nombre;
		this.intercambio = intercambio;
		this.bono = bono;
	}
	
	public void run() {
		try {
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}