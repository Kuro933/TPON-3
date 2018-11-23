package ejercicio2;

public class Transbordador implements Runnable{
	private Espacio espacio;
	
	public Transbordador(Espacio espacio) {
		this.espacio=espacio;
	}
	public void run() {
		while(true) {
			try{
			espacio.ir();
			Thread.sleep(1000);
			System.out.println("El transbordador llego al oeste");
			espacio.volver();
			Thread.sleep(1000);
			System.out.println("El transbordador llego al este");
			}catch(Exception e){
				
			}
			
		}
	}

}