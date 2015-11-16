import java.util.Vector;

import javax.swing.JOptionPane;


public class Playfair {

	private static char[] vectorabc = new char[27];
	private static char[][] mclave = new char[5][5];
	
	public static void main(String[] args) {
		
	 
		//creamos el vector del abecedario español
		vectorabc= abecedario();
						
		//hacemos visible la ventana
		ventana vtnPlayfair = new ventana();
		vtnPlayfair.setVisible(true);
	}
	
	
	
	public static char[] abecedario()
	{		 
	    char[]a=new char[27];
	    int i;
	    
	    for(i=0; i<14; i++)
	    {
	    	a[i]=(char)('A'+i);   
	    }
	    //la ñ no esta en ingles
    	a[i]='Ñ';
    	
    	int j=15;
	    for(i=14; i<26; i++)
	    {
	    	a[j]=(char)('A'+i);
	    	j++;
	    } 
	    return a;
	}
	
	
	private static void crear_matriz_clave(String clave)
	{
		int i=0,a=0,b=0, fin=0;
		boolean puesta= false;
		int[] pos = new int[3];
		String cadenaclave = null;
		
		while(fin!=25)
		{
			mclave[a][b]=' ';
			b=(b+1)%5;
			if(b==0)a++;
			fin++;
		}
		
		a=0;b=0;
		//CONSTRUYO LA MATRIZ
		while(i<clave.length())//j controla el numero de elemento en la matriz
		{
			puesta=false;
			pos = buscarposiciones(clave.charAt(i));
			if(pos[2]!=-1)puesta=true;
			
			if(puesta==false)
			{
				if(clave.charAt(i)=='J') mclave[a][b]='I';
				else if(clave.charAt(i)=='Ñ') mclave[a][b]='N';
				else mclave[a][b]=clave.charAt(i);
				b=(b+1)%5;//Incremento la posicion en la matriz
				if(b==0)a++;
			}		
			i++;
		}

		
		for(i=0;i<27;i++)
		{
			puesta=false;
			pos = buscarposiciones(vectorabc[i]);
			if(pos[2]!=-1)puesta=true;
			if(puesta==false)
			{
				mclave[a][b]=vectorabc[i];
				b=(b+1)%5;
				if(b==0)a=(a+1)%5;
			}
		}

		for(i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(mclave[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static int[] buscarposiciones(char a)
	{
		int[] pos = new int[3];
		int f=0,c=0, j=0;
		j=0;
		if(a=='Ñ')a='N';
		if(a=='J')a='I';
		while(j<25 && a!=mclave[f][c] && mclave[f][c]!=' ')
		{
			c=(c+1)%5;
			if(c==0)f=(f+1)%5;
			j++;
		}
		if(mclave[f][c]==' ')j=-1;
		pos[0]=f;pos[1]=c;pos[2]=j;
		return pos;
	}
	
	
	public static String prepararcadena(String texto)
	{
		//COMPRUEBO QUE NO HAYA DIGRAMAS IGUALES Y METO UN CARACTER EN MEDIO PARA EVITARLO
		int i = 0;
		char a = 0,b = 0;
		while(i<texto.length()-1)
		{
			a=texto.charAt(i); if(a=='Ñ')a='N';else if(a=='J')a='I';
			b=texto.charAt(i+1);if(b=='Ñ')b='N';else if(b=='J')b='I';
			if(a==b)
			{
				texto=texto.substring(0, i+1)+"X"+texto.substring(i+1, texto.length());
			}
			i=i+2;
		}		
		
		//COMPRUEBO SI LA LONGITUD DEL TEXTO ES PAR O IMPAR Y LE AÑADO X SI LO NECESITA
		if(texto.length()%2!=0)texto=texto.concat("X");
		
		return texto;
	}
	
	
	
	public static String cifrar(String texto, String clave)
	{
		int i=0;
		int[] pos = new int[3], pos2 = new int[3];
		String texto2=texto;		
		char[] conv;
		crear_matriz_clave(clave);
			
		texto2=prepararcadena(texto);
		
		JOptionPane.showMessageDialog(null, "Se cifrara el siguiente texto: " + texto2);
		
		conv=new char[texto2.length()];
		
		for(i=0;i<=texto2.length()-2;i++)
		{
			pos = buscarposiciones(texto2.charAt(i));
			pos2 = buscarposiciones(texto2.charAt(i+1));

			if(pos[0]==pos2[0])
			{
				conv[i]=mclave[pos[0]][(pos[1]+1)%5];
				conv[i+1]=mclave[pos2[0]][(pos2[1]+1)%5];
			}
			else if(pos[1]==pos2[1])
			{
				conv[i]=mclave[(pos[0]+1)%5][pos[1]];
				conv[i+1]=mclave[(pos2[0]+1)%5][pos2[1]];
			}
			else
			{
				conv[i]=mclave[pos[0]][pos2[1]%5];
				conv[i+1]=mclave[pos2[0]][pos[1]%5];
			}	
			i++;
		}
		
		
		
		return String.copyValueOf(conv);
	}
	
	
	public static String descifrar(String texto, String clave)
	{
		int i=0;
		int[] pos = new int[3], pos2 = new int[3];
		String texto2=texto;
		char[] conv;
		crear_matriz_clave(clave);
		

		texto2=prepararcadena(texto);
		
		JOptionPane.showMessageDialog(null, "Se descifrara el siguiente texto: " + texto2);
		
		conv=new char[texto2.length()];
		
		for(i=0;i<=texto2.length()-2;i++)
		{
			pos = buscarposiciones(texto2.charAt(i));
			pos2 = buscarposiciones(texto2.charAt(i+1));
			if(pos[0]==pos2[0])
			{
				conv[i]=mclave[pos[0]][(pos[1]+4)%5];
				conv[i+1]=mclave[pos2[0]][(pos2[1]+4)%5];
			}
			else if(pos[1]==pos2[1])
			{
				conv[i]=mclave[(pos[0]+4)%5][pos[1]];
				conv[i+1]=mclave[(pos2[0]+4)%5][pos2[1]];
			}
			else
			{
				conv[i]=mclave[pos[0]][pos2[1]%5];
				conv[i+1]=mclave[pos2[0]][pos[1]%5];
			}	
			i++;
		}
		
		
		
		return String.copyValueOf(conv);
	}


}
