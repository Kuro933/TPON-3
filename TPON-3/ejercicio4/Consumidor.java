package ejercicio4;

public class Consumidor implements Runnable
{
    private final Contenedor contenedor;
    private final int idconsumidor;
 
  
    public Consumidor(Contenedor contenedor, int idconsumidor) 
    {
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        while(Boolean.TRUE)
        {
            System.out.println("El consumidor " + idconsumidor + " consume: " + contenedor.get());
        }
    }
}
