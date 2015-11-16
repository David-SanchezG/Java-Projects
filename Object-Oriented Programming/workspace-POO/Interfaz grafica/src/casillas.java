import java.awt.*;
import java.applet.Applet;
public class casillas extends Applet 
{
	Checkbox primera, segunda, tercera;
	public void init() 
	{
		primera = new Checkbox("Primera");
		segunda = new Checkbox("Segunda");
		tercera = new Checkbox();
		tercera.setLabel("Tercera!");
		tercera.setState(true);
		add(primera);
		add(segunda);
		add(tercera);
	}
}
