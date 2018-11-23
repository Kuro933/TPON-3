package ejercicio1;
import java.util.concurrent.CountDownLatch;

public class HiloSumador implements Runnable{

	private BufferCompartido buffer;
	private int id, inicio, fin, cont;
	private CountDownLatch disminuir;
	public HiloSumador(int id,int ini, int end , BufferCompartido arr, CountDownLatch cuenta) {
		this.inicio = ini;
		this.fin = end;
		this.buffer = arr;
		this.disminuir = cuenta;
		this.id = id;
	}
	
	public void run() {
		for(int i = inicio; i< fin;  i++) {
			cont += buffer.obtenerElem(i);
		}
		
		buffer.sumar(cont);
		disminuir.countDown();
		System.out.println("hilo " + this.id + " dejo el cerrojo con " + disminuir.getCount() + " permisos");
	}
}
