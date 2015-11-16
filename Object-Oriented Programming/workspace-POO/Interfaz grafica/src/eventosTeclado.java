import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class eventosTeclado extends Applet implements KeyListener 
{
	char presionada, soltada, oprimida;
	public void init() 
	{
		addKeyListener(this);
		requestFocus();
	}
	public void keyPressed(KeyEvent event)
	{
		presionada = event.getKeyChar();
		repaint();
	}
	public void keyReleased(KeyEvent event) 
	{
		soltada = event.getKeyChar();
		repaint();
	}
	public void keyTyped(KeyEvent event)
	{
		oprimida = event.getKeyChar();
		repaint();
	}
	public void paint(Graphics g) 
	{
		g.drawString( "Presionada : " + String.valueOf(presionada), 10, 10 );
		g.drawString( "Soltada: " + String.valueOf(soltada), 10, 30 );
		g.drawString( "Oprimida: " + String.valueOf(oprimida), 10, 50 );
	}
}