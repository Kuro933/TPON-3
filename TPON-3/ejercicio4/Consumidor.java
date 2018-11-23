package ejercicio4;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable{

	private BlockingQueue<Object> buffer;
	private Object objeto;					//Objeto que retira del buffer
	private Random r;
	
	public Consumidor(BlockingQueue<Object> buffer) {
		this.buffer = buffer;
		this.r = new Random();
	}
	
	public void run() {
		try {
			//El consumidor consume infinitamente
			while(true) {
				objeto = buffer.take();
				System.out.println("El consumidor " + Thread.currentThread().getName() + " retiro del buffer.");
				Thread.sleep(r.nextInt(1000) + 1000);		//Simula el tiempo que tarda el consumidor en agarrar el objeto
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
