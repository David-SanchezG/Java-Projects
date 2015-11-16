import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Insets;


public class ventana extends JFrame {
	private JTextField txtsemilla;
	private JTextField txtgrado;
	private JTextField txtcuerpo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 262);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btngenerar = new JButton("GENERAR");
		btngenerar.setForeground(Color.BLACK);
		btngenerar.setHorizontalTextPosition(SwingConstants.CENTER);
		btngenerar.setBackground(Color.RED);
		btngenerar.setBounds(20, 97, 92, 73);
		panel.add(btngenerar);
		
		txtsemilla = new JTextField();
		txtsemilla.setHorizontalAlignment(SwingConstants.CENTER);
		txtsemilla.setBounds(162, 149, 86, 20);
		panel.add(txtsemilla);
		txtsemilla.setColumns(10);
		
		JLabel lbllfsr = new JLabel("LFSR");
		lbllfsr.setBounds(183, 0, 39, 22);
		panel.add(lbllfsr);
		lbllfsr.setForeground(Color.RED);
		lbllfsr.setBackground(Color.WHITE);
		lbllfsr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbllfsr.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblngenerado = new JLabel("N\u00DAMERO GENERADO");
		lblngenerado.setBounds(142, 180, 130, 17);
		panel.add(lblngenerado);
		lblngenerado.setHorizontalAlignment(SwingConstants.CENTER);
		lblngenerado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtgrado = new JTextField();
		txtgrado.setHorizontalAlignment(SwingConstants.CENTER);
		txtgrado.setBounds(162, 97, 86, 20);
		panel.add(txtgrado);
		txtgrado.setColumns(10);
		
		JLabel lblsemilla = new JLabel("INTRODUZCA LA SEMILLA");
		lblsemilla.setBounds(142, 128, 170, 14);
		panel.add(lblsemilla);
		
		JLabel lblgrado = new JLabel("INTRODUZCA EL GRADO DEL POLINOMIO");
		lblgrado.setHorizontalTextPosition(SwingConstants.CENTER);
		lblgrado.setBounds(98, 71, 229, 15);
		panel.add(lblgrado);
		lblgrado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnintroducircoeficientes = new JButton("Introducir coeficientes");
		btnintroducircoeficientes.setMargin(new Insets(2, 5, 2, 5));
		btnintroducircoeficientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnintroducircoeficientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnintroducircoeficientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtgrado.getText()!=null&&LFSR.comprobarprimo(Integer.parseInt(txtcuerpo.getText())))
				{
					LFSR.crearpolinomio(Integer.parseInt(txtgrado.getText()),Integer.parseInt(txtcuerpo.getText()));
				}
				else JOptionPane.showMessageDialog(null, "Debe escribir el grado primero");
			}
		});
		btnintroducircoeficientes.setBounds(265, 96, 130, 23);
		panel.add(btnintroducircoeficientes);
		
		txtcuerpo = new JTextField();
		txtcuerpo.setHorizontalAlignment(SwingConstants.CENTER);
		txtcuerpo.setBounds(162, 40, 86, 20);
		panel.add(txtcuerpo);
		txtcuerpo.setColumns(10);
		
		JLabel lblcuerpo = new JLabel("CUERPO");
		lblcuerpo.setForeground(Color.BLACK);
		lblcuerpo.setBackground(Color.BLACK);
		lblcuerpo.setHorizontalAlignment(SwingConstants.CENTER);
		lblcuerpo.setBounds(83, 40, 74, 20);
		panel.add(lblcuerpo);
		
		final JTextArea txtresultado = new JTextArea();
		txtresultado.setCaretColor(Color.LIGHT_GRAY);
		txtresultado.setForeground(Color.BLACK);
		txtresultado.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		txtresultado.setEditable(false);
		txtresultado.setBounds(95, 200, 232, 51);
		panel.add(txtresultado);
		
		
		btngenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtcuerpo.getText()==null||txtgrado.getText()==null)JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
				else txtresultado.setText(LFSR.generar(Integer.parseInt(txtgrado.getText()), txtsemilla.getText()));		
			}
		});
		
	}
	
	public void PNCoeficientes()
	{
		
	}
}
