
package proyectopoo;

//import leopardoyvacas.vistaleyva;

public abstract class Tablero {
    public static int[][] vector=new int[8][8];//este es nuestro tablero
    public static int turno;
    public static int fichassel;
    public static Ficha ficha2;
    
    ///metodos
    public abstract void crearvectorinicial();
    public abstract void accionpulsar(int a,int b);
    public abstract int comprobarmov(int animal, int a, int b,int[] pos);
    public abstract int perder();
}
