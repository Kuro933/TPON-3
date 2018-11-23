package ejercicio4;

import java.util.concurrent.LinkedBlockingQueue;

public class Contenedor {
	private int contenido = 0;
	private Cola cola = new Cola();
	private LinkedBlockingQueue list;

	public Contenedor() {
		this.contenido = 0;
		this.list = new LinkedBlockingQueue();
	}

	public synchronized int get() {
		int elemento= 0;
		while (contenido > 0) {
			elemento = (int) list.poll();
			contenido--;
		}
		return elemento;
	}

	public synchronized void put(int value) {
		
		try {
			list.put(value);
			contenido++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}