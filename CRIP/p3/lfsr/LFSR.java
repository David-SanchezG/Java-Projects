import javax.swing.JOptionPane;

public class LFSR {

	private static int cuerpo;
	private static String semilla;
	private static int[] polinomio;
	private static double entradas;
	private static int[][] matrizlfsr;
	private static boolean creado=false;
	
	public static void main(String[] args) {
		//hacemos visible la ventana
		ventana vtnlfsr = new ventana();
		vtnlfsr.setVisible(true);
	}
	
	
	
	public static String generar(int grado,String ssemilla)
	{		 
		int i=0;
		semilla=ssemilla;
		
		boolean cuerpovalido = comprobarprimo(cuerpo);
		entradas=grado;
		while(i<cuerpo-1)
		{
			entradas=entradas*grado;
			i++;
		}
		entradas = Math.pow(cuerpo, grado);
		matrizlfsr=new int[(int) (entradas-1)][grado];
		return lfsr(grado);
	}
	
	public static String lfsr(int grado)
	{
		int i=0,k=0,resul=0;
		String ngenerado = "",cadena1,cadenaact;
		int[] aformula = new int[grado];
		boolean repe=false;
				
		//consigo la formula del elemento de grado n de la secuencia
		i=grado-1;
		while(i>=0)
		{
			aformula[i]=polinomio[i]*-1;
			i--;
		}
		//la pongo modulo el cuerpo
		i=0;
		while(i<grado)
		{
			while(aformula[i]<0)
			{
				aformula[i]=aformula[i]+cuerpo;
			}
			i++;
		}
		
		//meto la semilla en lamatriz lfsr
		i=0;
		while(i<grado)
		{
			matrizlfsr[0][i]=Integer.parseInt(String.valueOf(semilla.charAt(i)));
			i++;
		}//meto el primer elemento generado
		ngenerado=String.valueOf(matrizlfsr[0][0]);System.out.println(entradas);
		cadenaact="";
		for(int j=1;j<entradas-1&&repe==false;j++)
		{
			for(i=0;i<grado-1;i++)//muevo una posicion a la izquierda los elementos
			{
				matrizlfsr[j][i]=matrizlfsr[j-1][i+1];
			}
			k=0;resul=0;//calculo el nuevo elemento con la formula
			while(k<grado)
			{
				resul=(resul+aformula[k]*matrizlfsr[j-1][k])%cuerpo;
				k++;
			}
			matrizlfsr[j][i]=resul;
			for(int f=0;f<j&&repe==false;f++)//recorro todas las filas para comprobar si se ha repetido la sucesión
			{
				cadena1="";cadenaact="";
				int l=0;
				while(l<grado)
				{
					cadena1=cadena1+matrizlfsr[f][l];
					cadenaact=cadenaact+matrizlfsr[j][l];					
					l++;
				}
				if(cadena1.contains(cadenaact)==true)repe=true;System.out.println(cadena1 + " " + cadenaact + " " + repe);
			}
			if(repe==false)
			{
				ngenerado=ngenerado+matrizlfsr[j][0];
				System.out.println("cadena : "+ j + " " + cadenaact + " " + repe);
			}
		}
		return ngenerado;
	}
	
		
	public static boolean comprobarprimo(int cuerpo)
	{
		boolean valido=true;
		if(cuerpo<2)valido=false;
		else
		{//primo
			for(int i = 2;i<cuerpo;i++)
			{
				if(cuerpo%i==0)valido=false;
			}
		}
		return valido;
	}
	
	
	public static void crearpolinomio(int grado,int ncuerpo)
	{
		int i=0,coeficiente=0;
		cuerpo=ncuerpo;System.out.println("cuerpo: "+cuerpo);
		polinomio = new int[grado+1];

		//pido todos los terminos
		while(i<=grado)
		{
			coeficiente=Integer.parseInt(JOptionPane.showInputDialog("Inserte el coeficiente del término de grado " + i));
			if(coeficiente<0)
			{
				while(coeficiente<0)
				{
					coeficiente=coeficiente+cuerpo;
				}
			}
			else coeficiente=coeficiente%cuerpo;
			polinomio[i]=coeficiente;System.out.println("termino: "+ i + " = " + coeficiente);
			i++;
		}
	}
	

}
