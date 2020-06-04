package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.Estacionamento;
import model.Funcionario;
import model.Usuario;
import model.Veiculo;

import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class TelaFuncionario extends JInternalFrame {
	private JTextField textNome;
	private JTextField textSetor;
	private JFormattedTextField textCPF;
	private JFormattedTextField textCpfConsulta;
	private JTextPane textInfoProp;
	private JFormattedTextField textPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario frame = new TelaFuncionario();
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
	public TelaFuncionario() {
		Estacionamento estacionamento = Estacionamento.getInstancia();

		// Definir Máscaras
		MaskFormatter mascaraPlaca = null;
		MaskFormatter mascaraCpf = null;

		try {
			mascaraPlaca = new MaskFormatter("UUU-####");
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
		panelCadastro.setForeground(SystemColor.inactiveCaption);
		panelCadastro.setBorder(null);
		panelCadastro.setBounds(0, 0, 800, 214);
		getContentPane().add(panelCadastro);
		panelCadastro.setLayout(null);

		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(61, 82, 92, 32);
		panelCadastro.add(lblSetor);
		lblSetor.setForeground(new Color(43, 52, 61));
		lblSetor.setFont(new Font("Tahoma", Font.BOLD, 14));

		textSetor = new JTextField();
		textSetor.setBounds(139, 88, 230, 24);
		panelCadastro.add(textSetor);
		textSetor.setColumns(10);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(61, 125, 56, 32);
		panelCadastro.add(lblCPF);
		lblCPF.setForeground(new Color(43, 52, 61));
		lblCPF.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblTitulo = new JLabel("Cadastrar Funcion\u00E1rio - Acesso Estacionamento");
		lblTitulo.setBounds(23, 0, 350, 32);
		panelCadastro.add(lblTitulo);
		lblTitulo.setForeground(new Color(43, 52, 61));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblPermissao = new JLabel("Permiss\u00E3o:");
		lblPermissao.setBounds(409, 43, 92, 32);
		panelCadastro.add(lblPermissao);
		lblPermissao.setForeground(new Color(43, 52, 61));
		lblPermissao.setFont(new Font("Tahoma", Font.BOLD, 14));

		textNome = new JTextField();
		textNome.setBounds(139, 43, 230, 24);
		panelCadastro.add(textNome);
		textNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(61, 37, 92, 32);
		panelCadastro.add(lblNome);
		lblNome.setForeground(new Color(43, 52, 61));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));

		textCPF = new JFormattedTextField(mascaraCpf);
		textCPF.setBounds(140, 131, 230, 24);
		panelCadastro.add(textCPF);
		textCPF.setColumns(10);

		JComboBox<String> comboBoxPermissao = new JComboBox<String>();
		comboBoxPermissao.setBounds(502, 48, 230, 24);
		panelCadastro.add(comboBoxPermissao);
		comboBoxPermissao.addItem("");
		comboBoxPermissao.addItem("Professor");
		comboBoxPermissao.addItem("Palestrante");
		comboBoxPermissao.addItem("Funcionário");

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(new Color(43, 52, 61));
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlaca.setBounds(434, 82, 92, 32);
		panelCadastro.add(lblPlaca);

		textPlaca = new JFormattedTextField(mascaraPlaca);
		textPlaca.setColumns(10);
		textPlaca.setBounds(502, 88, 230, 24);
		panelCadastro.add(textPlaca);

		JButton btnCadastrar = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadastrar.setBounds(550, 142, 181, 48);
		btnCadastrar.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/images/confirm.png")));
		panelCadastro.add(btnCadastrar);
		btnCadastrar.setBackground(new Color(240, 240, 240));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa = "";
				Veiculo veiculo = estacionamento.validarVeiculo(textPlaca.getText());
				if (veiculo != null) {
					placa = textPlaca.getText();
					veiculo.setCategoria("Funcionário");
				} else {
					JOptionPane.showMessageDialog(null, "Veículo não Cadastrado!");
				}

				estacionamento.cadastrarFuncionario(textNome.getText(), textCPF.getText(), textSetor.getText(),
						comboBoxPermissao.getSelectedItem().toString(), placa);

				textNome.setText("");
				textCPF.setText("");
				comboBoxPermissao.setSelectedItem("");
				textSetor.setText("");
				textPlaca.setText("");

				System.out.println(estacionamento.getCadastroFuncionario());
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 250, 800, 243);

		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel labelTituloConsulta = new JLabel("Consultar Funcion\u00E1rio");
		labelTituloConsulta.setForeground(new Color(43, 52, 61));
		labelTituloConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTituloConsulta.setBounds(23, 5, 198, 32);
		panel.add(labelTituloConsulta);

		JLabel label = new JLabel("CPF:");
		label.setForeground(new Color(43, 52, 61));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(23, 36, 92, 32);
		panel.add(label);

		textCpfConsulta = new JFormattedTextField(mascaraCpf);
		textCpfConsulta.setColumns(10);
		textCpfConsulta.setBounds(113, 41, 168, 28);
		panel.add(textCpfConsulta);

		textInfoProp = new JTextPane();
		textInfoProp.setEditable(false);
		textInfoProp.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informa\u00E7\u00F5es Funcion\u00E1rio",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 102, 153)));
		textInfoProp.setBounds(24, 91, 405, 141);
		panel.add(textInfoProp);

		JTextPane textInfoVeic = new JTextPane();
		textInfoVeic.setEditable(false);
		textInfoVeic.setBorder(new TitledBorder(null, "Informa\u00E7\u00F5es Ve\u00EDculo", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 102, 153)));
		textInfoVeic.setBounds(464, 91, 174, 141);
		panel.add(textInfoVeic);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = estacionamento.consultarFuncionario(textCpfConsulta.getText());
				if (funcionario != null) {
					textInfoProp.setText(funcionario.toString());
				} else {
					textInfoProp.setText("Funcionário não cadastrado!");
				}
				Veiculo veiculo = estacionamento.validarVeiculo(funcionario.getPlaca());
				if (veiculo != null) {
					textInfoVeic.setText(veiculo.toString());
				} else {
					textInfoVeic.setText("Veículo não Cadastrado, procure o setor competente!");
				}
			}
		});

		btnConsultar.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/images/search.png")));
		btnConsultar.setBounds(307, 40, 110, 28);
		panel.add(btnConsultar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textInfoProp.setText("");
				textInfoVeic.setText("");
				textCpfConsulta.setText("");
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaFuncionario.class.getResource("/images/erase.png")));
		btnLimpar.setBounds(439, 40, 110, 28);
		panel.add(btnLimpar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(686, 191, 104, 41);
		panel.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(TelaStatus.class.getResource("/images/close.png")));

	}
}
