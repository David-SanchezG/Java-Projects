
package memory;

import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Memory {

    
    
    private static vistatablero tablero;
    private static int nfichas=0;
    public static Vector<String> vector;
    private static int[] numeros1;
    private static Jugador jugador1;
    private static Jugador jugador2;
    private static int fichassel;
    private static Ficha ficha2;
    private static int fichasrest;
    private static int turno;
    
    
    public static void main(String[] args) {
        fichassel=0;    
        turno=1;
        crearvector();
        jugador1 = new Jugador(1);
        jugador2 = new Jugador(2);
        ficha2=null;        
        tablero = new vistatablero();
        tablero.setVisible(true);
    }
    
    public static void meterfichas(int fichas)
    {
        nfichas=fichas;
    }
    
    public static void cosas()
    {
        numeros1 = aleatorio();
        fichasrest=nfichas;
        jugador1 = new Jugador(1);
        jugador2 = new Jugador(2);
    }
    
    
    
    public static int comprobarjugada(Ficha ficha1)
    { 
        boolean iguales=false;
        fichassel++;
        if(fichassel==2)//Si son dos fichas se comprueba si son iguales
        {
            iguales=ficha1.iguales(ficha2);
            if(iguales==true)//Si lo son se le suma un punto al jugador
            {
                if(turno==1)
                {
                    jugador1.sumarpunto();
                    tablero.sumarpunto(turno,jugador1.verpuntos());  
                }
                else
                {
                    jugador2.sumarpunto();
                    tablero.sumarpunto(turno,jugador2.verpuntos());
                }
                fichasrest=fichasrest-2;
                fichassel=0;
                if(fichasrest==0)
                {
                    if(jugador1.verpuntos()>jugador2.verpuntos())
                    {
                        JOptionPane.showMessageDialog(null, "Gana el jugador 1 !!!!");
                    }
                    else
                    {
                        if(jugador1.verpuntos()<jugador2.verpuntos())
                        {
                            JOptionPane.showMessageDialog(null, "Gana el jugador 2 !!!!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Empate!");
                        }
                    }
                   
                }
                return 1;//se devuelve 1 si las fichas son iguales   
            }
            else//se cambia el turno del jugador
            {
                tablero.error();
                tablero.voltear(ficha1.getpos(), "");
                tablero.voltear(ficha2.getpos(), "");
                
                fichassel=0;
                if(turno==1)
                {
                    turno=2;
                    tablero.cambiarjugador(turno);
                }
                else
                {
                    turno=1;
                    tablero.cambiarjugador(turno);
                }
                return 2;//se devuelve 2 si las dos fichas son distintas
            }
        }
        else//Si es una sola ficha se borran la anterior y se introduce ésta en el vector
        {
            ficha2=ficha1;
            return 0;//se devuelve 0 si es la 1ª ficha
        }
    }
    
    
    
    private static int[] aleatorio()
    {
        int vectornum[] = new int[nfichas];
        int numale = 0,j = 0,i = 0, repe=0;
        boolean lleno=false;
        Random rnd = new Random();
        int num = nfichas/2;
        while (lleno==false)// vector no lleno
        {
            repe=2;
            while(repe==2)//numero no repetido
            {
                numale = rnd.nextInt(num) ;
                if(i==0)
                {
                    repe=0;
                }
                else
                {
                    repe=0;
                    for(int a=0;a<i;a++)
                    {   
                        if(vectornum[a]==numale)
                        {
                            repe++;
                        }
                    }
                    if(repe<2)
                    {
                        repe=0;
                    }
                }
            }
            //se mete en el vector
            vectornum[i]=numale;
            i++;
            if(i==nfichas)
            {
                lleno=true;
            }  
        } 
        return vectornum;
    }
   
    
    public static void crearvector()
    {
        vector = new Vector<String>();
        vector.addElement("perro");
        vector.addElement("gato");
        vector.addElement("pollo");
        vector.addElement("burro");
        vector.addElement("gallina");
        vector.addElement("oveja");
        vector.addElement("vaca");
        vector.addElement("caballo");
        vector.addElement("pato");
        vector.addElement("oca");
    } 
    
    
    
    public static void funcionboton(int pos)
    {
        Ficha ficha = new Ficha(vector.elementAt(numeros1[pos]),pos);
        
        tablero.voltear(pos,vector.elementAt(numeros1[pos]));
        
        comprobarjugada(ficha);
    }

    
}
