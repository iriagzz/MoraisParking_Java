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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.Estacionamento;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class TelaEventos extends JInternalFrame {
	private JTextField textNome;
	private JFormattedTextField textData;
	private JTextField textDuracao;
	private JTextField textVagas;
	private JFormattedTextField formattedDate;
	private JTextField textQuantVagas;
	private JTable tableCateg;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEventos frame = new TelaEventos();
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
	public TelaEventos() {

		Estacionamento estacionamento = new Estacionamento();

		// AREAS
		estacionamento.cadastrarArea("Carros", 5, "CARRO");
		estacionamento.cadastrarArea("Vans", 2, "VAN");
		estacionamento.cadastrarArea("Preferencial", 3, "PREFERENCIAL");
		estacionamento.cadastrarArea("Motocicletas", 3, "MOTO");
		estacionamento.cadastrarArea("Ônibus", 3, "ONIBUS");

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Definir Máscaras
		MaskFormatter mascaraData = null;

		try {
			mascaraData = new MaskFormatter("##/##/####");

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}

		setBorder(null);
		getContentPane().setBackground(new Color(43, 52, 61));
		setBounds(90, 10, 800, 520);
		getContentPane().setLayout(null);

		JPanel panelExibir = new JPanel();
		panelExibir.setBackground(SystemColor.activeCaption);
		panelExibir.setBounds(0, 253, 800, 240);
		getContentPane().add(panelExibir);
		panelExibir.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(51, 49, 429, 143);
		panelExibir.add(scrollPane);

		tableCateg = new JTable();
		tableCateg.setBackground(Color.WHITE);
		tableCateg.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Categoria", "Vagas" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableCateg);

		JButton btnFechar = new JButton("Fechar");
		panelExibir.add(btnFechar);
		btnFechar.setIcon(new ImageIcon(TelaStatus.class.getResource("/images/close.png")));
		btnFechar.setBounds(686, 188, 104, 41);

		JButton btnCadastrar = new JButton("Cadastrar Evento");
		btnCadastrar.setBounds(547, 95, 161, 44);
		panelExibir.add(btnCadastrar);
		btnCadastrar.setIcon(new ImageIcon(TelaEventos.class.getResource("/images/add.png")));

		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel panelCadastrar = new JPanel();
		panelCadastrar.setBackground(SystemColor.inactiveCaption);
		panelCadastrar.setBounds(0, 0, 800, 220);
		getContentPane().add(panelCadastrar);
		panelCadastrar.setLayout(null);

		JLabel lblNome = new JLabel("Evento: ");
		lblNome.setBounds(50, 35, 97, 17);
		panelCadastrar.add(lblNome);
		lblNome.setForeground(new Color(43, 52, 61));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));

		textNome = new JTextField();
		textNome.setBounds(157, 33, 233, 25);
		panelCadastrar.add(textNome);
		textNome.setToolTipText("");

		JLabel lblDuracao = new JLabel("Data de in\u00EDcio:");
		lblDuracao.setBounds(50, 79, 97, 17);
		panelCadastrar.add(lblDuracao);
		lblDuracao.setForeground(new Color(43, 52, 61));
		lblDuracao.setFont(new Font("Tahoma", Font.BOLD, 14));

		textData = new JFormattedTextField(mascaraData);
		textData.setBounds(157, 77, 233, 25);
		panelCadastrar.add(textData);
		textData.setToolTipText("");

		textDuracao = new JTextField();
		textDuracao.setBounds(157, 119, 233, 25);
		panelCadastrar.add(textDuracao);
		textDuracao.setToolTipText("");

		JLabel lvlVagas = new JLabel("Vagas totais:");
		lvlVagas.setBounds(50, 164, 107, 17);
		panelCadastrar.add(lvlVagas);
		lvlVagas.setForeground(new Color(43, 52, 61));
		lvlVagas.setFont(new Font("Tahoma", Font.BOLD, 14));

		textVagas = new JTextField();
		textVagas.setBounds(157, 162, 232, 25);
		panelCadastrar.add(textVagas);
		textVagas.setToolTipText("");

		JLabel label_3 = new JLabel("Dura\u00E7\u00E3o:");
		label_3.setBounds(50, 121, 97, 17);
		panelCadastrar.add(label_3);
		label_3.setForeground(new Color(43, 52, 61));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblSelecionarreas = new JLabel("Selecionar \u00C1reas");
		lblSelecionarreas.setBounds(487, 35, 144, 23);
		panelCadastrar.add(lblSelecionarreas);
		lblSelecionarreas.setForeground(new Color(43, 52, 61));
		lblSelecionarreas.setFont(new Font("Tahoma", Font.BOLD, 14));

		JComboBox comboBoxCateg = new JComboBox();
		comboBoxCateg.addItem("");

		// caso o gestor inclua nova área, essa já será inserida no combobox do veículo
		for (String categoria : estacionamento.getCategorias()) {
			comboBoxCateg.addItem(categoria);
		}

		comboBoxCateg.setBounds(487, 77, 233, 24);
		panelCadastrar.add(comboBoxCateg);

		textQuantVagas = new JTextField();
		textQuantVagas.setBounds(634, 119, 86, 25);
		panelCadastrar.add(textQuantVagas);
		textQuantVagas.setColumns(10);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel table = (DefaultTableModel) tableCateg.getModel();
				Object[] rowData = new Object[2];
				rowData[0] = comboBoxCateg.getSelectedItem().toString();
				rowData[1] = textQuantVagas.getText();
				table.addRow(rowData);
			}
		});
		btnIncluir.setBounds(631, 163, 89, 23);
		panelCadastrar.add(btnIncluir);

		JLabel labelQtdVagas = new JLabel("Vagas:");
		labelQtdVagas.setForeground(new Color(43, 52, 61));
		labelQtdVagas.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelQtdVagas.setBounds(563, 121, 70, 17);
		panelCadastrar.add(labelQtdVagas);
		

		// ação do botão cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				estacionamento.cadastrarEvento(textNome.getText(), LocalDate.parse(textData.getText(), fmt),
						Integer.parseInt(textDuracao.getText()), Integer.parseInt(textVagas.getText()));

				textNome.setText("");
				textData.setText("");
				textDuracao.setText("");
				textVagas.setText("");
				tableCateg.setModel(new DefaultTableModel(null, new String[] { "Categoria", "Vagas" }));
			}
		});

	}
}
