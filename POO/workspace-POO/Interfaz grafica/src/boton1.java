import java.awt.*;
import java.applet.Applet;


public class boton1 extends Applet 
{
	Button boton;
	public void init() 
	{
		boton = new Button("Hola!");
		setLayout(null);
		boton.setBounds(20,20,100,25);
		add(boton);
	}
	public void paint(Graphics g) {
	}
}
