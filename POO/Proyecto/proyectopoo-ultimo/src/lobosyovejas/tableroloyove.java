
package lobosyovejas;
import proyectopoo.*;
import javax.swing.JOptionPane;

public class tableroloyove extends Tablero{
    public static vistaloyove tablero;
    public static int[] lobo=new int [2];//SE UTILIZA PARA SABER SIEMPRE DONDE ESTA EL Lobo

    public static void main(String[] args)
    {
        fichassel=0;
        Tablero loyove=new tableroloyove();
        turno=1;//empieza el lobo
        ficha2=new Ficha();
        loyove.crearvectorinicial();//matriz de enteros con las ovejas=2 , lobo=1  y vacio=0
        tablero = new vistaloyove();
        //SE PONE CADA FICHA ES SU LUGAR
        tablero.ponerficha(0, 1, 2);//dibuja ovejas
        tablero.ponerficha(0, 3, 2);
        tablero.ponerficha(0, 5, 2);
        tablero.ponerficha(0, 7, 2);
        tablero.ponerficha(1, 0, 2);
        tablero.ponerficha(1, 2, 2);
        tablero.ponerficha(1, 4, 2);
        tablero.ponerficha(1, 6, 2);
        tablero.ponerficha(2, 1, 2);
        tablero.ponerficha(2, 3, 2);
        tablero.ponerficha(2, 5, 2);
        tablero.ponerficha(2, 7, 2);
        tablero.ponerficha(7, 6, 1);//dibuja lobo
        tablero.setVisible(true);
    }

    @Override
    public void crearvectorinicial() {
        //la ficha de la oveja es blanca y la del lobo negra
        int i,j;
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
            {
                vector[i][j]=0;//vacio
            }
        }//asignamos 0 cuando la casilla esta vacia, 1 cuando hay un lobo y 2 cuando hay una oveja
        vector[0][1]=2;
        vector[0][3]=2;
        vector[0][5]=2;
        vector[0][7]=2;
        vector[1][0]=2;
        vector[1][2]=2;
        vector[1][4]=2;
        vector[1][6]=2;
        vector[2][1]=2;
        vector[2][3]=2;
        vector[2][5]=2;
        vector[2][7]=2;
        vector[7][6]=1;
    }

    @Override
    public void accionpulsar(int a, int b) {
        int mov,fin=0;
        //primera ficha y oveja o lobo segun turno o....
        if( ( ( ((turno==1)&&(vector[a][b]==1)) || ((turno==2)&&(vector[a][b]==2))) && (fichassel==0))||
                ((fichassel==1)&&(vector[a][b]==0)))//.....segunda ficha en posicion vacia
        {
            fichassel++;//hace referencia a las casillas seleccionadas
            if(fichassel==2)
            {
                if(turno==1)//SI LE TOCA AL Lobo
                {
                    mov=comprobarmov(1,a,b,ficha2.getpos());
                    System.out.println(mov);
                    switch(mov)
                    {
                        case 0: //SI LA JUGADA ES NO VALIDA
                            JOptionPane.showMessageDialog(null, "POSICION O FICHA EQUIVOCADA");
                            fichassel=1;
                            break;
                        case 1: /////SI LA JUGADA ES BUENA -> redibujaar
                            vector[(ficha2.getpos())[0]][(ficha2.getpos())[1]]=0;//vacia la posicion 1ª
                            tablero.quitarficha((ficha2.getpos())[0],(ficha2.getpos())[1]);//SE QUITA LA FICHA DEL TABLERO
                            vector[a][b]=1;//se pone la ficha en la 2ª posiciondel vector
                            tablero.ponerficha(a, b, 1);//SE DIBUJA LA FICHA ES SU NUEVO LUGAR
                            //Si llega al otro lado gana
                            if(a==0)JOptionPane.showMessageDialog(null, "Gana el lobo, el jugador 1¡¡¡¡¡¡");
                            else
                            {
                                turno=2;//CAMBIO DE TURNO
                                fichassel=0;
                            }
                            break;
                    }
                }
                else//SI LE TOCA A LA oveja
                {
                    mov=comprobarmov(2,a,b,ficha2.getpos());
                    switch(mov)
                    {
                        case 0: //SI LA JUGADA ES NO VALIDA
                            JOptionPane.showMessageDialog(null, "POSICION O FICHA EQUIVOCADA");
                            fichassel=1;
                            break;
                        case 1: //SI LA JUGADA ES BUENA -> redibujaar
                            vector[(ficha2.getpos())[0]][(ficha2.getpos())[1]]=0;//SE QUITA DE LA POSICION ACTUAL
                            tablero.quitarficha((ficha2.getpos())[0],(ficha2.getpos())[1]);//SE QUITA LA FICHA DEL TABLERO
                            vector[a][b]=2;//Y SE PONE EN LA NUEVA POSICION
                            tablero.ponerficha(a, b, 2);//SE DIBUJA LA FICHA ES SU NUEVO LUGAR
                            fin=perder();// se comprueba si el lobo esta acorralado
                            if(fin==1)//si el lobo ha sido acorralado//GANAN LAS ovejas
                            {
                                JOptionPane.showMessageDialog(null, "Ganan las ovejas, el jugador 2¡¡¡¡¡¡");
                            }
                            else
                            {
                                turno=1;//CAMBIO DE TURNO
                                fichassel=0;
                            }                            
                            break;
                    }
                }
            }
            else//SI NO SE HAN SELECCIONADO DOS FICHAS
            {
                if(turno==1)ficha2.setcontenido(1);//SE GUARDA QUE ES UN LOBO
                else ficha2.setcontenido(2);//SE GUARDA QUE ES UNA OVEJA
                ficha2.setpos(a, b);//SE INSERTA LA POSICION DE LA FICHA
            }
        }else JOptionPane.showMessageDialog(null, "POSICION O FICHA EQUIVOCADA");
    }

    @Override
    public int comprobarmov(int animal, int a, int b, int[] pos) {
        if(animal==1)////////////MUEVE EL LOBO
        {
            System.out.println(a+" "+b+" "+(pos[0]-1)+" "+(pos[1]-1));
            if(((a==pos[0]-1)&&(b==pos[1]-1))||//esquina ar izq
                    ((a==pos[0]-2)&&(b==pos[1]-2)&&(vector[pos[0]-1][pos[1]-1]==2))||//esquina ar2 izq
                    ((a==pos[0]-1)&&(b==pos[1]+1))||//esquina ar der
                    ((a==pos[0]-2)&&(b==pos[1]+2)&&(vector[pos[0]-1][pos[1]+1]==2))||//esquina ar2 der
                    ((a==pos[0]+1)&&(b==pos[1]-1))||//esquina ab izq
                    ((a==pos[0]+2)&&(b==pos[1]-2)&&(vector[pos[0]+1][pos[1]-1]==2))||//esquina ab2 izq
                    ((a==pos[0]+1)&&(b==pos[1]+1))||//esquina ab der
                    ((a==pos[0]+2)&&(b==pos[1]+2)&&(vector[pos[0]+1][pos[1]+1]==2)))//esquina ab2 der
            {
                if(((a==pos[0]-2)&&(b==pos[1]-2))||((a==pos[0]-2)&&(b==pos[1]+2))||
                ((a==pos[0]+2)&&(b==pos[1]-2))||((a==pos[0]+2)&&(b==pos[1]+2)))
                {//si son dos saltos comprobar si hay oveja en medio
                    //SE QUITA LA OVEJA DEL VECTOR Y TABLERO
                    if((a==pos[0]-2)&&(b==pos[1]-2))
                    {
                        vector[(ficha2.getpos()[0])-1][(ficha2.getpos()[1])-1]=0;
                        tablero.quitarficha(ficha2.getpos()[0]-1,ficha2.getpos()[1]-1);
                    }//SE QUITA LA OVEJA DEL VECTOR Y TABLERO
                    if((a==pos[0]-2)&&(b==pos[1]+2))
                    {
                        vector[(ficha2.getpos()[0])-1][(ficha2.getpos()[1])+1]=0;
                        tablero.quitarficha(ficha2.getpos()[0]-1,ficha2.getpos()[1]+1);
                    }//SE QUITA LA OVEJA DEL VECTOR Y TABLERO
                    if((a==pos[0]+2)&&(b==pos[1]-2))
                    {
                        vector[(ficha2.getpos()[0])+1][(ficha2.getpos()[1])-1]=0;
                        tablero.quitarficha(ficha2.getpos()[0]+1,ficha2.getpos()[1]-1);
                    }//SE QUITA LA OVEJA DEL VECTOR Y TABLERO
                    if((a==pos[0]+2)&&(b==pos[1]+2))
                    {
                        vector[(ficha2.getpos()[0])+1][(ficha2.getpos()[1])+1]=0;
                        tablero.quitarficha(ficha2.getpos()[0]+1,ficha2.getpos()[1]+1);
                    }
                    
                    
                }
                //comprobar si la posicion esta ya ocupada
                if(vector[a][b]!=0)
                {
                    return 0;
                }
                //si todo esta bien se puede mover la ficha
                lobo[0]=a;
                lobo[1]=b;
                return 1;//JUGADA VALIDA
            }
            else
            {
                System.out.println("mal movimiento");
                return 0;///mal movimiento
            }
        }
        else//////////////MUEVE LA OVEJA////////////////
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
        int fin=0;//0 SI NO ESTA ACORRALADO Y 1 SI LO ESTA Y PIERDE
        
        //SI ESTA EN LA FILA 1
        if(lobo[0]==1)
        {
            if(lobo[1]==0)// si es la columna 0
            {
                if((vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2)&&(vector[lobo[0]+2][lobo[1]+2]==2))
                {
                    return 1;
                }
            }
            if(lobo[1]==6)// si es la columna 6
            {
                if((lobo[1]==6)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)
                    &&(vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+2][lobo[1]-2]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2))
                {
                    return 1;
                }
            }
            else// si esta en las otras dos columnas
            {
                if((vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&
                        (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+2][lobo[1]-2]==2)&&
                        (vector[lobo[0]+1][lobo[1]+1]==2)&&(vector[lobo[0]+2][lobo[1]+2]==2))
                {
                    return 1;
                }
            }
        }
        
        
        //SI ESTA EN LA FILA 2 O 4
        if((lobo[0]==2)||(lobo[0]==4))
        {
            if((lobo[1]==1)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-1][lobo[1]+2]==2)&&
                    (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2)&&(vector[lobo[0]+2][lobo[1]+2]==2))
            {
                return 1;
            }
            if((lobo[1]==7)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&
                (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+2][lobo[1]-2]==2))
            {
                return 1;
            }
        }
        
        //SI ESTA EN LA FILA 3 O 5
        if((lobo[0]==3)||(lobo[0]==5))
        {
            if((lobo[1]==0)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2)&&
                    (vector[lobo[0]+1][lobo[1]+1]==2)&&(vector[lobo[0]+2][lobo[1]+2]==2))
            {
                return 1;
            }
            if((lobo[1]==6)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&
                    (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+2][lobo[1]-2]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2))
            {
                return 1;
            }
        }
        
        //SI ESTA EN LA FILA 6
        if(lobo[0]==6)
        {
            if((lobo[1]==1)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2)&&
                    (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2))
            {
                return 1;
            }
            if((lobo[1]==7)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&
                    (vector[lobo[0]+1][lobo[1]-1]==2))
            {
                return 1;
            }
            else
            {
                if((vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2)&&
                (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2))
                {
                    return 1;
                }
            }
        }
        
        
        
        //SI ESTA EN LA FILA 7       
        if(lobo[0]==7)
        {
            if((lobo[1]==0)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2)
                    )
            {
                return 1;
            }
            if((lobo[1]==6)&&(vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&
                    (vector[lobo[0]-1][lobo[1]+1]==2))
            {
                return 1;
            }
            else
            {
                if((vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2)&&
                (vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2))
                {
                    return 1;
                }
            }
        }
        
        //SI EL LOBO ESTA EN EL CENTRO DEL TABLERO
        if(((lobo[0]==2)||(lobo[0]==3)||(lobo[0]==4)||(lobo[0]==5))&&
                ((lobo[1]==2)||(lobo[1]==3)||(lobo[1]==4)||(lobo[1]==5)))
        {
            if((vector[lobo[0]-1][lobo[1]-1]==2)&&(vector[lobo[0]-2][lobo[1]-2]==2)&&(vector[lobo[0]-1][lobo[1]+1]==2)&&(vector[lobo[0]-2][lobo[1]+2]==2)&&
                    (vector[lobo[0]+1][lobo[1]-1]==2)&&(vector[lobo[0]+2][lobo[1]-2]==2)&&(vector[lobo[0]+1][lobo[1]+1]==2)&&(vector[lobo[0]+2][lobo[1]+2]==2))
            {
                return 1;
            }
        }
        
        
        return 0;
    }
 
    
    
    
    
}
