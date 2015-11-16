import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class eventoBotonAlternativo extends Applet implements ActionListener 
{
	int contarClicks;
	Button botoncito;
	
	public void init() 
	{
		botoncito = new Button("Dame click!");
		add(botoncito);
		botoncito.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) 
	{
		++contarClicks;
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString("Clicks: " + contarClicks, 40, 50);
	}
}