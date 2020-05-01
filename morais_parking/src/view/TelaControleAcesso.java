package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.Estacionamento;
import model.Memoria;
import model.Relatorios;
import model.Veiculo;

public class TelaControleAcesso extends JInternalFrame {
	private Memoria memoria = new Memoria();
	private Estacionamento estacionamento = memoria.getEstacionamento();

	public static void main(String[] args) {
		Memoria memoria = new Memoria();
		Estacionamento estacionamento = memoria.getEstacionamento();
		Relatorios relatorio = memoria.getRelatorios();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaControleAcesso frame = new TelaControleAcesso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaControleAcesso() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		

		// VEICULOS
		estacionamento.cadastrarVeiculo("Iria Guazzi", "20192007043","SI", "QFX-9310", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes","20192007043","SI", "OXX-4455", "Ford K", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Motô do Dominó","N/A","N/A", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo","N/A","N/A", "OFH-8830", "Ford KA", "CARRO");

		// AREAS
		estacionamento.cadastrarArea("Carros", 5, "CARRO");
		estacionamento.cadastrarArea("Vans", 2, "VAN");
		estacionamento.cadastrarArea("Preferencial", 3, "PREFERENCIAL");
		estacionamento.cadastrarArea("Motocicletas", 3, "MOTO");
		estacionamento.cadastrarArea("Ônibus", 3, "ONIBUS");

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
				.addComponent(panelGerenciar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelConsultar, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addComponent(panelGerenciar, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)));
		panelGerenciar.setLayout(null);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(TelaControleAcesso.class.getResource("/images/close.png")));
		btnFechar.setBounds(686, 175, 104, 41);
		panelGerenciar.add(btnFechar);

		JLabel lblMonitoramento = new JLabel("Monitoramento");
		lblMonitoramento.setForeground(new Color(43, 52, 67));
		lblMonitoramento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMonitoramento.setBounds(10, 21, 139, 37);
		panelGerenciar.add(lblMonitoramento);

		JProgressBar progressBarOcupacao = new JProgressBar();
		progressBarOcupacao.setForeground(new Color(43, 52, 67));
		progressBarOcupacao.setStringPainted(true);
		progressBarOcupacao.setBounds(257, 110, 276, 31);
		panelGerenciar.add(progressBarOcupacao);
		JComboBox comboBoxArea = new JComboBox();
		comboBoxArea.setBounds(20, 110, 186, 31);
		panelGerenciar.add(comboBoxArea);
		
		// caso o gestor inclua nova área, essa já será inserida no combobox do veículo
		comboBoxArea.addItem("");
		for (String categoria : estacionamento.getCategorias()) {
			comboBoxArea.addItem(categoria);
		}

		//Quando selecionar o comboBox, o progresso já atualiza a depender da área selecionada
		comboBoxArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBarOcupacao.setValue(estacionamento.ocupacaoAreas(comboBoxArea.getSelectedItem().toString()));
			}
		});

		JLabel lblArea = new JLabel("\u00C1rea");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setForeground(new Color(43, 52, 61));
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArea.setBounds(20, 69, 186, 37);
		panelGerenciar.add(lblArea);

		JLabel lblOcupacao = new JLabel("Ocupa\u00E7\u00E3o");
		lblOcupacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacao.setForeground(new Color(43, 52, 61));
		lblOcupacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOcupacao.setBounds(257, 69, 276, 37);
		panelGerenciar.add(lblOcupacao);
		panelConsultar.setLayout(null);

		JLabel lblEntradaVeiculo = new JLabel("Controle de Acesso");
		lblEntradaVeiculo.setForeground(new Color(43, 52, 67));
		lblEntradaVeiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntradaVeiculo.setBounds(10, 11, 139, 37);
		panelConsultar.add(lblEntradaVeiculo);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(new Color(43, 52, 61));
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlaca.setBounds(106, 71, 48, 37);
		panelConsultar.add(lblPlaca);

		JLabel lblData = new JLabel("data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(new Color(43, 52, 67));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(170, 11, 236, 37);
		panelConsultar.add(lblData);
		LocalDate data = LocalDate.now();
		lblData.setText(fmt.format(data));
	
		JTextField textPlaca = new JTextField();
		textPlaca.setToolTipText("");
		textPlaca.setBounds(150, 76, 129, 30);
		panelConsultar.add(textPlaca);

		JTextPane textResulBusca = new JTextPane();
		textResulBusca.setBounds(542, 23, 210, 111);
		panelConsultar.add(textResulBusca);
		textResulBusca.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados do Ve\u00EDculo",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 102)));
		textResulBusca.setEditable(false);

		JTextPane textArea = new JTextPane();
		textArea.setBounds(542, 160, 210, 53);
		panelConsultar.add(textArea);
		textArea.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u00C1rea de Estacionamento",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25, 112)));

		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(294, 80, 89, 23);
		getContentPane().setLayout(groupLayout);
		panelConsultar.add(btnVerificar);
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Veiculo veiculo = estacionamento.validarVeiculo(textPlaca.getText());
				if (veiculo != null) {
					textResulBusca.setText(veiculo.toString());
					comboBoxArea.setSelectedItem(veiculo.getCategoria());
				} else {
					textResulBusca.setText("Veículo não Localizado!");
				}
				textArea.setText(veiculo.getCategoria());
			}
		});

		JButton btnRegistrarEntrada = new JButton("Registrar Entrada");
		btnRegistrarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.validarEntrada(textPlaca.getText());
				LocalDate dateNow = LocalDate.now();
				estacionamento.relatorioVeiculosEntradas(dateNow, estacionamento.validarVeiculo(textPlaca.getText()));
				comboBoxArea.setSelectedItem(textArea.getText());
				textPlaca.setText("");
				textResulBusca.setText("");
				textArea.setText("");
			}
		});

		btnRegistrarEntrada.setIcon(new ImageIcon(TelaControleAcesso.class.getResource("/images/up-arrow.png")));
		btnRegistrarEntrada.setBounds(54, 134, 168, 44);
		panelConsultar.add(btnRegistrarEntrada);

		JButton btnRegistrarSaida = new JButton("Registrar Sa\u00EDda");
		btnRegistrarSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.validarSaida(textPlaca.getText());
				comboBoxArea.setSelectedItem(textArea.getText());
				textPlaca.setText("");
				textResulBusca.setText("");
				textArea.setText("");

			}
		});

		btnRegistrarSaida.setIcon(new ImageIcon(TelaControleAcesso.class.getResource("/images/down-arrow.png")));
		btnRegistrarSaida.setBounds(263, 134, 168, 44);
		panelConsultar.add(btnRegistrarSaida);

	}
}
