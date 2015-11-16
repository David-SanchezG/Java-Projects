import java.awt.*;
import java.applet.Applet;


public class botonOpcion extends Applet 
{
	Choice bopcion;
	public void init() 
	{
		bopcion = new Choice();
		bopcion.add("Uno...");
		bopcion.add("Dos...");
		bopcion.add("Tres!");
		bopcion.add("Cuatro!!!");
		bopcion.add("Etcétera, etcétera...");
		add(bopcion);
	}
}