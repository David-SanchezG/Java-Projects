
package memory;


public class Ficha
{

    private String contenido;
    private int pos;

    public Ficha(String contenido, int pos)
    {
        this.contenido=contenido;
        this.pos = pos;
    }

    
    public String getcontenido()
    {
        return contenido;
    }
    
    
    public boolean iguales(Ficha ficha2)
    {
        boolean igual=false;
        if((this.getcontenido().compareTo(ficha2.getcontenido()))==0)
        {
            igual=true;
        }
        return igual;
    }


    public int getpos(){
        return this.pos;
    }

}
