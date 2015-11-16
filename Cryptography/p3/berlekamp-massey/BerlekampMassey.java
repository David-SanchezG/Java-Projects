import javax.swing.JOptionPane;

public class BerlekampMassey {

	private static int cuerpo;
	private static String semilla;
	private static int[] polinomio;
	private static double entradas;
	private static int[][] matrizlfsr;
	private static boolean creado=false;
	
	public static void main(String[] args) {
		
			String cadena="";
			cadena=JOptionPane.showInputDialog(cadena);
	        final int N = cadena.length();
	        int[] s = new int[cadena.length()];
	        for(int i=0;i<cadena.length();i++)
        	{
	        	s[i]=Integer.parseInt(""+cadena.charAt(i));
        		System.out.println(s[i]);
        	}
	        int[] b = new int[N];
	        int[] c = new int[N];
	        int[] t = new int[N];
	        b[0] = 1;
	        c[0] = 1;
	        int l = 0;
	        int m = -1;
	        for (int n = 0; n < N; n++) 
	        {
	            int d = 0;
	            for (int i = 0; i <= l; i++) 
	            {
	                d = (d + c[i] * s[n - i]) % 2;
	            }
	            if (d == 1) 
	            {
	                System.arraycopy(c, 0, t, 0, N);
	                int NM = n-m;
	                for (int j = 0; j <N-NM; j++) 
	                {
	                    c[NM + j] = (c[NM + j] + b[j]) % 2;
	                }
	                if (l <= n / 2) 
	                {
	                    l = n + 1 - l;
	                    m = n;
	                    System.arraycopy(t, 0, b, 0, N);
	                }
	            }
	        }
	        
	        //Mostrar polinomio
	        String resultado = "";
	        System.out.println("Polinomio obtenido: ");
	        int suma=0;
	        int i=0;
	        while(i<cadena.length())
	        {
	        	if(c[i]>=1)
	        	{
	        		if(suma==1)
		        	{
		        		System.out.print(" + ");
	        			resultado = resultado + " + ";
	        			suma=0;
		        	}
		        	if(i==0)
	        		{
		        		System.out.print(c[i]);
		        		resultado = resultado + c[i];
	        		}
		        	else 
		        	{
		        		if(c[i]>=2)
		        		{
		        			System.out.print(c[i]);
		        			resultado = resultado + c[i];
		        		}
	        			System.out.print("x");
	        			resultado = resultado + "x";
		        		if(i>=2)
		        		{
		        			System.out.print("^" + i);
		        			resultado = resultado + "^" + i;
		        		}
		        	}
		        	suma=1;
	        	}
        		i++;
	        }
	        System.out.println();
	        System.out.println("Complejidad : " + l);
	        JOptionPane.showMessageDialog(null, "Número generado: " + resultado + "\n" + "Complejidad : " + l);
	}
}
