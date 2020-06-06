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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.Areas;
import model.Estacionamento;
import model.Eventos;

public class TelaEventos extends JInternalFrame {
	private JTextField textNome;
	private JFormattedTextField textData;
	private JTextField textDuracao;
	private JTextField textVagas;
	private JFormattedTextField formattedDate;
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
		Estacionamento estacionamento = Estacionamento.getInstancia();

		// Formato Data
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
		scrollPane.setBounds(39, 86, 523, 143);
		panelExibir.add(scrollPane);

		/* Criar tabela */
		tableCateg = new JTable();
		tableCateg.setBackground(Color.WHITE);
		tableCateg.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Data Início", "Duração (d)", "Vagas" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableCateg);

		JPanel panelCadastrar = new JPanel();
		panelCadastrar.setBackground(SystemColor.inactiveCaption);
		panelCadastrar.setBounds(0, 0, 800, 220);
		getContentPane().add(panelCadastrar);
		panelCadastrar.setLayout(null);

		JLabel lblNome = new JLabel("Evento: ");
		lblNome.setBounds(50, 33, 97, 25);
		panelCadastrar.add(lblNome);
		lblNome.setForeground(new Color(43, 52, 61));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));

		textNome = new JTextField();
		textNome.setBounds(157, 33, 233, 25);
		panelCadastrar.add(textNome);
		textNome.setToolTipText("");

		JLabel lblDuracao = new JLabel("Data de in\u00EDcio:");
		lblDuracao.setBounds(50, 79, 97, 23);
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
		lvlVagas.setBounds(50, 164, 107, 23);
		panelCadastrar.add(lvlVagas);
		lvlVagas.setForeground(new Color(43, 52, 61));
		lvlVagas.setFont(new Font("Tahoma", Font.BOLD, 14));

		textVagas = new JTextField();
		textVagas.setBounds(157, 162, 232, 25);
		panelCadastrar.add(textVagas);
		textVagas.setToolTipText("");

		JLabel label_3 = new JLabel("Dura\u00E7\u00E3o:");
		label_3.setBounds(50, 121, 97, 23);
		panelCadastrar.add(label_3);
		label_3.setForeground(new Color(43, 52, 61));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblCadastrarEvento = new JLabel("Cadastrar Evento");
		lblCadastrarEvento.setForeground(new Color(43, 52, 61));
		lblCadastrarEvento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastrarEvento.setBounds(10, 1, 144, 23);
		panelCadastrar.add(lblCadastrarEvento);

		JComboBox comboBoxEvento = new JComboBox();
		comboBoxEvento.setBounds(126, 45, 177, 23);
		panelExibir.add(comboBoxEvento);
		comboBoxEvento.addItem("");
		// com o cadastro de novos eventos, vai ser incluido no combobox.
		for (Eventos evento : estacionamento.getControleEventos()) {
			comboBoxEvento.addItem(evento.getNome());
		}

		JButton btnCadastrar = new JButton("Cadastrar Evento");
		btnCadastrar.setBounds(547, 79, 161, 44);
		panelCadastrar.add(btnCadastrar);
		btnCadastrar.setIcon(new ImageIcon(TelaEventos.class.getResource("../images/add.png")));

		// ação do botão cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarEvento(textNome.getText(), LocalDate.parse(textData.getText(), fmt),
						Integer.parseInt(textDuracao.getText()), Integer.parseInt(textVagas.getText()));
				comboBoxEvento.addItem(textNome.getText());
				textNome.setText("");
				textData.setText("");
				textDuracao.setText("");
				textVagas.setText("");
			}
		});

		JButton btnFechar = new JButton("Fechar");
		panelExibir.add(btnFechar);
		btnFechar.setIcon(new ImageIcon(TelaStatus.class.getResource("../images/close.png")));
		btnFechar.setBounds(686, 188, 104, 41);

		JLabel lblConsultarEvento = new JLabel("Consultar Evento");
		lblConsultarEvento.setForeground(new Color(43, 52, 61));
		lblConsultarEvento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarEvento.setBounds(10, 0, 144, 34);
		panelExibir.add(lblConsultarEvento);

		JLabel label = new JLabel("Evento: ");
		label.setForeground(new Color(43, 52, 61));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(39, 45, 97, 23);
		panelExibir.add(label);

		/* Insere valores na tabela */
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel table = (DefaultTableModel) tableCateg.getModel();
				Object[] rowData = new Object[4];
				Eventos evento = estacionamento.consultarEventoNome(comboBoxEvento.getSelectedItem().toString());
				if (evento != null) {
					rowData[0] = evento.getNome();
					rowData[1] = fmt.format(evento.getDataInicio());
					rowData[2] = evento.getDuracao();
					rowData[3] = evento.getVagas();
					table.addRow(rowData);
				} else {
					JOptionPane.showMessageDialog(null, "Evento não cadastrado!");
				}
			}

		});

		btnConsultar.setIcon(new ImageIcon(TelaEventos.class.getResource("/images/search.png")));
		btnConsultar.setBounds(329, 45, 110, 23);
		panelExibir.add(btnConsultar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxEvento.setSelectedItem("");
				tableCateg.setModel(
						new DefaultTableModel(null, new String[] { "Nome", "Data Início", "Duração (d)", "Vagas" }));
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaEventos.class.getResource("/images/erase.png")));
		btnLimpar.setBounds(456, 45, 104, 23);
		panelExibir.add(btnLimpar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
}
