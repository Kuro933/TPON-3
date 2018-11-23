package ejercicio1;

public class HiloVerificador implements Runnable{
	private BufferCompartido buffer;
	private int inicio,fin,cont;
	public HiloVerificador(BufferCompartido arr, int inicio, int fin){
		this.inicio=inicio;
		this.fin=fin;
		this.buffer=arr;
	}
	
	public void run(){
		for(int i=inicio;i<=fin;i++){
			cont+=buffer.obtenerElem(i);
		}
	}
	
	public int getContador(){
		return this.cont;
	}

}