import java.awt.*;
import java.applet.Applet;


public class listas extends Applet
{
	List superMercado;
	public void init() 
	{
		superMercado = new List(8, false);
		superMercado.addItem("Leche");
		superMercado.addItem("Huevo");
		superMercado.addItem("Pan");
		superMercado.addItem("Crema");
		superMercado.addItem("Miel");
		superMercado.addItem("Ketchup");
		superMercado.addItem("Arroz");
		superMercado.addItem("Queso");
		add(superMercado);
	}
}