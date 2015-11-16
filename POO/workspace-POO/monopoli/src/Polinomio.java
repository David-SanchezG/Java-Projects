import java.util.*;


public class Polinomio 
{
	
	private Vector<Termino> pol;
	
	public Polinomio()
	{
		//Los polinomios se crean vacios (su vector esta vacio inicialmente) 
		pol = new Vector<Termino>();
	}
	
	
	
	public  void crearPolinomio()
	{
		int coeficiente,grado,i = 0, op;
		
		do{
			i++;
			System.out.println("Introduzca el coeficiente del termino "+i+":");
			coeficiente=Teclado.leerInt();
			System.out.println("Introduzca el grado del termino "+i+":");
			grado=Teclado.leerInt();
			Termino ter=new Termino(coeficiente,grado);
			this.añadirTermino(ter);
			System.out.println("Si quiere añadir otro termino pulse 1, en caso contrario cualquier otro numero: ");
			op=Teclado.leerInt();
		}while(op==1);
		System.out.println("\n");
	}
	
	
	public void añadirTermino(Termino ter)
	{
		int i;
		//Comprobamos si hay terminos del mismo grado para agruparlos
		for (i=0; i < this.pol.size(); i++)
		{
			if(this.pol.elementAt(i).getGrad() == ter.getGrad())
			{
				this.pol.setElementAt(this.pol.elementAt(i).sumarTer(ter),i);
				break;
			}
		}
//Si i ha recorrido todo el polinomio y no ha encontrado un termino de igual grado, lo añade al final del polinomio
		if(i == this.pol.size()) 
		{
			this.pol.addElement(ter);
		}
	}
	
	
	///Sumar polinomio
	public void sumarPol(Polinomio pol1,Polinomio pol2)
	{
		int i,j;
		boolean[] SumadosPol2 = new boolean[pol2.tamaño()];// Este array almacena falso en la misma posicion de los terminos de pol2 que no han sido sumados aún.
		for(i=0;i<pol2.tamaño();i++)
			SumadosPol2[i]= false ; //Al principo no se ha sumado ningún termino del pol2

		for (i=0; i < pol1.tamaño(); i++){
			for (j=0; j < pol2.tamaño(); j++){
				if(pol1.pol.get(i).getGrad() == pol2.pol.get(j).getGrad())
				{
					this.pol.addElement(pol1.pol.get(i).sumarTer(pol2.pol.get(j)));
					SumadosPol2[j]= true; //Ponemos a verdadero los terminos de pol2 que acabamos de sumar
					break;
				}
			}
			
			if(j==pol2.pol.size())this.pol.addElement(pol1.pol.get(i)); //Se añaden al resultado el termino i del pol1 no sumado con ningun termino del pol2
		}
		
		//Añadimos todos los terminos no sumados del polinomios 2 cuyos índices son recogidos por el vector SumadosPol2
		for(i=0;i<pol2.tamaño();i++)
		{
			if (SumadosPol2[i]== false)
			{
				this.pol.addElement(pol2.pol.get(i));
			}
		}
	}
	
	
	
	///Restar polinomios
	public void restarPol(Polinomio pol1,Polinomio pol2)
	{
		int i,j;
		boolean[] RestadosPol2 = new boolean[pol2.tamaño()];// Este array almacena falso en la misma posicion de los terminos de pol2 que no han sido restados aún.
	//Al principo no se ha restado ningún termino del polinomio 2
		for(i=0;i<pol2.tamaño();i++)
		{
			RestadosPol2[i]= false ; 
		}

		for (i=0; i < pol1.tamaño(); i++)
		{
			for (j=0; j < pol2.tamaño(); j++)
			{
				///Restamos los terminos de igual grado
				if(pol1.pol.get(i).getGrad() == pol2.pol.get(j).getGrad())
				{
					this.pol.addElement(pol1.pol.get(i).restarTer(pol2.pol.get(j)));
					RestadosPol2[j]= true; //Ponemos a verdadero los terminos de pol2 que acabamos de restar
					break;
				}
			}
///Si llega hasta el final sin encontrar otro termino de igual grado entonces lo introduce directamente
			if(j==pol2.tamaño())
			{
				this.pol.addElement(pol1.pol.get(i));
			}
		}
		
		//Añadimos todos los terminos no sumados del pol2 cuyos índices son recogidos por el vector SumadosPol2
		for(i=0;i<pol2.tamaño();i++)
		{
			if (RestadosPol2[i]== false)
			{
				this.pol.addElement(pol2.pol.get(i).multiplicarEsc(-1));
			}	
		}
	}
	
	
	///Multiplicamos los dos polinomios
	public void multiplicarPol(Polinomio pol1,Polinomio pol2)
	{
		int i,j;
		for (i=0; i < pol1.tamaño(); i++)
		{
			for (j=0; j < pol2.tamaño(); j++)
			{
				this.añadirTermino(pol1.pol.get(i).multiplicarTer(pol2.pol.get(j)));
			}
		}
	}
	
	
	///Multiplicamos el polinomio por un escalar
	public void multiplicarEscalar(Polinomio pol1,int num)
	{
		int i;
		for (i=0; i < pol1.tamaño(); i++)
		{
			this.pol.addElement(pol1.pol.get(i).multiplicarEsc(num));
		}
	}
	
	

	///Devuelve el numero de elementos del vector
	public int tamaño()
	{
		return this.pol.size();
	}
	
	
	///Mostramos el polinomio
	public void mostrar()
	{
		int i;
		for (i=0; i<this.pol.size(); i++)
		{
			System.out.print("("+this.pol.get(i).getCoef()+"x^"+this.pol.get(i).getGrad()+")");
			if(i!=this.tamaño()-1) 
			{
				System.out.print("+");
			}
		}
	}


}
