import java.awt.*;
import java.applet.Applet;


public class layouts extends Applet 
{
	Button a, b, c;
	Choice d;
	Checkbox e, f, g;
	TextField h;
	Label i;
	GridBagLayout reticula;
	GridBagConstraints restricciones;
	
	
	void addComponent( Component comp, GridBagLayout bag, GridBagConstraints bagcons,
	int linea, int columna, int ancho, int alto ) 
	{
		bagcons.gridx = columna;
		bagcons.gridy = linea;
		bagcons.gridwidth = ancho;
		bagcons.gridheight = alto;
		bag.setConstraints( comp, bagcons );
		add( comp );
	}
	
	
	public void init() 
	{
		reticula = new GridBagLayout();
		setLayout( reticula );
		restricciones = new GridBagConstraints();
		a = new Button("Botón A");
		b = new Button("Botón B");
		c = new Button("Botón C");
		d = new Choice();
		d.add("Uno");
		d.add("Dos");
		d.add("Tres");
		e = new Checkbox("Primera");
		f = new Checkbox("Segunda");
		g = new Checkbox("Tercera");
		h = new TextField();
		i = new Label("Etiqueta en la cuarta linea");
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(a, reticula, restricciones, 0, 0, 1, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(b, reticula, restricciones, 2, 1, 2, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(c, reticula, restricciones, 1, 2, 1, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(d, reticula, restricciones, 0, 1, 2, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(e, reticula, restricciones, 3, 0, 1, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(f, reticula, restricciones, 3, 1, 1, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(g, reticula, restricciones, 3, 2, 1, 1 );
		restricciones.weightx = 1;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(h, reticula, restricciones, 1, 0, 2, 1 );
		restricciones.weightx = 10;
		restricciones.weighty = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		addComponent(i, reticula, restricciones, 4, 0, 3, 1 );
	}
}