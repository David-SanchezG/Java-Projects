
package memory;

import java.util.Vector;
import javax.swing.JOptionPane;


public class Jugador {
    
    
    private int jugador;
    private int puntos;

    
    
    public Jugador(int jugador)
    {
        this.jugador = jugador;
        this.puntos = 0;
    }
    
    public void sumarpunto()
    {
        this.puntos++;
    }
    
    
    public int verpuntos()
    {
        return this.puntos;
    }
      
}
