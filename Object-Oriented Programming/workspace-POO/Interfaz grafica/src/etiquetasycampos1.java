import java.awt.*;
import java.applet.Applet;


public class etiquetasycampos1 extends Applet 
{
	Label etiqueta1, etiqueta2;
	TextField campo1, campo2;
	public void init() {
		etiqueta1 = new Label("Etiqueta Uno");
		campo1 = new TextField( 10 );
		etiqueta2 = new Label("Etiqueta Dos");
		campo2 = new TextField( 10 );
		campo2.setText("Campo 2");
		setLayout(null);
		etiqueta1.setBounds(60,20,100,25);
		campo1.setBounds(70,50,100,25);
		etiqueta2.setBounds(60,100,100,25);
		campo2.setBounds(70,130,100,25);
		add(etiqueta1);
		add(campo1);
		add(etiqueta2);
		add(campo2);
	}
	public void paint(Graphics g) {
	}
}