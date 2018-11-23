package ejercicio4;

import java.util.Random;

public class NameGenerator {
	//Generador de nombres
	private static String[] nombres = {"Azeem" , "Haney" , "Deanna" , "Mckenzie" , "Kareem" , "Richmond" , "Jemimah" , "Matthews" , "Alexie" , "Ferguson" , "Jon-Paul" , "Moody" , "Millie" , "Dean" , "Alice" , "Kearns" , "David" , "Guy" , "Megan" , "Chamberlain" , "Remi" , "Galloway" , "Millicent" , "Garrett" , "Ahmad" , "Carpenter" , "Shannan" , "Chan" , "Maximillian" , "Tyson" , "Francisco" , "Wilson" , "Russell" , "Gardner" , "Jaya" , "Moreno" , "Roberta" , "Freeman" , "Gloria" , "Rollins"};
	private static Random r = new Random();
	
	public static String generarNombre() {
		return nombres[r.nextInt(nombres.length - 1)];
	}
}
