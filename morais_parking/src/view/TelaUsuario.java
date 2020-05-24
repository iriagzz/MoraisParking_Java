package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import model.Estacionamento;
import model.Usuario;
import model.Veiculo;
import javax.swing.JFormattedTextField;

public class TelaUsuario extends JInternalFrame {
	private JTextField textMatricula;
	private JTextField textUsuario;
	private JTextField textNome;
	private JFormattedTextField textCPF;
	private JTextField textSetor;
	private JPasswordField textSenha;
	private JTextField textMatCon;
	private JComboBox comboBoxPermissao2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {

		Estacionamento estacionamento = new Estacionamento();

		// Testes

		estacionamento.cadastrarUsuario("Arthur Lacet", "10973236418", "165a", "Setor Pessoal", "Funcionario RH",
				"Arthur", "voltas28");
		estacionamento.cadastrarUsuario("Lucelia Lacet", "10973236418", "16878a", "Estacionamento",
				"Funcionario Estacionamento", "Lucelia", "voltas17");
		estacionamento.cadastrarUsuario("Iria Guazzi", "10973236418", "13548t", "Estacionamento", "Gestor", "Iria",
				"1234");

		// Fim Testes

		// Definir Máscaras
		MaskFormatter mascaraCpf = null;

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}

		setBorder(null);
		getContentPane().setBackground(new Color(43, 52, 61));
		setBounds(90, 10, 800, 520);
		getContentPane().setLayout(null);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(SystemColor.inactiveCaption);
		panelCadastro.setBounds(0, 0, 800, 215);
		getContentPane().add(panelCadastro);
		panelCadastro.setLayout(null);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(384, 76, 92, 24);
		panelCadastro.add(lblUsuario);
		lblUsuario.setForeground(new Color(43, 52, 61));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));

		textMatricula = new JTextField();
		textMatricula.setBounds(112, 88, 198, 25);
		panelCadastro.add(textMatricula);
		textMatricula.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(384, 115, 92, 22);
		panelCadastro.add(lblSenha);
		lblSenha.setForeground(new Color(43, 52, 61));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblMatricula = new JLabel("Matr\u00EDcula:");
		lblMatricula.setBounds(20, 88, 92, 24);
		panelCadastro.add(lblMatricula);
		lblMatricula.setForeground(new Color(43, 52, 61));
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 51, 92, 25);
		panelCadastro.add(lblNome);
		lblNome.setForeground(new Color(43, 52, 61));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(20, 124, 92, 25);
		panelCadastro.add(lblCPF);
		lblCPF.setForeground(new Color(43, 52, 61));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(384, 40, 92, 25);
		panelCadastro.add(lblSetor);
		lblSetor.setForeground(new Color(43, 52, 61));
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblPermissoes = new JLabel("Fun\u00E7\u00E3o:");
		lblPermissoes.setBounds(20, 160, 92, 25);
		panelCadastro.add(lblPermissoes);
		lblPermissoes.setForeground(new Color(43, 52, 61));
		lblPermissoes.setFont(new Font("Tahoma", Font.BOLD, 14));

		textUsuario = new JTextField();
		textUsuario.setBounds(476, 75, 198, 25);
		panelCadastro.add(textUsuario);
		textUsuario.setColumns(10);

		textNome = new JTextField();
		textNome.setBounds(112, 51, 198, 25);
		panelCadastro.add(textNome);
		textNome.setColumns(10);

		textCPF = new JFormattedTextField(mascaraCpf);
		textCPF.setBounds(112, 126, 198, 25);
		panelCadastro.add(textCPF);
		textCPF.setColumns(10);

		textSetor = new JTextField();
		textSetor.setBounds(476, 39, 198, 25);
		panelCadastro.add(textSetor);
		textSetor.setColumns(10);

		JComboBox comboBoxPermissao = new JComboBox();
		comboBoxPermissao.setBounds(112, 162, 198, 25);
		panelCadastro.add(comboBoxPermissao);
		comboBoxPermissao.addItem("");
		comboBoxPermissao.addItem("Funcionario Estacionamento");
		comboBoxPermissao.addItem("Funcionario RH");
		comboBoxPermissao.addItem("Gestor");

		JButton btnCadastrarUsuario = new JButton("Cadastrar Usu\u00E1rio");
		btnCadastrarUsuario.setIcon(new ImageIcon(TelaUsuario.class.getResource("/images/confirm.png")));
		btnCadastrarUsuario.setBounds(497, 149, 160, 50);
		panelCadastro.add(btnCadastrarUsuario);

		textSenha = new JPasswordField();
		textSenha.setBounds(476, 113, 198, 25);
		panelCadastro.add(textSenha);

		JLabel lblCadastrarUsurio = new JLabel("Cadastrar Usu\u00E1rio");
		lblCadastrarUsurio.setForeground(new Color(43, 52, 61));
		lblCadastrarUsurio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrarUsurio.setBounds(20, 11, 198, 25);
		panelCadastro.add(lblCadastrarUsurio);
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarUsuario(textNome.getText(), textCPF.getText(), textMatricula.getText(),
						textSetor.getText(), comboBoxPermissao.getSelectedItem().toString(), textUsuario.getText(),
						new String(textSenha.getPassword()));

				textUsuario.setText("");
				textSenha.setText("");
				textNome.setText("");
				textMatricula.setText("");
				textCPF.setText("");
				textSetor.setText("");

				System.out.println(estacionamento.getCadastroUsuario());
			}
		});

		JPanel panelConsulta = new JPanel();
		panelConsulta.setBackground(SystemColor.activeCaption);
		panelConsulta.setBounds(0, 249, 800, 244);
		getContentPane().add(panelConsulta);
		panelConsulta.setLayout(null);

		JLabel lblControleUsurio = new JLabel("Controle Usu\u00E1rio");
		lblControleUsurio.setForeground(new Color(43, 52, 61));
		lblControleUsurio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblControleUsurio.setBounds(24, 11, 198, 25);
		panelConsulta.add(lblControleUsurio);

		JLabel label = new JLabel("Matr\u00EDcula:");
		label.setForeground(new Color(43, 52, 61));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(24, 46, 92, 24);
		panelConsulta.add(label);

		textMatCon = new JTextField();
		textMatCon.setColumns(10);
		textMatCon.setBounds(106, 47, 104, 25);
		panelConsulta.add(textMatCon);

		JTextPane textInfoUser = new JTextPane();
		textInfoUser.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Usu\u00E1rio", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 102, 153)));
		textInfoUser.setEditable(false);
		textInfoUser.setBounds(24, 100, 332, 117);
		panelConsulta.add(textInfoUser);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario user = estacionamento.validarMatricula(textMatCon.getText());
				if (user != null) {
					textInfoUser.setText(user.toString());
				} else {
					textInfoUser.setText("Usuário inválido!");
				}
			}
		});
		btnConsultar.setIcon(new ImageIcon(TelaUsuario.class.getResource("/images/search.png")));
		btnConsultar.setBounds(232, 26, 120, 25);
		panelConsulta.add(btnConsultar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMatCon.setText("");
				textInfoUser.setText("");
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaUsuario.class.getResource("/images/erase.png")));
		btnLimpar.setBounds(232, 62, 120, 25);
		panelConsulta.add(btnLimpar);

		JButton btnRemover = new JButton("Remover Usu\u00E1rio");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.removerUsuario(estacionamento.validarMatricula(textMatCon.getText()));
				textMatCon.setText("");
				textInfoUser.setText("");
			}
		});
		btnRemover.setIcon(new ImageIcon(TelaUsuario.class.getResource("/images/remove.png")));
		btnRemover.setBounds(614, 46, 154, 25);
		panelConsulta.add(btnRemover);

		JLabel lblEditarPermissao = new JLabel("Editar Permiss\u00E3o");
		lblEditarPermissao.setForeground(new Color(43, 52, 61));
		lblEditarPermissao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditarPermissao.setBounds(388, 115, 198, 25);
		panelConsulta.add(lblEditarPermissao);
		lblEditarPermissao.setVisible(false);

		comboBoxPermissao2 = new JComboBox();
		comboBoxPermissao2.setBounds(388, 140, 232, 25);
		comboBoxPermissao2.addItem("Funcionario Estacionamento");
		comboBoxPermissao2.addItem("Funcionario RH");
		comboBoxPermissao2.addItem("Gestor");
		panelConsulta.add(comboBoxPermissao2);
		comboBoxPermissao2.setVisible(false);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.editarFuncao(textMatCon.getText(), comboBoxPermissao2.getSelectedItem().toString());
				textMatCon.setText("");
				textInfoUser.setText("");
				lblEditarPermissao.setVisible(false);
				comboBoxPermissao2.setVisible(false);
				btnConfirmar.setVisible(false);
			}
		});
		btnConfirmar.setIcon(new ImageIcon(TelaUsuario.class.getResource("/images/confirm.png")));
		btnConfirmar.setBounds(445, 176, 141, 25);
		panelConsulta.add(btnConfirmar);
		btnConfirmar.setVisible(false);

		JButton btnEditarPermissao = new JButton("Editar Permiss\u00E3o");
		btnEditarPermissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblEditarPermissao.setVisible(true);
				btnConfirmar.setVisible(true);
				comboBoxPermissao2.setVisible(true);
			}
		});
		btnEditarPermissao.setIcon(new ImageIcon(TelaUsuario.class.getResource("/images/edit.png")));
		btnEditarPermissao.setBounds(432, 46, 154, 25);
		panelConsulta.add(btnEditarPermissao);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(686, 192, 104, 41);
		panelConsulta.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/close.png")));

	}
}
