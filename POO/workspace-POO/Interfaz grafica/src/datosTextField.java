import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
public class datosTextField extends Applet implements ActionListener 
{
	Label entero, numDouble, texto;
	TextField tentero, tnumDouble, ttexto;
	int digitoEntero;
	double digitoDouble;
	String cadena;
	
	public void init()
	{
		entero = new Label("Escribe un entero y presiona enter:");
		numDouble = new Label("Escribe un double y presiona enter:");
		texto = new Label("Escribe una palabra y presiona enter:");
		tentero = new TextField();
		tnumDouble = new TextField();
		ttexto = new TextField();
		setLayout( new GridLayout( 4, 2 ) );
		add( entero );
		add( tentero );
		add( numDouble );
		add( tnumDouble );
		add( texto );
		add( ttexto );
		tentero.addActionListener(this);
		tnumDouble.addActionListener(this);
		ttexto.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == tentero ) 
		{
			digitoEntero = Integer.parseInt( event.getActionCommand() );
		} 
		else if (event.getSource() == tnumDouble)
		{
			Double d = new Double( event.getActionCommand() );
			digitoDouble = d.doubleValue();
		} 
		else if (event.getSource() == ttexto)
		{
			cadena = ttexto.getText();
		}
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString( "Entero : " + String.valueOf(digitoEntero), 10, 110 );
		g.drawString( "Double: " + String.valueOf(digitoDouble), 90, 110 );
		g.drawString( "Cadena: " + cadena, 200, 110 );
	}
}