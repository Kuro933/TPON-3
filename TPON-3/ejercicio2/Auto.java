package ejercicio2;

public class Auto implements Runnable{
	
	private int id;
	private Espacio espacio;
	public Auto(int id,Espacio espacio) {
		this.id=id;
		this.espacio=espacio;
	}
	
	public void run() {
		try {
			System.out.println("Auto "+this.id+" viajando hacia transbordador");
			espacio.subir(this);
			Thread.sleep(1000);
			espacio.bajar(this);
			System.out.println("\n El auto "+this.id+" se fue al infinito");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public int getId() {
		return this.id;
	}
}