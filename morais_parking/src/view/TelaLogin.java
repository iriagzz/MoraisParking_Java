package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Estacionamento;
import model.Usuario;

import java.awt.Color;

public class TelaLogin extends JInternalFrame {
	private JTextField textUsuario;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		// Testes
		Estacionamento estacionamentoIesp = new Estacionamento();
		estacionamentoIesp.cadastrarUsuario("Funcionario RH", "Arthur", "voltas28", "Arthur Lacet", "10973236418",
				"Entrada");
		estacionamentoIesp.cadastrarUsuario("Funcionario Estacionamento", "Lucelia", "voltas17", "Arthur Lacet",
				"10973236418", "Entrada");
		estacionamentoIesp.cadastrarUsuario("Funcionario Estacionamento", "Guilherme", "maris2", "Arthur Lacet",
				"10973236418", "Entrada");
		estacionamentoIesp.cadastrarUsuario("Gestor", "Romulo", "farol", "Arthur Lacet", "10973236418", "Entrada");
		// Fim Testes

		setBorder(null);
		setBounds(260, 100, 450, 300);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(79, 51, 76, 29);
		panel.add(lblUsuario);

		JLabel label = new JLabel("");
		label.setBounds(85, 146, 46, 14);
		panel.add(label);

		textUsuario = new JTextField();
		textUsuario.setBounds(140, 52, 170, 29);
		panel.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblAviso = new JLabel("");
		lblAviso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(41, 208, 236, 26);
		panel.add(lblAviso);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(estacionamentoIesp.validarUsuario(textUsuario.getText()));

				if (estacionamentoIesp.login(textUsuario.getText(), new String(textSenha.getPassword()))) {
					lblAviso.setText("");
					dispose();

				} else {
					textUsuario.setText("");
					textSenha.setText("");
					lblAviso.setText("Usuário ou senha inválidos!");
				}
			}
		});

		btnLogin.setBounds(179, 148, 98, 26);
		panel.add(btnLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(79, 92, 76, 29);
		panel.add(lblSenha);

		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textSenha.setBounds(140, 92, 170, 29);
		panel.add(textSenha);

		JButton button = new JButton("Fechar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/close.png")));
		button.setBounds(342, 227, 98, 35);
		panel.add(button);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/user.png")));
		label_1.setBounds(41, 51, 46, 29);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/lock.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(41, 91, 46, 29);
		panel.add(label_2);
	}
}
