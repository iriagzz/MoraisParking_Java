package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.Estacionamento;
import model.Memoria;
import model.Veiculo;

public class TelaVeiculos extends JInternalFrame {
	private Memoria memoria = new Memoria();
	private Estacionamento estacionamento = memoria.getEstacionamento();
	private JTextField textProprietario;
	private JTextField textPlacaCad;
	private JTextField textModelo;

	public static void main(String[] args) {
		Memoria memoria = new Memoria();
		Estacionamento estacionamento = memoria.getEstacionamento();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVeiculos frame = new TelaVeiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public TelaVeiculos() {
		// VEICULOS
		estacionamento.cadastrarVeiculo("Iria Guazzi", "QFX-9310", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes", "OXX-4455", "Ford K", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Motô do Dominó", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo", "OFH-8830", "Ford KA", "CARRO");

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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelGerenciar, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelConsultar, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelGerenciar, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelGerenciar.setLayout(null);

		JLabel lblTitular = new JLabel("Propriet\u00E1rio:");
		lblTitular.setForeground(new Color(43, 52, 61));
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitular.setBounds(10, 48, 110, 30);
		panelGerenciar.add(lblTitular);

		textProprietario = new JTextField();
		textProprietario.setToolTipText("");
		textProprietario.setBounds(130, 48, 268, 30);
		panelGerenciar.add(textProprietario);

		JLabel lblPlacaCad = new JLabel("Placa: ");
		lblPlacaCad.setForeground(new Color(43, 52, 61));
		lblPlacaCad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlacaCad.setBounds(10, 99, 110, 30);
		panelGerenciar.add(lblPlacaCad);

		textPlacaCad = new JTextField();
		textPlacaCad.setToolTipText("");
		textPlacaCad.setBounds(130, 99, 268, 30);
		panelGerenciar.add(textPlacaCad);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(43, 52, 61));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(10, 153, 110, 30);
		panelGerenciar.add(lblModelo);

		textModelo = new JTextField();
		textModelo.setToolTipText("");
		textModelo.setBounds(130, 153, 268, 30);
		panelGerenciar.add(textModelo);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(new Color(43, 52, 61));
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(10, 207, 110, 30);
		panelGerenciar.add(lblCategoria);

		JComboBox comboBoxCateg = new JComboBox();

		// caso o gestor inclua nova área, essa já será inserida no combobox do veículo
		for (String categoria : estacionamento.getCategorias()) {
			comboBoxCateg.addItem(categoria);
		}

		comboBoxCateg.setBounds(130, 207, 268, 30);
		panelGerenciar.add(comboBoxCateg);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/close.png")));
		btnFechar.setBounds(686, 232, 104, 41);
		panelGerenciar.add(btnFechar);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar Ve\u00EDculo");
		btnCadastrarVeiculo.setBounds(529, 107, 168, 44);
		panelGerenciar.add(btnCadastrarVeiculo);
		btnCadastrarVeiculo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarVeiculo(textProprietario.getText(), textPlacaCad.getText(),
						textModelo.getText(), comboBoxCateg.getSelectedItem().toString());
				textProprietario.setText("");
				textPlacaCad.setText("");
				textModelo.setText("");
			}
		});

		btnCadastrarVeiculo.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/add.png")));
		panelConsultar.setLayout(null);

		JLabel lblConsultarVeiculo = new JLabel("Consultar Ve\u00EDculo");
		lblConsultarVeiculo.setForeground(new Color(43, 52, 67));
		lblConsultarVeiculo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultarVeiculo.setBounds(10, 11, 139, 37);
		panelConsultar.add(lblConsultarVeiculo);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(new Color(43, 52, 61));
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlaca.setBounds(10, 59, 48, 37);
		panelConsultar.add(lblPlaca);

		JTextField textPlaca = new JTextField();
		textPlaca.setToolTipText("");
		textPlaca.setBounds(54, 64, 129, 30);
		panelConsultar.add(textPlaca);

		JTextPane textResulBusca = new JTextPane();
		textResulBusca.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultado Consulta",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 102)));
		textResulBusca.setEditable(false);
		textResulBusca.setBounds(220, 30, 210, 132);
		panelConsultar.add(textResulBusca);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/search.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Veiculo veiculo = estacionamento.validarVeiculo(textPlaca.getText());
				if (veiculo != null) {
					textResulBusca.setText(veiculo.toString());
				} else {
					textResulBusca.setText("Veículo não Localizado!");

				}
			}
		});
		btnBuscar.setBounds(64, 105, 109, 23);
		panelConsultar.add(btnBuscar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/erase.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPlaca.setText("");
				textResulBusca.setText("");
			}
		});
		btnLimpar.setBounds(64, 139, 109, 23);
		panelConsultar.add(btnLimpar);

		JButton btnRemoverVeiculo = new JButton("Remover Ve\u00EDculo");
		btnRemoverVeiculo.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/remove.png")));
		btnRemoverVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Veiculo veiculo = estacionamento.validarVeiculo(textPlaca.getText());
				if (veiculo != null) {
					estacionamento.removerVeiculo(veiculo);
					textPlaca.setText("");
					textResulBusca.setText("");
				} else {
					textResulBusca.setText("Veículo não Localizado!");

				}

			}
		});
		btnRemoverVeiculo.setBounds(532, 72, 168, 44);
		panelConsultar.add(btnRemoverVeiculo);
		getContentPane().setLayout(groupLayout);

	}
}
