package ejercicio5;

import java.util.concurrent.Exchanger;

public class Salon {
	public static void main(String[] args) {
		final int CANT_VISITANTES = 50;
		
		Exchanger<Regalo> intercambio = new Exchanger<Regalo>();
		Visitante[] visitantes = new Visitante[CANT_VISITANTES];
		
		iniciarVisitantes(visitantes , intercambio);
		
	}
	
	public static void iniciarVisitantes(Visitante[] visitantes , Exchanger<Regalo> intercambio) {
		//Se carga el arreglo de visitantes
		for(int i = 0; i < visitantes.length; i++) {
			visitantes[i] = new Visitante(intercambio);
		}
		
		//Inicializo los hilos de los visitantes
		for(Visitante visitante : visitantes) {
			new Thread(visitante).start();
		}
		
	}
	
}
