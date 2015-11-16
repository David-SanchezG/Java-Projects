
package proyectopoo;


public class Jugador {
     
    private int jugador;
    private int puntos;

    
    
    public Jugador(int jugador)
    {
        this.jugador = jugador;
        this.puntos = 0;
    }
    
    public void sumarpunto(int i)
    {
        this.puntos=this.puntos+i;
    }
    
    
    public int verpuntos()
    {
        return this.puntos;
    }
}
