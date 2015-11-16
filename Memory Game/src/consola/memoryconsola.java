
package consola;
import java.util.Random;
import java.util.Vector;
import memory.Ficha;
import memory.Jugador;


public class memoryconsola {
    
   private static Tablerografico tablero;
    private static int nfichas=0;
    public static Vector<String> vector;
    public static String[] tableroG;
    private static int[] numeros1;
    private static Jugador jugador1;
    private static Jugador jugador2;
    private static int fichassel;
    private static Ficha ficha2;
    private static int fichasrest;
    private static int turno;
    
    
    public static void main(String[] args) {
        int[] coordenadas;
        int pos;
        fichassel=0;    
        turno=1;
        crearvector();
        jugador1 = new Jugador(1);
        jugador2 = new Jugador(2);
        ficha2=null;
        Ficha ficha1=null;
        tablero = new Tablerografico();
        nfichas = tablero.pedirfichas();
        fichasrest = nfichas;
        tableroG = new String[nfichas];
        numeros1=aleatorio();
        for(int i=0;i<nfichas;i++)
        {
            tableroG[i] = "  -  ";
        }
        tablero.dibujar(tableroG,nfichas);
        do{
            coordenadas = tablero.elegirficha(nfichas);
            pos = convertir(coordenadas);
            if(tableroG[pos].compareTo("  -  ")==0){
            ficha1 = new Ficha(vector.elementAt(numeros1[pos]),pos);
            tableroG[pos] = vector.elementAt(numeros1[pos]);
            tablero.dibujar(tableroG,nfichas);
            comprobarjugada(ficha1);
            }
        }while(fichasrest!=0); 
    }
    
 
    public static int convertir(int[] coordenadas)
    {
        int pos=0;
        switch(coordenadas[0])
        {
            case 1:
                pos=coordenadas[1]-1;
                break;
            case 2:
                pos=coordenadas[1]+3;
                break;
            case 3:
                 pos=coordenadas[1]+7;
                break;
            case 4:
                 pos=coordenadas[1]+11;
                 break;
            case 5:
                 pos=coordenadas[1]+15;
                 break;
        }
        return pos;
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
                }
                else
                {
                    jugador2.sumarpunto();
                }                   
                tablero.mostrarpunto(jugador1.verpuntos(),jugador2.verpuntos());
                fichasrest=fichasrest-2;
                fichassel=0;
                if(fichasrest==0)
                {
                    if(jugador1.verpuntos()>jugador2.verpuntos())
                    {
                        tablero.victoria(0);
                    }
                    else
                    {
                        if(jugador1.verpuntos()<jugador2.verpuntos())
                        {
                            tablero.victoria(1);
                        }
                        else
                        {
                            tablero.victoria(2);
                        }
                    }
                
                }
                return 1;//se devuelve 1 si las fichas son iguales   
            }
            else//se cambia el turno del jugador
            {
                tablero.error();
                tableroG[ficha1.getpos()] ="  -  ";
                tableroG[ficha2.getpos()] ="  -  ";
                tablero.dibujar(tableroG, nfichas);
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
        
        tableroG[pos] = ficha.getcontenido();
        
        comprobarjugada(ficha);
    }
}
