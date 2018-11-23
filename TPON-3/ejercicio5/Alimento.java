package ejercicio5;

import java.util.Random;

public class Alimento {

	private String[] tipos = {"Fideos" , "Atun enlatado" , "Arroz" , "Sopa enlatada" , "Carne en lata",
							"Azucar" , "Cafe" , "Harina" , "Leche en polvo"};
	private String tipo;
	
	public Alimento() {
		Random r = new Random();
		this.tipo = tipos[r.nextInt(tipos.length-1)];
	}
	
	
	
	
}
