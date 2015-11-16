
package proyectopoo;


public class Ficha 
{
    
    private int contenido;
    private int pos[]=new int[2];

    public Ficha(int contenido, int pos[])
    {
        this.contenido=contenido;
        this.pos = pos;
    }

    public Ficha()
    {
        this.contenido=0;
        this.pos[0]=0;
        this.pos[1]=0;
    }
    
    public int getcontenido()
    {
        return contenido;
    }
    
    public void setcontenido(int a){
        this.contenido=a;        
    } 
    

    public int[] getpos(){
        return this.pos;
    }
    
   
    public void setpos(int a,int b){
        this.pos[0]=a;
        this.pos[1]=b;
    }    
    
    
    
    public boolean iguales(Ficha ficha2)
    {
        boolean igual=false;
        if(this.contenido==ficha2.contenido)
        {
            igual=true;
        }
        return igual;
    }
}
