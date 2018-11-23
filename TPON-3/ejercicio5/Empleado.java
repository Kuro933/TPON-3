package ejercicio5;

import java.util.concurrent.Exchanger;

public class Empleado implements Runnable{
	private String nombre;
	private Exchanger intercambio;
	
	public Empleado(String nombre , Exchanger intercambio) {
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
