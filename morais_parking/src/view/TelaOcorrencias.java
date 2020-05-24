package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

import model.Estacionamento;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class TelaOcorrencias extends JInternalFrame {
	private JTextField textNumeroDeVeiculos;
	private JComboBox comboBoxTipo;
	private JLabel textID;
	private JFormattedTextField textData;
	private JFormattedTextField textHora;
	private JTextPane textDescricaoDosFatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOcorrencias frame = new TelaOcorrencias();
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
	public TelaOcorrencias() {

		Estacionamento estacionamento = new Estacionamento();

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Definir Máscaras

		MaskFormatter mascaraData = null;
		MaskFormatter mascaraHora = null;

		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraHora = new MaskFormatter("##:##");

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}

		setBackground(SystemColor.inactiveCaption);
		setBounds(90, 10, 800, 520);
		getContentPane().setLayout(null);

		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setForeground(new Color(43, 52, 67));
		lblID.setBounds(47, 66, 82, 32);
		getContentPane().add(lblID);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(43, 52, 67));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(47, 109, 82, 32);
		getContentPane().add(lblTipo);

		JLabel lblNmeroDeVeiculos = new JLabel("Quantidade de Ve\u00EDculos:");
		lblNmeroDeVeiculos.setForeground(new Color(43, 52, 67));
		lblNmeroDeVeiculos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNmeroDeVeiculos.setBounds(47, 152, 185, 32);
		getContentPane().add(lblNmeroDeVeiculos);

		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(43, 52, 67));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(47, 195, 82, 32);
		getContentPane().add(lblData);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(new Color(43, 52, 67));
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHora.setBounds(47, 238, 82, 32);
		getContentPane().add(lblHora);

		JLabel lblDescricaoDosFatos = new JLabel("Descri\u00E7\u00E3o dos Fatos:");
		lblDescricaoDosFatos.setForeground(new Color(43, 52, 67));
		lblDescricaoDosFatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescricaoDosFatos.setBounds(47, 288, 142, 32);
		getContentPane().add(lblDescricaoDosFatos);
		textNumeroDeVeiculos = new JTextField();
		textNumeroDeVeiculos.setColumns(10);
		textNumeroDeVeiculos.setBounds(242, 152, 214, 24);
		getContentPane().add(textNumeroDeVeiculos);

		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(242, 109, 214, 24);
		comboBoxTipo.addItem("");

		// Adicionando itens ao combobox
		for (String tipo : estacionamento.getTipoOcorrencia()) {
			comboBoxTipo.addItem(tipo);
		}
		getContentPane().add(comboBoxTipo);

		textID = new JLabel();
		textID.setFont(new Font("Tahoma", Font.BOLD, 12));
		textID.setText(String.valueOf(estacionamento.getCadastroOcorrencias().size() + 1));
		textID.setBackground(Color.WHITE);
		textID.setForeground(new Color(43, 52, 67));
		textID.setBounds(242, 71, 198, 24);
		getContentPane().add(textID);

		textData = new JFormattedTextField(mascaraData);
		textData.setColumns(10);
		textData.setBounds(242, 195, 214, 24);
		getContentPane().add(textData);

		textHora = new JFormattedTextField(mascaraHora);
		textHora.setColumns(10);
		textHora.setBounds(242, 238, 214, 24);
		getContentPane().add(textHora);

		textDescricaoDosFatos = new JTextPane();
		textDescricaoDosFatos.setBounds(47, 321, 394, 106);
		getContentPane().add(textDescricaoDosFatos);

		JButton btnIncluirVeiculos = new JButton("Incluir Ve\u00EDculos");
		btnIncluirVeiculos.setIcon(new ImageIcon(TelaOcorrencias.class.getResource("/images/add.png")));
		btnIncluirVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarOcorrencia(Integer.parseInt(textID.getText()),
						comboBoxTipo.getSelectedItem().toString(), Integer.parseInt(textNumeroDeVeiculos.getText()),
						LocalDate.parse(textData.getText(), fmt), textHora.getText(), textDescricaoDosFatos.getText());
			}
		});
		btnIncluirVeiculos.setBounds(473, 321, 142, 46);
		getContentPane().add(btnIncluirVeiculos);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});
		btnFechar.setIcon(new ImageIcon(TelaStatus.class.getResource("/images/close.png")));
		btnFechar.setBounds(670, 438, 104, 41);
		getContentPane().add(btnFechar);

		JButton btnCadastrarOcorrencia = new JButton("Cadastrar");
		btnCadastrarOcorrencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textID.setText("");
				comboBoxTipo.setSelectedItem("");
				textNumeroDeVeiculos.setText("");
				textData.setText("");
				textHora.setText("");
				textDescricaoDosFatos.setText("");
			}
		});

		btnCadastrarOcorrencia.setIcon(new ImageIcon(TelaOcorrencias.class.getResource("/images/confirm.png")));
		btnCadastrarOcorrencia.setBounds(473, 382, 142, 45);
		getContentPane().add(btnCadastrarOcorrencia);

		JLabel lblCadastrarOcorrncia = new JLabel("Cadastrar Ocorr\u00EAncia");
		lblCadastrarOcorrncia.setForeground(new Color(43, 52, 67));
		lblCadastrarOcorrncia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrarOcorrncia.setBounds(47, 11, 293, 32);
		getContentPane().add(lblCadastrarOcorrncia);

	}
}
