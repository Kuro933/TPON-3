package ejercicio4;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Galleta implements Delayed{
	
	private long tiempoDeEnfriamiento;	//Tiempo que tarda en enfriarse la galleta.
	
	
	public Galleta() {
		this.tiempoDeEnfriamiento = System.currentTimeMillis() + 7000;	//Tarda 7 segundos en enfriarse luego de que se crea.
	}
	
	@Override
	public int compareTo(Delayed otra) {
		//Compara su tiempo con otra galleta para saber si tiene prioridad en la DelayQueue o no.
		int devolucion;
	    Galleta otraGalleta = (Galleta) otra;
	    
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
