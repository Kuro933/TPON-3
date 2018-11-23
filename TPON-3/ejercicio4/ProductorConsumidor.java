package ejercicio4;

public class ProductorConsumidor {
	private static Contenedor contenedor;
	private static Thread productor;
//    private static Thread productor2;
	private static Thread[] consumidores;
	private static final int cantConsumidor = 5;

	public static void main(String[] args) {
		contenedor = new Contenedor();
		productor = new Thread(new Productor(contenedor, 1));
//        productor2 = new Thread(new Productor(contenedor, 2));
		consumidores = new Thread[cantConsumidor];

		for (int i = 0; i < cantConsumidor; i++) {
			consumidores[i] = new Thread(new Consumidor(contenedor, i));
			consumidores[i].start();
		}

		productor.start();
//        productor2.start();
	}
}
