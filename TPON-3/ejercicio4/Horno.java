package ejercicio4;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Horno implements Runnable{

	private LinkedBlockingQueue<Galleta> buffer;
	private Random r;
	
	public Horno(LinkedBlockingQueue<Galleta> buffer) {
		this.buffer = buffer;
		this.r = new Random();
	}
	
	public void run() {
		try {
			while(true) {
				Thread.sleep(r.nextInt(1000)+1000);		//Se esta horneando una galleta
				buffer.put(new Galleta());				//Coloca la galleta en el buffer
				System.out.println("El horno " + Thread.currentThread().getName() + " horneo una galleta.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
