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
		
		
		Horno[] hornos = new Horno[CANT_HORNOS];
		BrazoMecanico[] brazos = new BrazoMecanico[CANT_BRAZOSMECANICOS];
		Inspector[] inspectores = new Inspector[CANT_INSPECTORES];
		Empleado[] empleados = new Empleado[CANT_EMPLEADOS];
		Cliente[] clientes = new Cliente[CANT_CLIENTES];
		
		iniciar(hornos , brazos , inspectores , empleados , clientes , buffer , zonaEnfriamiento , cinta , zonaMuestra);
	}
	
	public static void iniciar(Horno[] hornos , BrazoMecanico[] brazos ,  Inspector[] inspectores , Empleado[] empleados , Cliente[] clientes,
							   LinkedBlockingQueue<Galleta> buffer , DelayQueue<Galleta> zonaEnfriamiento , ArrayBlockingQueue<Galleta> cinta,
							   SynchronousQueue<Galleta> zonaMuestra)
	{	
		int id;
		//-----Carga de los arreglos-----
		for(int i = 0; i < hornos.length; i++) {
			hornos[i] = new Horno(buffer);
		}
		for(int i = 0; i < brazos.length; i++) {
			brazos[i] = new BrazoMecanico(buffer , zonaEnfriamiento);
		}
		for(int i = 0; i < inspectores.length; i++) {
			inspectores[i] = new Inspector(zonaEnfriamiento , cinta);
		}
		for(int i = 0; i < empleados.length; i++) {
			empleados[i] = new Empleado(cinta , zonaMuestra);
		}
		for(int i = 0; i < clientes.length; i++) {
			clientes[i] = new Cliente(zonaMuestra);
		}
		//-------------------------------
		
		//----Inicio de los hilos----
		id = 1;
		for(Horno horno : hornos) {
			new Thread(horno , Integer.toString(id)).start();
			id++;
		}
		id = 1;
		for(BrazoMecanico brazo : brazos) {
			new Thread(brazo , Integer.toString(id)).start();
			id++;
		}
		id = 1;
		for(Inspector inspector : inspectores) {
			new Thread(inspector , Integer.toString(id)).start();
			id++;
		}
		id = 1;
		for(Empleado empleado : empleados) {
			new Thread(empleado , Integer.toString(id)).start();
			id++;
		}
		id = 1;
		for(Cliente cliente : clientes) {
			new Thread(cliente , Integer.toString(id)).start();
			id++;
		}
	}
	
}
