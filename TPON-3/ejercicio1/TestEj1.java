package ejercicio1;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
public class TestEj1 {

	public static void main(String[] args) {
		CountDownLatch cuentaA = new CountDownLatch(10); 
		
	try {
		BufferCompartido buffer=new BufferCompartido(1000);
		HiloVerificador hiloVerificacion=new HiloVerificador(buffer,0,999);
		Thread hiloV=new Thread(hiloVerificacion);
		hiloV.start();
		hiloV.join();
		crearHilosSum(10,buffer, cuentaA);
		
		
		cuentaA.await();
		System.out.println("La suma del arreglo hecha por 1 solo hilo es de "+hiloVerificacion.getContador());
		System.out.println("La suma hecha por varios hilos es "+buffer.obtenerValor());
		
	}catch(InterruptedException e) {
			
		}
	}
	
	public static void crearHilosSum(int cant,BufferCompartido buff, CountDownLatch cuenta ) throws InterruptedException{
		int inicio=0;
		int fin=100;
		HiloSumador[] hilosS=new HiloSumador[cant];
		Thread[] hilo = new Thread[hilosS.length];
		for(int i=0;i<hilosS.length;i++){
			hilosS[i]=new HiloSumador(i,inicio,fin,buff, cuenta);
			inicio+=100;
			fin+=100;			
		}
		for(int j=0; j<hilosS.length;j++){
			hilo[j]=new Thread(hilosS[j]);
			hilo[j].start();
		}
		
	}

		
}

	
	
	
	
	
