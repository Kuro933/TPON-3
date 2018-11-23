package ejercicio3;

public class Escritor implements Runnable {

	private Libro libro;
	private int id;

	public Escritor(int id, Libro libro) {
		this.id = id;
		this.libro = libro;
	}

	public void run() {
		try {
			while (true) {
				//hacer un metodo para que espere un tiempo random antes de escribir
				libro.escribir();
				System.out.println("escritor " + id + " esta escribiendo");
				Thread.sleep(3000);
				libro.terminarEscribir();
				System.out.println("escritor " + id + " termino de escribir");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
