package ejercicio5;

import java.util.Random;

public class Regalo {

	private String[] tipos = {"Fideos" , "Atun enlatado" , "Arroz" , "Sopa enlatada" , "Carne en lata",
							"Azucar" , "Cafe" , "Harina" , "Leche en polvo"};
	private String tipo;
	
	public Regalo() {
		Random r = new Random();
		this.tipo = tipos[r.nextInt(tipos.length-1)];
	}
	
	
	
	
}
