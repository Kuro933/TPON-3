package ejercicio4;

import java.util.concurrent.SynchronousQueue;

public class Cliente implements Runnable{

	private String nombre;
	private SynchronousQueue<Galleta> zonaMuestra;
	private Galleta galleta;
	
	public Cliente(SynchronousQueue<Galleta> zonaMuestra) {
		this.nombre = NameGenerator.generarNombre();
		this.zonaMuestra = zonaMuestra;
	}
	
	public void run() {
		try {
			galleta = zonaMuestra.take();
			System.out.println(this.nombre + " tomo la galleta y se la comio.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
