package ejercicio1;

import java.util.Random;
import java.util.concurrent.atomic.*;


public class BufferCompartido {

	private int[] contenido;
	private Random rnd = new Random();
	private AtomicLong suma;
	
	public BufferCompartido(int cantElem) {
		this.contenido = new int[cantElem];
		this.rnd = new Random();
		this.suma = new AtomicLong();
		this.cargarContenido(cantElem);
	}
	
	
	public void cargarContenido(int cant) {
		for(int i = 0; i < cant; i++) {
			this.contenido[i] = (rnd.nextInt(50)+1);
		}
	}
	
	public int obtenerElem(int pos) {
		return contenido[pos];
	}
	
	public int obtenerValor() {
		return suma.intValue();
	}
	
	public void sumar(int val) {
		suma.getAndAdd(val);
	}
}
