package ejercicio4;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable{
	
	private BlockingQueue<Object> buffer;
	private final int CANT_MINIMA = 20;		//Cantidad minima a productir
	private Random r;						//Cantidad aleatoria de objetos a producir
	
	
	public Productor(BlockingQueue<Object> buffer) {
		this.buffer = buffer;
		this.r = new Random();
	}
	
	public void run() {
		try {
			//El productor produce objetos
			for(int i = 0; i < r.nextInt(10) + CANT_MINIMA; i++) {
				System.out.println("Productor " + Thread.currentThread().getName() + " produjo un objeto.");
				buffer.put(new Object());
				Thread.sleep(r.nextInt(1000) + 1000);		//Simula el tiempo de produccion del objeto
			}
			System.out.println("Productor " + Thread.currentThread().getName() + " dejo de producir");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
