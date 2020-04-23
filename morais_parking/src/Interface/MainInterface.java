package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Model.CatOcorrencias;
import Model.CatUsuario;
import Model.CatVeiculos;
import Model.Estacionamento;
import Model.Proprietario;
import Model.Usuarios;

public class MainInterface {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		Estacionamento estacionamentoIesp = new Estacionamento();
		estacionamentoIesp.cadastrarUsuario(CatUsuario.FuncionarioEstacionamento, "Arthur", "voltas28", "Arthur Lacet",
				"10973236418", "Entrada");
		estacionamentoIesp.cadastrarUsuario(CatUsuario.FuncionarioEstacionamento, "Lucelia", "voltas17", "Arthur Lacet",
				"10973236418", "Entrada");
		estacionamentoIesp.cadastrarUsuario(CatUsuario.FuncionarioEstacionamento, "Guilherme", "maris2", "Arthur Lacet",
				"10973236418", "Entrada");
		estacionamentoIesp.cadastrarUsuario(CatUsuario.FuncionarioEstacionamento, "Romulo", "farol", "Arthur Lacet",
				"10973236418", "Entrada");

		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(54, 69, 46, 14);
		frame.getContentPane().add(lblUsuario);

		textUsuario = new JTextField();
		textUsuario.setBounds(154, 66, 178, 20);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(54, 113, 46, 14);
		frame.getContentPane().add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(154, 110, 178, 20);
		frame.getContentPane().add(txtSenha);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (estacionamentoIesp.login(textUsuario.getText(), new String(txtSenha.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Bem vindo");
				} else {

					JOptionPane.showMessageDialog(null, "Dados inválidos");
				}
			}

		});
		btnLogin.setBounds(154, 175, 89, 23);
		frame.getContentPane().add(btnLogin);

		JLabel lblMoraisParkingSystem = new JLabel("Morais Parking System");
		lblMoraisParkingSystem.setBounds(154, 21, 116, 30);
		frame.getContentPane().add(lblMoraisParkingSystem);
	}
	// public boolean checkLogin(String login, String senha) {
	// return login.equals("usuario") && senha.equals("123");
	// }

}
