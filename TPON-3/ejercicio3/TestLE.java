package ejercicio3;
import java.util.Scanner;

public class TestLE {

	private static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args){
		
		Libro libro = new Libro();
		
		System.out.print("¿cuantos lectores seran? ");
		int cantLectores = sc.nextInt();
		
		System.out.print("¿cuantos escritores seran? ");
		int cantEscritores = sc.nextInt();
		
		for(int i = 0 ; i < cantLectores ; i++){
			Lector lect = new Lector(i,libro);
			Thread lector = new Thread(lect);
			lector.start();
		}
		
		for(int j = 0 ; j < cantEscritores ; j++){
			Escritor escri = new Escritor(j,libro);
			Thread escritor = new Thread(escri);
			escritor.start();
		}
		
		
	}
}