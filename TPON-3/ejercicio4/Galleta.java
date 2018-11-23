package ejercicio4;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Galleta implements Delayed{
	
	private int id;
	private long tiempoDeEnfriamiento;	//Tiempo que tarda en enfriarse la galleta
	
	
	public Galleta(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Delayed arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getDelay(TimeUnit arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
