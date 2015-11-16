import java.awt.*;
import java.applet.Applet;


public class etiquetasycampos extends Applet 
{
	Label etiqueta;
	TextField campo;
	public void init() 
	{
		etiqueta = new Label("Etiqueta");
		campo = new TextField( 10 );
		add(etiqueta);
		add(campo);
	}
	public void paint(Graphics g) {
	}
	
	

}
