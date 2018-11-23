package ejercicio4;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BrazoMecanico implements Runnable{

	private Galleta galleta;
	private LinkedBlockingQueue<Galleta> buffer;
	private DelayQueue<Galleta> zonaEnfriamiento;
	
	public BrazoMecanico(LinkedBlockingQueue<Galleta> buffer , DelayQueue<Galleta> zonaEnfriamiento) {
		this.buffer = buffer;
		this.zonaEnfriamiento = zonaEnfriamiento;
	}
	
	public void run() {
		try {
			while(true) {
				galleta = buffer.take();		//El brazo agarra la galleta del buffer
				System.out.println("El brazo " + Thread.currentThread().getName() + " agarro una galleta.");
				zonaEnfriamiento.put(galleta);	//Coloca la galleta en la zona de enfriamiento.
				System.out.println("El brazo " + Thread.currentThread().getName() + " coloco una galleta en la zona de enfriamiento.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
