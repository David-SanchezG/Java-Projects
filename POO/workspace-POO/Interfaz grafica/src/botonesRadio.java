import java.awt.*;
import java.applet.Applet;
public class botonesRadio extends Applet 
{
	CheckboxGroup grupoCasillas;
	Checkbox primera, segunda, tercera;
	public void init() 
	{
		grupoCasillas = new CheckboxGroup();
		primera = new Checkbox("Primera", grupoCasillas, false);
		segunda = new Checkbox("Segunda", grupoCasillas, true);
		tercera = new Checkbox("Tercera", grupoCasillas, false);
		add(primera);
		add(segunda);
		add(tercera);
	}
}
