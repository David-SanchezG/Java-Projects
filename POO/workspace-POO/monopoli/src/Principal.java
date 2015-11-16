public class Principal{

	public static void main(String[] args) {
		Polinomio result;
		int esc;
		
		
		//creamos polinomio 1 y 2
		Polinomio polinomio1=new Polinomio();
		Polinomio polinomio2=new Polinomio();
		System.out.println("Polinomio 1:");
		polinomio1.crearPolinomio();
		System.out.println("Polinomio 2:");
		polinomio2.crearPolinomio();
		
		
	
		///Sumamos los dos polinomios
		System.out.println("\nSuma de los polinomios:");
		result=new Polinomio();
		result.sumarPol(polinomio1, polinomio2);
		result.mostrar();
		System.out.println("");		
		
		
		///Restamos los dos polinomios
		System.out.println("\nResta de los polinomios:");
		result=new Polinomio();
		result.restarPol(polinomio1, polinomio2);
		result.mostrar();
		System.out.println("");
		
		
		///Multiplicamos los dos polinomios
		System.out.println("\nMultiplicación de los polinomios:");
		result=new Polinomio();
		result.multiplicarPol(polinomio1, polinomio2);
		result.mostrar();
		System.out.println("");
		
		
		///Multiplicamos el polinomio 1 por un escalar
		System.out.println("\nMultiplicacion del polinomio 1 por un escalar\n"+
				"Introduzca un escalar: ");
		esc=Teclado.leerInt();
		result=new Polinomio();
		result.multiplicarEscalar(polinomio1, esc);
		result.mostrar();
		
	}
	


}