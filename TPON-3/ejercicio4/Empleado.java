package ejercicio4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Empleado implements Runnable{

	private ArrayBlockingQueue<Galleta> cinta;
	private SynchronousQueue<Galleta> zonaMuestra;
	private Galleta galleta;
	
	public Empleado(ArrayBlockingQueue<Galleta> cinta , SynchronousQueue<Galleta> zonaMuestra) {
		this.cinta = cinta;
		this.zonaMuestra = zonaMuestra;
	}
	
	public void run() {
		try {
			while(true) {
				galleta = cinta.take();		//Toma la galleta de la cinta.
				System.out.println("Empleado " + Thread.currentThread().getName() + " agarro una galleta de la cinta.");
				zonaMuestra.put(galleta);	//Le ofrece una galleta a un cliente
				System.out.println("Empleado " + Thread.currentThread().getName() + " entrego una galleta.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
