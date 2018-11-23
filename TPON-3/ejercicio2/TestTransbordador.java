package ejercicio2;


public class TestTransbordador {

	public static void main(String[] args) {
		Espacio espacio = new Espacio(0, 5);
		Transbordador transb = new Transbordador(espacio);
		Thread transbordador = new Thread(transb);
		transbordador.start();

		cargarAutos(20, espacio);

	}

	public static void cargarAutos(int cant, Espacio space) {
		Auto[] arrAutos = new Auto[cant];
			for (int i = 0; i < cant; i++) {
				arrAutos[i] = new Auto(i, space);
			}

			for (int i = 0; i < cant; i++) {
				Thread auto = new Thread(arrAutos[i]);
				auto.start();
			}
	}

}