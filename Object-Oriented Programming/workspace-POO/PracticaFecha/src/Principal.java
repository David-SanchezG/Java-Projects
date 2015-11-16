

public class Principal {
	
	public static void main(String[] args) {
		int dia,mes,año, formato,a;
		
    	
    	//Hacemos la construccion de una primera fecha correctamente
    	System.out.println("Fecha 1:\nIntroduzca el dia: ");
    	dia=Teclado.leerInt();
    	
    	System.out.println("Introduzca el mes: ");
    	mes=Teclado.leerInt();
    	
    	System.out.println("Introduzca el año: ");
    	año=Teclado.leerInt();
    	
    	//Se construye la fecha comprobandola
        Fecha fecha1 = new Fecha(dia,mes,año);
        
    	System.out.println("Fecha construida correctamente");
    	
    	//Pedimos el formato de la fecha
    	do{
    	System.out.println("¿En que formato lo quiere?:\n" +
    			"1-dd/mm/aaaa\n" +
    			"2-dd/mes/aaaa\n");
    	
    	formato= Teclado.leerInt();
    	if(formato<1||formato>2)
    	{
    		System.out.println("Formato incorrecto.");
    	}
    	}while(formato<1||formato>2);
    	//mostramos la fecha en el formato seleccionado
    	fecha1.mostrarFormato(formato);
    	
    	
    	
    	////////////////////////////SEGUNDA FECHA
    	//Hacemos la construccion de una segunda fecha correctamente
    	System.out.println("Fecha 2:\nIntroduzca el dia: ");
    	dia=Teclado.leerInt();
    	
    	System.out.println("Introduzca el mes: ");
    	mes=Teclado.leerInt();
    	
    	System.out.println("Introduzca el año: ");
    	año=Teclado.leerInt();
    	
    	//Se construye la fecha comprobandola
        Fecha fecha2 = new Fecha(dia,mes,año);
    	System.out.println("Fecha construida correctamente");
    	
    	//Pedimos el formato de la fecha
    	do{
	    	System.out.println("¿En que formato lo quiere?:\n" +
	    			"1-dd/mm/aaaa\n" +
	    			"2-dd/mes/aaaa\n");
	    	
	    	formato= Teclado.leerInt();
	    	
	    	if(formato<1||formato>2)
	    		System.out.println("Formato incorrecto.");
	    	
    	}while(formato<1||formato>2);
    	
    	//mostramos la fecha en el formato seleccionado
    	fecha2.mostrarFormato(formato);
    	
    	
    	 //Comprobar que fecha es mayor
    	a=fecha1.comparar(fecha2);
    	switch(a)
    	{
    		case 0:System.out.println("Fecha 1 es menor que fecha 2");
    			break;
    		case 1:System.out.println("Fecha 1 es igual a fecha 2");
    			break;
    		case 2:System.out.println("Fecha 1 es mayor a fecha 2");
    			break;
    	}
    	
    	
    	
        //Calculamos el numero de dias entre dos fechas
    	System.out.println("Hay una diferencia de "+Fecha.DiferenciaFechas(fecha1, fecha2)+" dias");
    	
    	
       	//Calculamos una nueva fecha pasados un numero de dias
    	System.out.println("Introduzca el numero de dias a sumar a la fecha 1: ");
    	dia=Teclado.leerInt();
    	Fecha fecha3;
    	fecha3=fecha1.sumarDias(dia);
    	System.out.println("La nueva fecha es "+fecha3.sacardia()+"/"+fecha3.sacarmes()+"/"+fecha3.sacaraño());
    	
    	
	}
}
