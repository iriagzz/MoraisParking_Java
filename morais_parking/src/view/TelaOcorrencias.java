package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import model.Estacionamento;
import model.Memoria;
import model.Ocorrencias;
import model.Veiculo;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TelaOcorrencias {
	Memoria memoria = new Memoria();
	Estacionamento estacionamento = memoria.getEstacionamento();
	private JFrame frame;
	private JTextField textID;
	private JTextField textFatos;
	private JTextField textData;
	private JTextField textHora;
	private JTextField textVeículos;
	private JTextField textTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOcorrencias window = new TelaOcorrencias();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaOcorrencias() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// VEICULOS
		estacionamento.cadastrarVeiculo("Iria Guazzi","20192007043","SI", "QFX-9310", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes", "20192007043","SI", "OXX-4455", "Ford K", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Motô do Dominó","n/a","n/a", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo", "n/a","n/a","OFH-8830", "Ford KA", "CARRO");

		// AREAS
		estacionamento.cadastrarArea("Carros", 5, "CARRO");
		estacionamento.cadastrarArea("Vans", 2, "VAN");
		estacionamento.cadastrarArea("Preferencial", 3, "PREFERENCIAL");
		estacionamento.cadastrarArea("Motocicletas", 3, "MOTO");
		estacionamento.cadastrarArea("Ônibus", 3, "ONIBUS");
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		frame = new JFrame();
		frame.setBounds(100, 100, 950, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel Screem = new JPanel();
		Screem.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(Screem, BorderLayout.CENTER);
		Screem.setLayout(null);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 216, 110, 30);
		lblTipo.setForeground(new Color(43, 52, 61));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblTipo);

		textID = new JTextField();
		textID.setBounds(170, 177, 268, 30);
		textID.setToolTipText("");
		Screem.add(textID);

		JLabel lblVeculosEnvolvidos = new JLabel("N\u00FAmero de Ve\u00EDculos:");
		lblVeculosEnvolvidos.setBounds(10, 257, 150, 30);
		lblVeculosEnvolvidos.setForeground(new Color(43, 52, 61));
		lblVeculosEnvolvidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblVeculosEnvolvidos);

		textFatos = new JTextField();
		textFatos.setBounds(170, 382, 268, 120);
		textFatos.setToolTipText("");
		Screem.add(textFatos);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 298, 110, 30);
		lblData.setForeground(new Color(43, 52, 61));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblData);

		textData = new JTextField();
		textData.setBounds(170, 300, 268, 30);
		textData.setToolTipText("");
		Screem.add(textData);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 339, 110, 30);
		lblHora.setForeground(new Color(43, 52, 61));
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblHora);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(745, 518, 104, 41);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

			private void dispose() {
			}
		});
		Screem.add(btnFechar);

		textHora = new JTextField();
		textHora.setBounds(170, 341, 268, 30);
		textHora.setToolTipText("");
		Screem.add(textHora);

		JLabel lblOcorrencias = new JLabel("Ocorr\u00EAncias");
		lblOcorrencias.setBounds(331, 62, 192, 30);
		lblOcorrencias.setFont(new Font("Tahoma", Font.BOLD, 30));
		Screem.add(lblOcorrencias);

		JLabel lblDescrioDosFatos = new JLabel("Descri\u00E7\u00E3o dos Fatos:");
		lblDescrioDosFatos.setBounds(10, 425, 150, 30);
		lblDescrioDosFatos.setForeground(new Color(43, 52, 61));
		lblDescrioDosFatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblDescrioDosFatos);

		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 175, 150, 30);
		lblID.setForeground(new Color(43, 52, 61));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblID);

		textVeículos = new JTextField();
		textVeículos.setBounds(170, 259, 268, 30);
		textVeículos.setToolTipText("");
		Screem.add(textVeículos);

		textTipo = new JTextField();
		textTipo.setBounds(170, 218, 268, 30);
		textTipo.setToolTipText("");
		Screem.add(textTipo);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarOcorrencia(Integer.parseInt(textID.getText()), textTipo.getText(),
						Integer.parseInt(textVeículos.getText()), LocalDate.parse(textData.getText(), fmt),
						textHora.getText(), textFatos.getText());

				for (Ocorrencias ocorrencia : estacionamento.getCadastroOcorrencias()) {
					System.out.println(ocorrencia);
					System.out.println(ocorrencia.getVeiculosOcorrencia());
				}
			}
		});
		btnCadastrar.setBounds(245, 527, 89, 23);
		Screem.add(btnCadastrar);
	}
}