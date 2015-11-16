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


public class ventana extends JFrame {
	private JTextField txttexto;
	private JTextField txtresultado;
	private JTextField txtclave;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnDescifrar = new JButton("Descifrar");
		btnDescifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtresultado.setText(Vigenere.descifrar(txttexto.getText(), txtclave.getText()));				
			}
		});
		btnDescifrar.setBounds(250, 215, 89, 23);
		getContentPane().add(btnDescifrar);
		
		JButton btnCifrar = new JButton("Cifrar");
		btnCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtresultado.setText(Vigenere.cifrar(txttexto.getText(), txtclave.getText()));			
			}
		});
		btnCifrar.setBounds(93, 215, 89, 23);
		getContentPane().add(btnCifrar);
		
		txttexto = new JTextField();
		txttexto.setBounds(65, 90, 319, 20);
		getContentPane().add(txttexto);
		txttexto.setColumns(10);
		
		txtresultado = new JTextField();
		txtresultado.setEditable(false);
		txtresultado.setBounds(65, 184, 319, 20);
		getContentPane().add(txtresultado);
		txtresultado.setColumns(10);
		
		JLabel lblVigenere = new JLabel("CIFRADO VIGENERE");
		lblVigenere.setForeground(Color.RED);
		lblVigenere.setBackground(Color.WHITE);
		lblVigenere.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVigenere.setHorizontalAlignment(SwingConstants.CENTER);
		lblVigenere.setBounds(124, 24, 191, 25);
		getContentPane().add(lblVigenere);
		
		JLabel lblTextoClaro = new JLabel("INTRODUZCA EL TEXTO");
		lblTextoClaro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTextoClaro.setBounds(155, 59, 134, 15);
		getContentPane().add(lblTextoClaro);
		
		JLabel lblTextoCifrado = new JLabel("Resultado");
		lblTextoCifrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTextoCifrado.setBounds(65, 155, 103, 23);
		getContentPane().add(lblTextoCifrado);
		
		txtclave = new JTextField();
		txtclave.setBounds(177, 127, 86, 20);
		getContentPane().add(txtclave);
		txtclave.setColumns(10);
		
		JLabel lblClave = new JLabel("CLAVE");
		lblClave.setBounds(122, 130, 46, 14);
		getContentPane().add(lblClave);
		
	}
}
