import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class eventoBoton extends Applet 
{
	int contarClicks;
	Button botoncito;
	
	public void init() 
	{
		botoncito = new Button("Dame click!");
		add(botoncito);
		botoncito.addActionListener( new escucharBoton() );
	}
	public class escucharBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			++contarClicks;
			repaint();
		}
	}
	public void paint(Graphics g) 
	{
		g.drawString("Clicks: " + contarClicks, 40, 50);
	}
}