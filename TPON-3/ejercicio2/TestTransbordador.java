package ejercicio2;

import java.util.Random;

public class TestTransbordador {

	public static void main(String[] args) {
		Espacio espacio = new Espacio(0, 5);
		Transbordador transb = new Transbordador(espacio);
		Thread transbordador = new Thread(transb);
		transbordador.start();

		cargarAutos(10, espacio);

	}

	public static void cargarAutos(int cant, Espacio space) {
		Random rnd = new Random();
		Auto[] arrAutos = new Auto[cant];
//		try {
			for (int i = 0; i < cant; i++) {
				arrAutos[i] = new Auto(i, space);
			}

			for (int i = 0; i < cant; i++) {
				Thread auto = new Thread(arrAutos[i]);
//				auto.sleep(rnd.nextInt(2000));
				auto.start();
			}
//		} catch (InterruptedException e) {

//		}
	}

}