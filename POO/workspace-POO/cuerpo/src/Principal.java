
public class Principal {

	
	
	
	private static int puntos;

	public static void main(String[] args) {
		int i, x , y,numvertices;
		cuerpo figura=new cuerpo();
		Punto punto;
		
		do{
			System.out.println("Escriba el numero de puntos del cuerpo geometrico:");
			puntos=Teclado.leerInt();
			if(puntos<3)
			{
				System.out.println("Ponga un numero de puntos mayor que 2.");
			}
		}while(puntos<=2);
			

		i=0;
		do{		
			
			System.out.println("Punto: "+(i+1));
			System.out.println("Escriba la coordenada x");
			x=Teclado.leerInt();
			
			System.out.println("Escriba la coordenada y");
			y=Teclado.leerInt();
			
			punto=new Punto(x,y);
			
			figura.cuerpo(punto);
			
			i++;
		}while(i < puntos);
		
		
		
		figura.Visualizar(puntos);
		
		figura.insertarvalorx(puntos);
		puntos++;
		figura.insertarvalory(puntos);
		puntos++;
		
		numvertices=figura.numerovertices();
		System.out.println("el numero de vertices de la figura es:"+numvertices);
		
		
		figura.desplazarfigura(puntos);
		
		figura.rotar(puntos);
		

	}
	
	
}
