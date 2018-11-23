package ejercicio4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Fabrica {
	
	public static void main(String[] args) {
		final int CANT_HORNOS = 10;
		final int CANT_BRAZOSMECANICOS = 5;
		final int CANT_INSPECTORES = 3;
		final int CANT_EMPLEADOS = 5;
		final int CANT_CLIENTES = 50;
		final int CAPACIDAD = 1;	//Capacidad de la cinta donde se colocan las galletas cuando el inspector termina de inspeccionarlas
		
		
		LinkedBlockingQueue<Galleta> buffer =	new LinkedBlockingQueue<Galleta>();
		DelayQueue<Galleta> zonaEnfriamiento =	new DelayQueue<Galleta>();
		ArrayBlockingQueue<Galleta> cinta = 	new ArrayBlockingQueue<Galleta>(CAPACIDAD);
		SynchronousQueue<Galleta> zonaMuestra = new SynchronousQueue<Galleta>();
		
		
		Horno[] productores = new Horno[CANT_HORNOS];
		BrazoMecanico[] consumidores = new BrazoMecanico[CANT_BRAZOSMECANICOS];
		Inspector[] inspectores = new Inspector[CANT_INSPECTORES];
		Empleado[] empleados = new Empleado[CANT_EMPLEADOS];
		Cliente[] clientes = new Cliente[CANT_CLIENTES];
		
	}
	
	public static void iniciar(Horno[] hornos , BrazoMecanico[] brazos ,  Inspector[] inspectores , Empleado[] empleados , Cliente[] clientes,
							   LinkedBlockingQueue<Galleta> buffer , DelayQueue<Galleta> zonaEnfriamiento , ArrayBlockingQueue<Galleta> cinta,
							   SynchronousQueue<Galleta> zonaMuestra)
	{
		int id = 1;
	
	}
	
}
