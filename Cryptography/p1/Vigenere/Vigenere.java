public class Vigenere {

	private static char[] vectorabc = new char[27];

	
	public static void main(String[] args) {
		
	 
		//creamos el vector del abecedario español
		vectorabc= abecedario();
						
		//hacemos visible la ventana
		ventana vtnvigenere = new ventana();
		vtnvigenere.setVisible(true);
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
	
	
	
	
	
	public static String cifrar(String texto, String clave)
	{
		int i,j,t=0,c=0;
		char[] conv=new char[texto.length()];		
		for(i=0;i<texto.length();i++)
		{
			if(texto.charAt(i)!=' ')
			{
				for(j=0;j<27;j++)
				{				
					if(vectorabc[j]==clave.charAt(i%clave.length()))c=j;
					if(vectorabc[j]==texto.charAt(i))t=j;	
				}
				conv[i]=vectorabc[((t+c)%27)];
			}else conv[i]=' ';
		}
		String cadena = new String();
		cadena=String.copyValueOf(conv);
		return cadena;
	}
	
	
	public static String descifrar(String texto, String clave)
	{
		int i,j,t=0,c=0;
		char[] conv=new char[texto.length()];
		for(i=0;i<texto.length();i++)
		{
			if(texto.charAt(i)!=' ')
			{
				for(j=0;j<27;j++)
				{										
					if(vectorabc[j]==clave.charAt(i%clave.length()))c=j;
					if(vectorabc[j]==texto.charAt(i))t=j;
				}				
				t=t-c;
				if(t<0)t=t+27;
				conv[i]=vectorabc[t];
			}else conv[i]=' ';
			
		}
		String cadena = new String();
		cadena=String.copyValueOf(conv);
		return cadena;
	}


}
