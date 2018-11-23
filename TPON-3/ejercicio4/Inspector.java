package ejercicio4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;

public class Inspector implements Runnable{

	private DelayQueue<Galleta> zonaEnfriamiento;
	private ArrayBlockingQueue<Galleta> cinta;
	private Galleta galleta;
	private Random r;
	
	public Inspector(DelayQueue<Galleta> zonaEnfriamiento , ArrayBlockingQueue<Galleta> cinta) {
		this.zonaEnfriamiento = zonaEnfriamiento;
		this.cinta = cinta;
		this.r = new Random();
	}
	
	public void run() {
		try {
			while(true) {
				galleta = zonaEnfriamiento.take();	//Agarra la galleta que sale de la zona de enfriamiento;
				System.out.println("Inspector " + Thread.currentThread().getName() +" esta inspeccionando una galleta.");
				Thread.sleep(1000);					//Inspecciona la galleta
				if(r.nextBoolean()) {				//La galleta pasa la inspeccion
					cinta.put(galleta);				//Coloca la galleta en la cinta.
					System.out.println("Inspector " + Thread.currentThread().getName() + " coloco una galleta en la cinta.");
				} else {							//La galleta no pasa la inspeccion
					System.out.println("Inspector " + Thread.currentThread().getName() + " se comio la galleta.");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
