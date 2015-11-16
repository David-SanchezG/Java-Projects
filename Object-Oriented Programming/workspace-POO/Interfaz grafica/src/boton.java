import java.awt.*;
import java.applet.Applet;


public class boton extends Applet 
{
	Button boton;
	public void init() 
	{
		boton = new Button("Hola!");
		add(boton);
	}
	public void paint(Graphics g) {
	}
}