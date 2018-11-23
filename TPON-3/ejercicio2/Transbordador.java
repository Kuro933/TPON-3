package ejercicio2;

public class Transbordador implements Runnable{
	private Espacio espacio;
	
	public Transbordador(Espacio espacio) {
		this.espacio=espacio;
	}
	public void run() {
		while(true) {
			espacio.ir();
			espacio.volver();
			
		}
	}

}