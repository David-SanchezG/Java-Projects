import java.awt.*;
import java.applet.Applet;


public class pruebaPanel extends Applet 
{
	Button aceptar;
	TextField entrada;
	Panel mostrar;
	public void init() 
	{
		mostrar = new Panel();
		setLayout(null);
		aceptar = new Button("Aceptar");
		entrada = new TextField();
		mostrar.add(entrada);
		mostrar.add(aceptar);
		add(mostrar);
		mostrar.setBounds( 20, 40, 100, 130 );
		mostrar.setBackground(Color.pink);
	}
}
