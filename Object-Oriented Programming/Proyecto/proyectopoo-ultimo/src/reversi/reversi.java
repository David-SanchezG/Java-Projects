package reversi;
import javax.swing.JOptionPane;
import proyectopoo.*;


public class reversi extends Tablero{

    public static vistareversi vtablero;
    public static Jugador jugador1,jugador2;
    
    
    
    public static void main(String[] args) 
    {
        fichassel=64;//NUMERO DE FICHAS RESTANTES
        reversi treversi=new reversi();
        turno=1;//empieza el leopardo

        treversi.crearvectorinicial();//matriz de enteros con las blanca=2 y negra=1 colocados y vacio=0
        jugador1 = new Jugador(1);//la negra
        jugador2 = new Jugador(2);//la blanca       
        vtablero = new vistareversi();
        //SE PONE CADA FICHA ES SU LUGAR
        vtablero.ponerficha(3, 3, 2);//dibuja blanca
        vtablero.ponerficha(4, 4, 2);
        vtablero.ponerficha(3, 4, 1);//dibuja negra   
        vtablero.ponerficha(4, 3, 1);
        vtablero.setVisible(true);        
    }

    
  
 
    @Override
    public void crearvectorinicial() 
    {//la ficha de la vaca es blanca y la del negra negra
        int i,j;
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
            {
                vector[i][j]=0;//vacio
            }
        }//asignamos 0 cuando la casilla esta vacia, 1 cuando hay una negra y 2 cuando hay una blanca
        vector[3][3]=2;        
        vector[4][4]=2;
        vector[3][4]=1;
        vector[4][3]=1;
    }
    
    
    
    
    
   
    @Override
    public void accionpulsar(int a,int b)
    {
        int mov=0,fin=0;
        int[] cosas=new int[3];
        
        mov=comprobarmov(turno, a, b, cosas);
        switch(mov)
        {//0 SI NO VALIDA,1 VALIDA
            case 0:JOptionPane.showMessageDialog(null, "Jugada no valida");
                break;
            case 1:                   
                fichassel--;
                if(fichassel==0)//SI NO QUEDAN FICHAS SE COMPRUEBA QUIEN HA GANADO
                {                    
                    fin=perder();//SE COMPRUEBA QUIEN HA GANADO
                    switch(fin)//0 SI NO FIN,1 SI GANA NEGRA,2 SI GANA BLANCA
                    {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Gana el jugador 1(NEGRAS) por: "+jugador1.verpuntos()+"al jugador 2 con "+jugador2.verpuntos()+"¡¡¡¡¡¡");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Gana el jugador 2(BLANCAS) por "+jugador2.verpuntos()+"al jugador 1 con "+jugador1.verpuntos()+"¡¡¡¡¡¡");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "EMPATE¡¡¡¡¡¡");
                            break;
                    }
                }
                else
                {//SI QUEDAN FICHAS SE CAMBIA DE TURNO Y SE COMPRUEBA SI QUEDAN MOVIMIENTOS
                    if(turno==1)turno=2;
                    else turno=1;
                    if(jugada()==0)//SI NO LE QUEDAN JUGADAS AL SIGUIENTE JUGADOR
                    {
                        JOptionPane.showMessageDialog(null, "El jugador "+turno+"no tiene movimientos");
                        if(turno==1)turno=2;//CAMBIAMOS DE TURNO PARA VER SI AL OTRO JUGADOR LE QUEDA ALGUNA JUGADA
                        else turno=1;
                        
                        if(jugada()==0)//SI NO LE QUEDAN JUGADAS AL OTRO
                        {
                            JOptionPane.showMessageDialog(null, "El jugador "+turno+" no tiene movimientos");
                            fin=perder();
                            switch(fin)
                            {
                                case 1:
                                    JOptionPane.showMessageDialog(null, "Gana el jugador 1(NEGRAS)¡¡¡¡¡¡");
                                    break;
                                case 2:JOptionPane.showMessageDialog(null, "Gana el jugador 2(BLANCAS)¡¡¡¡¡¡");
                                    break;
                                case 3:JOptionPane.showMessageDialog(null, "EMPATE¡¡¡¡¡¡");
                                    break;
                            }                            
                        }                        
                    }
                }
                break;      
        }  
    }


    
   
    @Override
    public int comprobarmov(int turno, int a, int b,int[] pos) 
    {
        int i=0;
        if(vector[a][b]==0)
        {
            if(a!=0)
            {
                if((recorrerarriba(a, b, pos))==1)//SE COMPRUEBA SI HAY JUGADA
                {
                    mover(pos[0], a, b, pos[1], pos[2]);//SI HAY JUGADA SE VOLTEAN LAS FICHAS
                    i=1;
                }
            }
            if(a!=7)
            {
                if((recorrerabajo(a, b, pos))==1)
                {
                    mover(pos[0], a, b, pos[1], pos[2]);
                    i=1;
                }
            }
            if(b!=7)
            {
                if((recorrederecha(a, b, pos))==1)
                {
                    mover(pos[0], a, b, pos[1], pos[2]);
                    i=1;
                }
            }
            if(b!=0)
            {
                if((recorrerizquierda(a, b, pos))==1)
                {
                    mover(pos[0], a, b, pos[1], pos[2]);
                    i=1;
                }
            }  
            //SI EN ALGUNO DE LOS RECORRIDOS MUEVES FICHAS     
            if(i==1)return 1;
        }
        return 0;//SI NO HAY JUGADA POSIBLE EN ESA POSICION
    }
    
    public int recorrerizquierda(int a,int b,int[] pos)
    {
        int i,j,k,turnocontr=0;
        if(turno==1)turnocontr=2;
            else turnocontr=1;
        if(vector[a][b-1]==turnocontr)//RECORRER HORIZONTAL IZQUIERDA
        {
            i=a;j=b-1;
            while((j!=-1)&&(vector[i][j]==turnocontr))
            {
                j--;
            }
            if((j!=-1)&&(vector[i][j]==turno))
            {
                k=j+1;//MARCHA ATRAS VOLTEANDO
                pos[0]=k;
                pos[1]=1;
                pos[2]=0;
                return 1;
            }
        }
        return 0;
    }
    
    
    public int recorrerarriba(int a,int b,int[] pos)
    {
        int i,j,k,turnocontr=0;
        if(turno==1)turnocontr=2;
            else turnocontr=1;
        if(vector[a-1][b]==turnocontr)//RECORRER VERTICAL ARRIBA
        {
            i=a-1;j=b;
            while((i!=-1)&&(vector[i][j]==turnocontr))
            {
                i--;
            }
            if((i!=-1)&&(vector[i][j]==turno))
            {
                k=i+1;//MARCHA ATRAS VOLTEANDO
                pos[0]=k;
                pos[1]=0;
                pos[2]=0;                      
                return 1;
            }
        }
        return 0;
    }
    
    
    public int recorrerabajo(int a,int b,int[] pos)
    {
        int i,j,k,turnocontr=0;
        if(turno==1)turnocontr=2;
            else turnocontr=1;
        if(vector[a+1][b]==turnocontr)//RECORRER VERTICAL ABAJO
        {
            i=a+1;j=b;
            while((i!=8)&&(vector[i][j]==turnocontr))
            {
                i++;
            }
            if((i!=8)&&(vector[i][j]==turno))
            {
                k=i-1;//MARCHA ATRAS VOLTEANDO
                pos[0]=k;
                pos[1]=0;
                pos[2]=1;
                return 1;
            }
        }
        return 0;
    }
    
    
    public int recorrederecha(int a,int b,int[] pos)
    {
        int i,j,k,turnocontr=0; 
        if(turno==1)turnocontr=2;
            else turnocontr=1;
        if(vector[a][b+1]==turnocontr)//RECORRER HORIZONTAL DERECHA
        {
            i=a;j=b+1;
            while((j!=8)&&(vector[i][j]==turnocontr))
            {
                j++;
            }
            if((j!=8)&&(vector[i][j]==turno))
            {
                k=j-1;//MARCHA ATRAS VOLTEANDO
                pos[0]=k;
                pos[1]=1;
                pos[2]=1;
                return 1;
            }
        }
        return 0;
    }
    
    
    
    
    public void mover(int k,int a,int b,int dir,int sent)
    {
        
        vector[a][b]=turno;
        vtablero.quitarficha(a, b);
        vtablero.ponerficha(a, b, turno);
        switch(dir)
        {
            case 0://DIRECCION VERTICAL
                if(sent==0)//SENTIDO ARRIBA
                {
                    while(k!=a)//K ES LA POSICION DE PARTIDA PARA IR RETROCEDIENDO Y VOLTEANDO
                    {
                        vector[k][b]=turno;//SE VOLTEAN LAS FICHAS EN EL TABLERO
                        vtablero.quitarficha(k, b);//SE VOLTEAN LAS FICHAS EN LA VISTA
                        vtablero.ponerficha(k, b, turno);
                        k++;
                    }                 
                }
                else//abajo
                {
                    while(k!=a)
                    {
                        vector[k][b]=turno;
                        vtablero.quitarficha(k, b);
                        vtablero.ponerficha(k, b, turno);
                        k--;
                    }                 
                }
                break;
            case 1://DIRECCION HORIZONTAL
                if(sent==0)//izquierda
                {
                    while(k!=b)
                    {
                        vector[a][k]=turno;
                        vtablero.quitarficha(a, k);
                        vtablero.ponerficha(a, k, turno);
                        k++;
                    }
                }
                else//derecha
                {
                    while(k!=b)
                    {
                        vector[a][k]=turno;
                        vtablero.quitarficha(a, k);
                        vtablero.ponerficha(a, k, turno);
                        k--;
                    }
                }
                break;
        }
    }

    @Override
    public int perder() 
    {
        int fin=1,i=0,j=0;

        for(i=0;i<8;i++)//SE RECORRE EL VECTOR SUMANDO PUNTOS AL JUGADOR CORRESPONDIENTE
        {
            for(j=0;j<8;j++) 
            {
                if(vector[i][j]==1)jugador1.sumarpunto(1);
                if(vector[i][j]==2)jugador2.sumarpunto(1);
            }
        }        
       if(jugador1.verpuntos()>jugador2.verpuntos())fin=1;//gana jugador 1
            else if(jugador1.verpuntos()<jugador2.verpuntos())fin=2;// gana jugador 2
            else fin=3;//empate
        return fin;
    }
    
    public int jugada()
    {
        int i,j,k=0;
        int[] cosas=new int[3];
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++) 
            {
                if(vector[i][j]==0)//LLEGA A UNA POSICION VACIA
                {
                    //SE COMPRUEBA SI TIENE JUGADAS POSIBLES,k=1 SI TIENE JUGADAS
                    if(i!=0)                    
                        if((recorrerarriba(i, j, cosas))==1) k=1;           
                    if(i!=7)                    
                        if((recorrerabajo(i, j, cosas))==1)k=1;                    
                    if(j!=7)                    
                        if((recorrederecha(i, j, cosas))==1)k=1;                    
                    if(j!=0)                    
                        if((recorrerizquierda(i, j, cosas))==1)k=1;                    
                }                
            }
        }
        return k;
    }
    
    
}
