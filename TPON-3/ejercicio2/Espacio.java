package ejercicio2;

public class Espacio {


	private int cantActual, cantLleno;
	private boolean este, oeste;

	public Espacio(int actual, int lleno) {
		this.cantActual = actual;
		this.cantLleno = lleno;
		this.este = true;
		this.oeste = false;
	}

	public synchronized void subir(Auto auto) {
		/*
		 * Metodo que realiza la accion de un auto al momento de intentar subir al
		 * transbordador
		 */

		try {
			while (cantActual >= cantLleno || !este) {
				/* Pregunta si esta lleno o ya partio */
				System.out.println("\n Transbordador lleno o no se encuentra en la zona de embarque");
				this.wait();
			}
			this.cantActual++;
			System.out.println("Auto " + auto.getId() + " ha subido al transb. Cantidad de autos: " + this.cantActual);
			/* Notifica que hubo un cambio */
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void bajar(Auto auto) {
		/*
		 * Metodo que realiza la accion de un auto al momento de bajar al transbordador
		 */
		try {
			while (!oeste) {
				/* Pregunta si ya llegaron al oeste */
				System.out
						.println("Auto " + auto.getId() + " no puede bajar, el transbordador no ha llegado a destino");
				this.wait();
			}
			System.out.println("Auto " + auto.getId() + " ha bajado");
			this.cantActual--;
			this.notifyAll(); /*
								 * Utilizamos este notifyAll para asegurarnos de que el transbordador se
								 * despierte y chequee que ya hayan bajado todos los autos
								 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void ir() {

		/*
		 * Metodo que realiza la simulacion del viaje del transbordador de ir desde el
		 * este al oeste
		 */
		try {
			while (cantActual < cantLleno) {
				System.out.println("\n El transbordador esta esperando que suban 10 autos");
				this.wait();
			}
			this.este = false;
			System.out.println("\n Transbordador viajando");
			this.oeste = true;
			System.out.println("\n Tansbordador LLego a la costa oeste");
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void volver() {
		/*
		 * Metodo que realiza la simulacion del viaje del transbordador de volver desde
		 * el oeste al este
		 */
		try {
			while (cantActual > 0) {
				System.out.println("Transbordador esperando que se bajen todos los autos");
				this.wait();
			}
			System.out.println("..........Transbordador volviendo.........");
			this.oeste = false;
			this.este = true;
			System.out.println("\n Tansbordador LLego a la costa este");
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

