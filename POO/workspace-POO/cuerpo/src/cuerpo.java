

import java.util.*;


public class cuerpo {
	

private	Vector<Punto> listapuntos=new Vector<Punto>();
	
	public void cuerpo(Punto punto)
	{
		this.listapuntos.addElement(punto);
	}
	
	public void Visualizar(int puntos)
	{
		int i ;
		for(i=0;i<puntos;i++)
		{
			System.out.println("Punto "+(i+1)+": ("+this.listapuntos.elementAt(i).x()+","+this.listapuntos.elementAt(i).y()+")");
		}
		if((this.listapuntos.elementAt(0).x()==this.listapuntos.elementAt(puntos-1).x()) &&(this.listapuntos.elementAt(0).y()==this.listapuntos.elementAt(puntos-1).y()))
		{
			System.out.println("Esta figura es cerrada");
		}
		else
		{
			System.out.println("Esta figura es abierta");
		}
	}
	
	public void insertarvalorx(int puntos)
	{
		Punto punto;
		int disx,dismenor=200000,x,y,i=0,pos=0;
		System.out.println("Escriba el nuevo punto para introducirlo en la figura");
		System.out.println("Escriba la coordenada x");
		x=Teclado.leerInt();
		
		System.out.println("Escriba la coordenada y");
		y=Teclado.leerInt();
		punto=new Punto(x,y);
		///////////////////////////////////////////////////////////////////
		
		//buscamos la posicion de insercion del nuevo punto
		i=0;
		pos=i;
		while(i<=puntos-1)
		{
			disx=x-this.listapuntos.elementAt(i).x();
			if(disx<0) disx=disx*(-1);
			if(disx<dismenor)
			{
				dismenor=disx;
				pos=i;
			}
			i++;
		}
		System.out.println("Posicion: "+pos+"\nDistancia: "+dismenor);
		

		this.listapuntos.add(pos,punto);
		
		this.Visualizar(puntos+1);
		
	}
	
	public void insertarvalory(int puntos)
	{
		Punto punto;
		int disy,dismenor=200000,x,y,i=0,pos=0;
		System.out.println("Escriba el nuevo punto para introducirlo en la figura");
		System.out.println("Escriba la coordenada x");
		x=Teclado.leerInt();
		
		System.out.println("Escriba la coordenada y");
		y=Teclado.leerInt();
		punto=new Punto(x,y);
		///////////////////////////////////////////////////////////////////
		
		//buscamos la posicion de insercion del nuevo punto
		i=0;
		pos=i;
		while(i<=puntos-1)
		{
			disy=y-this.listapuntos.elementAt(i).y();
			if(disy<0) disy=disy*(-1);
			if(disy<dismenor)
			{
				dismenor=disy;
				pos=i;
			}
			i++;
		}
		System.out.println("Posicion: "+pos+"\nDistancia: "+dismenor);
		

		this.listapuntos.add(pos,punto);
		
		this.Visualizar(puntos+1);
		
	}
	
	
	
	public int numerovertices()
	{
		int vertices;
		
		vertices=this.listapuntos.size();
		if((this.listapuntos.elementAt(0).x()==this.listapuntos.elementAt(vertices-1).x()) &&(this.listapuntos.elementAt(0).y()==this.listapuntos.elementAt(vertices-1).y()))
		{
			vertices--;
		}

		return vertices;		
	}
	
	
	
	
	
	public void rotar(int puntos)
	{
		int i, rotacion=0;
		
		System.out.println("Dame la rotacion:");
		rotacion=Teclado.leerInt();
		

		for(i=0;i<=puntos-1;i++)
		{
			this.listapuntos.elementAt(i).rotar(rotacion);
		}
		
		this.Visualizar(puntos);
		
		
	}
	
	
	
	
	
	
	
	
	public void desplazarfigura(int puntos)
	{
		int i, disx=0, disy=0;
		
		System.out.println("Dame la distancia de desplazamiento respecto a x");
		disx=Teclado.leerInt();
		
		System.out.println("Dame la distancia de desplazamiento respecto a y");
		disy=Teclado.leerInt();
		
		for(i=0;i<=puntos-1;i++)
		{
			this.listapuntos.elementAt(i).desplazar(disx, disy);
		}
		
		this.Visualizar(puntos);
		
		
	}
	
	
}
