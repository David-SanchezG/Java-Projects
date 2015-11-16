
public class Termino 
{
	private int coeficiente;
	private int grado;
	
	public Termino(int coef,int grad)
	{
		coeficiente = coef;
		grado = grad;
	}
	
	
	public int getGrad()
	{
		return grado;
	}
	
	
	
	public Termino sumarTer(Termino t)
	{
		Termino result;
		result = new Termino(this.coeficiente + t.coeficiente,this.grado);
		return result;
	}
	
	public Termino restarTer(Termino t)
	{
		Termino result;
		result = new Termino(this.coeficiente - t.coeficiente,this.grado);
		return result;
	}

	public Termino multiplicarTer(Termino t)
	{
		Termino result;
		result = new Termino(this.coeficiente * t.coeficiente,this.grado+t.grado);
		return result;
	}
	
	public Termino multiplicarEsc(int esc)
	{
		Termino result;
		result = new Termino(this.coeficiente * esc,this.grado);
		return result;
	}
	
	
	
	
	public double getCoef()
	{
		return coeficiente;
	}
	
}
