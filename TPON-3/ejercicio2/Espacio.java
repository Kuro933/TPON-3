package ejercicio2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

public class Espacio {

	private int cantActual, cantLleno;
	private CyclicBarrier transbordador;
	private LinkedBlockingQueue<Object> autoEntrado;
	private LinkedBlockingQueue<Object> autoSaliendo;

	public Espacio(int actual, int lleno) {
		this.cantActual = actual;
		this.cantLleno = lleno;
		this.transbordador = new CyclicBarrier(11);
		this.autoEntrado = new LinkedBlockingQueue<Object>();
		this.autoSaliendo = new LinkedBlockingQueue<Object>();
	}

	public void subir(Auto auto) {
		try {

			this.autoEntrado.take();
			System.out.println("auto " + auto.getId() + " subio");
			this.transbordador.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bajar(Auto auto) {
		try {

			this.autoSaliendo.take();
			System.out.println("Auto " + auto.getId() + " bajo del transbordador");
			this.transbordador.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ir() {
		try {
			System.out.println("El transbordador esta esperando que entren todos los autos");
			for (int i = 0; i < 10; i++) {
				this.autoEntrado.add(i);
			}
			this.transbordador.await();
			System.out.println("El transbordador esta viajando");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void volver() {
		try {
			System.out.println("El transordador esta esperando que bajen todos los autos");
			for (int j = 0; j < 10; j++) {
				this.autoSaliendo.add(j);
			}

			this.transbordador.await();
			System.out.println("El transbordador esta volviendo");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
