package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Areas;
import model.Estacionamento;
import model.Proprietario;
import model.Relatorios;
import model.Veiculo;

public class TelaStatus extends JInternalFrame {
	private JTable tableRelStatus;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaStatus frame = new TelaStatus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaStatus() {
		Estacionamento estacionamento = Estacionamento.getInstancia();

		setBorder(null);
		getContentPane().setBackground(new Color(43, 52, 61));
		setBounds(90, 10, 800, 520);

		JPanel panelConsultar = new JPanel();
		panelConsultar.setBorder(null);
		panelConsultar.setBackground(SystemColor.inactiveCaption);

		JPanel panelGerenciar = new JPanel();
		panelGerenciar.setBackground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelConsultar, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
				.addComponent(panelGerenciar, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelConsultar, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addComponent(panelGerenciar, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)));
		panelGerenciar.setLayout(null);

		// Data
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(new Color(43, 52, 67));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(181, 11, 182, 37);
		LocalDate dataf = LocalDate.now();
		lblData.setText(fmt.format(dataf));
		panelConsultar.add(lblData);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(73, 24, 659, 197);
		panelGerenciar.add(scrollPane);

		//criar tabela
		tableRelStatus = new JTable();
		tableRelStatus.setBackground(Color.WHITE);
		tableRelStatus
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Data", "Placa", "Proprietario" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane.setViewportView(tableRelStatus);
		panelConsultar.setLayout(null);

		JComboBox comboBoxCateg = new JComboBox();
		comboBoxCateg.setBounds(130, 89, 268, 30);
		panelConsultar.add(comboBoxCateg);
		comboBoxCateg.addItem("");

		// caso o gestor inclua nova área, essa já será inserida no combobox do veículo
		for (Areas area : estacionamento.getControleAreas()) {
			comboBoxCateg.addItem(area.getCategoria());
		}

		JLabel lblConsultarArea = new JLabel("Consultar Status");
		lblConsultarArea.setForeground(new Color(43, 52, 67));
		lblConsultarArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarArea.setBounds(10, 11, 139, 37);
		panelConsultar.add(lblConsultarArea);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 89, 110, 30);
		panelConsultar.add(lblCategoria);
		lblCategoria.setForeground(new Color(43, 52, 61));
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));

		/* inserir dados na tabela */
		JButton btnGerarStatus = new JButton("Gerar");
		btnGerarStatus.setIcon(new ImageIcon(TelaStatus.class.getResource("../images/search.png")));
		btnGerarStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel table = (DefaultTableModel) tableRelStatus.getModel();
				LocalDate data = LocalDate.parse(lblData.getText(), fmt);
				Object[] rowData = new Object[3];
				for (Relatorios r : estacionamento.getRelatorioEntradas()) {
					if (r.getData().equals(data)
							&& r.getVeiculo().getCategoria().equals(comboBoxCateg.getSelectedItem().toString())) {
						rowData[0] = fmt.format(r.getData());
						rowData[1] = r.getVeiculo().getPlaca();
						rowData[2] = r.getVeiculo().getProprietario().getNome();
						table.addRow(rowData);
					}
				}
			}
		});

		btnGerarStatus.setBounds(468, 89, 110, 30);
		panelConsultar.add(btnGerarStatus);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaStatus.class.getResource("../images/erase.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxCateg.setSelectedItem("");
				tableRelStatus.setModel(new DefaultTableModel(null, new String[] { "Data", "Placa", "Proprietario" }));
			}
		});
		btnLimpar.setBounds(602, 89, 110, 30);
		panelConsultar.add(btnLimpar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(TelaStatus.class.getResource("../images/close.png")));
		btnFechar.setBounds(686, 232, 104, 41);
		panelGerenciar.add(btnFechar);

		getContentPane().setLayout(groupLayout);

	}
}
