package ejercicio4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Lugar {
	
	/*
	 * Decidimos utilizar LinkedBlockingQueue porque los elementos son manejados
	 * como FIFO (First-in First-out), lo cual es una implementacion que se
	 * asemeja al funcionamiento en la vida real.
	 * 
	 * */
	
	
	public static void main(String[] args) {
		final int CANT_PRODUCTORES = 10;
		final int CANT_CONSUMIDORES = 5;
		final int CAPACIDAD = 1;			//Capacidad del buffer
		
		BlockingQueue<Object> buffer = new LinkedBlockingQueue<Object>(CAPACIDAD);
		Productor[] productores = new Productor[CANT_PRODUCTORES];
		Consumidor[] consumidores= new Consumidor[CANT_CONSUMIDORES];
		
		iniciar(consumidores , productores , buffer);
	}
	
	public static void iniciar(Consumidor[] consumidores , Productor[] productores ,  BlockingQueue<Object> buffer) {
		int id = 1;
		//Carga de consumidores
		for(int i = 0; i < consumidores.length; i++) {
			consumidores[i] = new Consumidor(buffer);
		}
		
		//Carga de productores
		for(int i = 0; i < productores.length; i++) {
			productores[i] = new Productor(buffer);
		}
		
		//Inician los hilos
		for(Productor productor : productores) {
			new Thread(productor , Integer.toString(id)).start();
			id++;
		}
		id = 1;
		for(Consumidor consumidor : consumidores) {
			new Thread(consumidor , Integer.toString(id)).start();
			id++;
		}
		
	}
	
}
