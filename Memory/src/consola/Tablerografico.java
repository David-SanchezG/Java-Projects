
package consola;





public class Tablerografico {
    

    
    
    
    public void mostrarpunto(int puntos1, int puntos2)
    {
        System.out.println("Puntos del jugador 1:"+puntos1);
        System.out.println("Puntos del jugador 2:"+puntos2);
    }
    
    
    
    public void cambiarjugador(int turno)
    {
        if(turno==2)
        {
            System.out.println("TURNO DEL JUGADOR 2");
        }
        else
        {
            System.out.println("TURNO DEL JUGADOR 1");
        }
    }
    
    
    
    public void error()
    {
        System.out.println("Has fallado");
    }
    
    public int dibujar(String[] tableroG,int nfichas)
    {
        int k=0;
         for(int i=0;i<5;i++)
         {      
             for(int j=0;j<4;j++)
             {
                 System.out.print(tableroG[k]);
                 k++;
                 if(k==nfichas)
                 {
                     System.out.println("");
                     return 0;
                 }
             }
             System.out.println("");
         }
        System.out.println("");
        return 0;
    }
    public int pedirfichas()
    {
        int nfichas;
        do{
        System.out.println("Inserte el numero de fichas con el que quiere jugar");
        nfichas = Teclado.leerInt();
        }while(nfichas!=4 && nfichas!=6 && nfichas!=8 && nfichas!=10 && nfichas!=12 && nfichas!=14 && nfichas!=16 && nfichas!=18 &&  nfichas!=20 );
        return nfichas;
    }
       
    
    
    public void victoria(int num)
    {
        if(num==0)
        {
            System.out.println("Gana el jugador 1 !!!!");
        }  
        if(num==1)
        {
            System.out.println("Gana el jugador 2 !!!!");
        }        
        if(num==2)
        {
            System.out.println("Empate!");
        }
    }
    
       
    public int[] elegirficha(int nfichas)
    {
        boolean mal=false;
        int[] vector= new int[2];
        System.out.println("");
        do{ 
            mal=false;
            System.out.println("Inserte la fila de la ficha");
            vector[0] = Teclado.leerInt();
            if(((vector[0]>1)&&(nfichas<=4))||((vector[0]>2)&&(nfichas<=8))||((vector[0]>3)&&(nfichas<=12))||((vector[0]>4)&&(nfichas<=16))){
                mal=true;
            }
        }while((mal==true) || (vector[0]<1));

        do{
            System.out.println("Inserte la columna de la ficha");
            vector[1] = Teclado.leerInt();
        }while((vector[1]<1)||vector[1]>5);
        return vector;
    }
       
    
}
