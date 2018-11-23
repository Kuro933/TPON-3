package ejercicio3;

public class Lector implements Runnable {

	private Libro libro;
	private int id;

	public Lector(int id, Libro libro) {
		this.id = id;
		this.libro = libro;
	}

	public void run() {
		try {
			while (true) {
				//hacer metodo de esperar para leer con tiempo random
				libro.leer();
				System.out.println("lector " + id + " esta leyendo");
				Thread.sleep(2000);
				libro.terminarLeer();
				System.out.println("lector " + id + " termino de leer");
				Thread.sleep(4000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}