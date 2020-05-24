package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Estacionamento;
import model.Memoria;

public class Login extends JFrame {
	private Memoria memoria = new Memoria();
	private Estacionamento estacionamento = memoria.getEstacionamento();

	private JTextField textUsuario;
	private JPasswordField textSenha;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		// Testes

		estacionamento.cadastrarUsuario("Arthur Lacet", "10973236418", "165a", "Setor Pessoal", "Funcionario RH", 
				"Arthur", "voltas28");
		estacionamento.cadastrarUsuario("Lucelia Lacet", "10973236418","16878a", "Estacionamento", "Funcionario Estacionamento",
				 "Lucelia", "voltas17");
		estacionamento.cadastrarUsuario("Iria Guazzi", "10973236418","13548t", "Estacionamento", "Gestor",  "Iria",
				"1234");

		// Fim Testes

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(114, 51, 76, 29);
		contentPane.add(lblUsuario);

		JLabel label = new JLabel("");
		label.setBounds(5, 256, 424, 0);
		contentPane.add(label);

		textUsuario = new JTextField();
		textUsuario.setBounds(175, 52, 170, 29);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		label_1.setBounds(76, 51, 46, 29);
		contentPane.add(label_1);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estacionamento.login(textUsuario.getText(), new String(textSenha.getPassword()))) {
					String funcao = estacionamento.retornarFuncao((textUsuario.getText()));
					Principal frm = new Principal(funcao);
					frm.setVisible(true);
					dispose();

				} else {
					textUsuario.setText("");
					textSenha.setText("");
					JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
				}
			}
		});

		btnLogin.setBounds(214, 148, 98, 26);
		contentPane.add(btnLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(114, 92, 76, 29);
		contentPane.add(lblSenha);

		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textSenha.setBounds(175, 92, 170, 29);
		contentPane.add(textSenha);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/images/lock.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(76, 92, 46, 29);
		contentPane.add(label_2);

		JLabel logo = new JLabel("New label");
		logo.setIcon(new ImageIcon(Login.class.getResource("/images/logo.png")));
		logo.setBounds(26, 188, 129, 62);
		contentPane.add(logo);

		JLabel lblMoraisParingSystem = new JLabel("Morais' Parking System \u00A9");
		lblMoraisParingSystem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMoraisParingSystem.setBounds(175, 223, 223, 14);
		contentPane.add(lblMoraisParingSystem);

	}

}
