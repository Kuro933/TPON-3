package ejercicio4;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Galleta implements Delayed{
	
	private int id;
	private long tiempoDeEnfriamiento;	//Tiempo que tarda en enfriarse la galleta
	
	
	public Galleta(int id) {
		this.id = id;
		this.tiempoDeEnfriamiento = 10000;
	}
	
	@Override
	public int compareTo(Delayed otro) {
		//Compara su tiempo con otra galleta para saber si tiene prioridad en la DelayQueue o no.
		int devolucion;
	    Galleta otraGalleta = (Galleta) otro;
	    
	    if (this.tiempoDeEnfriamiento < otraGalleta.tiempoDeEnfriamiento) {
	        devolucion = -1;
	    }else if (this.tiempoDeEnfriamiento > otraGalleta.tiempoDeEnfriamiento) {
	        devolucion = 1;
	    } else {
	    	devolucion = 0;
	    }
	 
	    return devolucion;
	}

	@Override
	public long getDelay(TimeUnit timeUnit) {
	    long diferencia = tiempoDeEnfriamiento - System.currentTimeMillis();
	    return timeUnit.convert(diferencia, TimeUnit.MILLISECONDS);
	}

}
