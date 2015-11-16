package leopardoyvacas;
import javax.swing.JOptionPane;
import proyectopoo.*;

public class tableroleyva extends Tablero{
    public static vistaleyva vtablero;
    public static int[] leopardo=new int [2];//SE UTILIZA PARA SABER SIEMPRE DONDE ESTA EL LEOPARDO
    
    public static void main(String[] args) 
    {
        fichassel=0;
        Tablero leyva=new tableroleyva();
        turno=1;//empieza el leopardo
        ficha2=new Ficha();

        leyva.crearvectorinicial();//matriz de enteros con las vacas=2 y leopardo=1 colocados y vacio=0       
        vtablero = new vistaleyva();
        //SE PONE CADA FICHA ES SU LUGAR
        vtablero.ponerficha(0, 1, 2);//dibuja vacas
        vtablero.ponerficha(0, 3, 2);
        vtablero.ponerficha(0, 5, 2);
        vtablero.ponerficha(0, 7, 2);
        vtablero.ponerficha(5, 4, 1);//dibuja leopardo        
        vtablero.setVisible(true);        
    }  

  
 
    @Override
    public void crearvectorinicial() 
    {//la ficha de la vaca es blanca y la del leopardo negra
        int i,j;
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
            {
                vector[i][j]=0;//vacio
            }
        }//asignamos 0 cuando la casilla esta vacia, 1 cuando hay un leopardo y 2 cuando hay una vaca
        vector[0][1]=2;        
        vector[0][3]=2;
        vector[0][5]=2;
        vector[0][7]=2;
        vector[5][4]=1;
    }
    
    
    
    
    
   
    @Override
    public void accionpulsar(int a,int b)
    {
        int mov,fin=0;
        //primera ficha y vaca o leopardo segun turno o....
        if( ( ( ((turno==1)&&(vector[a][b]==1)) || ((turno==2)&&(vector[a][b]==2))) && (fichassel==0))||
                ((fichassel==1)&&(vector[a][b]==0)))//.....segunda ficha en posicion vacia
        {
            fichassel++;//hace referencia a las casillas seleccionadas        
            if(fichassel==2)
            {
                if(turno==1)//SI LE TOCA AL LEOPARDO
                {
                    mov=comprobarmov(1,a,b,ficha2.getpos());
                    switch(mov)
                    {
                        case 0: //SI LA JUGADA ES NO VALIDA
                            fichassel=1;
                            break;
                        case 1: /////SI LA JUGADA ES BUENA -> redibujaar
                            vector[ficha2.getpos()[0]][ficha2.getpos()[1]]=0;//vacia la posicion 1ª
                            vtablero.quitarficha(ficha2.getpos()[0],ficha2.getpos()[1]);//SE QUITA LA FICHA DEL TABLERO
                            vector[a][b]=1;//se pone la ficha en la 2ª posiciondel vector
                            vtablero.ponerficha(a, b, 1);//SE DIBUJA LA FICHA ES SU NUEVO LUGAR
                            //Si llega al otro lado gana
                            if(a==0)JOptionPane.showMessageDialog(null, "Gana el leopardo, el jugador 1¡¡¡¡¡¡");
                            else 
                            {
                                turno=2;//CAMBIO DE TURNO
                                fichassel=0;
                            }
                            break;
                    }
                }
                else//SI LE TOCA A LA VACA
                {
                    mov=comprobarmov(2,a,b,ficha2.getpos());
                    switch(mov)
                    {
                        case 0: //SI LA JUGADA ES NO VALIDA
                            fichassel=1;
                            break;
                        case 1: //SI LA JUGADA ES BUENA -> redibujaar
                            vector[ficha2.getpos()[0]][ficha2.getpos()[1]]=0;//SE QUITA DE LA POSICION ACTUAL
                            vtablero.quitarficha(ficha2.getpos()[0],ficha2.getpos()[1]);//SE QUITA LA FICHA DEL TABLERO
                            vector[a][b]=2;//Y SE PONE EN LA NUEVA POSICION
                            vtablero.ponerficha(a, b, 2);//SE DIBUJA LA FICHA ES SU NUEVO LUGAR
                            fin=perder();// se comprueba si el leopardo esta acorralado
                            if(fin==1)//si el leopardo ha sido acorralado//GANAN LAS VACAS
                                JOptionPane.showMessageDialog(null, "Ganan las vacas, el jugador 2¡¡¡¡¡¡");
                            turno=1;//CAMBIO DE TURNO
                            fichassel=0;
                            break;
                    }
                }
            }
            else//SI NO SE HAN SELECCIONADO DOS FICHAS
            {
                if(turno==1)ficha2.setcontenido(1);//SE GUARDA QUE ES UN LEOPARDO
                else ficha2.setcontenido(2);//SE GUARDA QUE ES UNA VACA
                ficha2.setpos(a, b);//SE INSERTA LA POSICION DE LA FICHA
            }
        }else JOptionPane.showMessageDialog(null, "POSICION O FICHA EQUIVOCADA");
    }

   
    @Override
    public int comprobarmov(int animal, int a, int b,int[] pos) 
    {
        if(animal==1)////////////mueve leopardo
        {
            if(((a==pos[0]-1)&&(b==pos[1]-1))||//esquina ar izq
                    ((a==pos[0]-2)&&(b==pos[1]-2))||//esquina ar2 izq
                    ((a==pos[0]-1)&&(b==pos[1]+1))||//esquina ar der
                    ((a==pos[0]-2)&&(b==pos[1]+2))||//esquina ar2 der
                    ((a==pos[0]+1)&&(b==pos[1]-1))||//esquina ab izq
                    ((a==pos[0]+2)&&(b==pos[1]-2))||//esquina ab2 izq
                    ((a==pos[0]+1)&&(b==pos[1]+1))||//esquina ab der
                    ((a==pos[0]+2)&&(b==pos[1]+2)))//esquina ab2 der
            {
                if(((a==pos[0]-2)&&(b==pos[1]-2)&&(vector[pos[0]-1][pos[1]-1]==2))||
                ((a==pos[0]-2)&&(b==pos[1]+2)&&(vector[pos[0]-1][pos[1]+1]==2))||
                ((a==pos[0]+2)&&(b==pos[1]-2)&&(vector[pos[0]+1][pos[1]-1]==2))||
                ((a==pos[0]+2)&&(b==pos[1]+2)&&(vector[pos[0]+1][pos[1]+1]==2)))
                {//si son dos saltos comprobar si hay vaca en medio
                    return 0;//JUGADA NO VALIDA
                }
                //comprobar si la posicion esta ya ocupada
                if(vector[a][b]!=0)
                {
                    return 0;//JUGADA NO VALIDA
                }
                //si todo esta bien se puede mover la ficha 
                leopardo[0]=a;
                leopardo[1]=b;
                return 1;//JUGADA VALIDA
            }
            else
            {
                return 0;///mal movimiento
            }
        }
        else//////////////MUEVE LA VACA////////////////
        {
            if(((a==pos[0]+1)&&(b==pos[1]-1))||//esquina ab izq
            ((a==pos[0]+1)&&(b==pos[1]+1)))//esquina ab der
            {
                if(vector[a][b]==0)//si esta vacia la 2ª posicion
                {                    
                    return 1;//jugada valida
                }
                else// si no esta vacia la posicion
                {
                    return 0;//no es jugada valida
                }
            }
            else//si no es jugada valida
            {
                return 0;
            }
        }
    }

    @Override
    public int perder() 
    {
        int fin=0;//0 si no esta acorralado y 1 si leopardo pierde
        if(leopardo[0]==7)// si es la fila siete
        {
            if((leopardo[1]==0)&&(vector[6][1]==2))//si esta en la esquina abajo izquierda comprobar 1 vaca
            {
                fin=1;
            }
            else // si esta en la fila 7,comprobar 2 vacas
            {
                if((vector[leopardo[0]-1][leopardo[1]-1]==2)&&(vector[leopardo[0]-1][leopardo[1]+1]==2))
                    fin=1;
            }
        }
        else{
            if(leopardo[1]==0||leopardo[1]==7)//si esta en la columna 0 o 7
            {
                if(leopardo[1]==0)// si esta en la columna 0,comprobar 2 vacas
                {
                    if((vector[leopardo[0]-1][leopardo[1]+1]==2)&&(vector[leopardo[0]+1][leopardo[1]+1]==2))
                        fin=1;
                }
                else// si esta en la columna 7,comprobar 2 vacas 
                    if((vector[leopardo[0]-1][leopardo[1]-1]==2)&&(vector[leopardo[0]+1][leopardo[1]-1]==2))
                        fin=1;
            }
            else//si esta en una posicion en mitad del tablero
            {
                if((vector[leopardo[0]-1][leopardo[1]+1]==2)&&(vector[leopardo[0]+1][leopardo[1]+1]==2)&&
                        (vector[leopardo[0]-1][leopardo[1]-1]==2)&&(vector[leopardo[0]+1][leopardo[1]-1]==2))
                        fin=1;
            }
        }
        return fin;
    }
    
    
    
}