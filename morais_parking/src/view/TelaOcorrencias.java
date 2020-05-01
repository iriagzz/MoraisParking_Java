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
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
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
<<<<<<< HEAD

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

=======
		
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
		initialize();
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
<<<<<<< HEAD

		frame = new JFrame();
		frame.setBounds(100, 100, 950, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

=======
		
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JPanel Screem = new JPanel();
		Screem.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(Screem, BorderLayout.CENTER);
		Screem.setLayout(null);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 216, 110, 30);
		lblTipo.setForeground(new Color(43, 52, 61));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblTipo);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		textID = new JTextField();
		textID.setBounds(170, 177, 268, 30);
		textID.setToolTipText("");
		Screem.add(textID);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblVeculosEnvolvidos = new JLabel("N\u00FAmero de Ve\u00EDculos:");
		lblVeculosEnvolvidos.setBounds(10, 257, 150, 30);
		lblVeculosEnvolvidos.setForeground(new Color(43, 52, 61));
		lblVeculosEnvolvidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblVeculosEnvolvidos);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		textFatos = new JTextField();
		textFatos.setBounds(170, 382, 268, 120);
		textFatos.setToolTipText("");
		Screem.add(textFatos);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 298, 110, 30);
		lblData.setForeground(new Color(43, 52, 61));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblData);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		textData = new JTextField();
		textData.setBounds(170, 300, 268, 30);
		textData.setToolTipText("");
		Screem.add(textData);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 339, 110, 30);
		lblHora.setForeground(new Color(43, 52, 61));
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblHora);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(745, 518, 104, 41);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
<<<<<<< HEAD

=======
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
			private void dispose() {
			}
		});
		Screem.add(btnFechar);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		textHora = new JTextField();
		textHora.setBounds(170, 341, 268, 30);
		textHora.setToolTipText("");
		Screem.add(textHora);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblOcorrencias = new JLabel("Ocorr\u00EAncias");
		lblOcorrencias.setBounds(331, 62, 192, 30);
		lblOcorrencias.setFont(new Font("Tahoma", Font.BOLD, 30));
		Screem.add(lblOcorrencias);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblDescrioDosFatos = new JLabel("Descri\u00E7\u00E3o dos Fatos:");
		lblDescrioDosFatos.setBounds(10, 425, 150, 30);
		lblDescrioDosFatos.setForeground(new Color(43, 52, 61));
		lblDescrioDosFatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblDescrioDosFatos);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(10, 175, 150, 30);
		lblID.setForeground(new Color(43, 52, 61));
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		Screem.add(lblID);
<<<<<<< HEAD

=======
		
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		textVeículos = new JTextField();
		textVeículos.setBounds(170, 259, 268, 30);
		textVeículos.setToolTipText("");
		Screem.add(textVeículos);
<<<<<<< HEAD

=======
		
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
		textTipo = new JTextField();
		textTipo.setBounds(170, 218, 268, 30);
		textTipo.setToolTipText("");
		Screem.add(textTipo);
<<<<<<< HEAD

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarOcorrencia(Integer.parseInt(textID.getText()), textTipo.getText(),
						Integer.parseInt(textVeículos.getText()), LocalDate.parse(textData.getText(), fmt),
						textHora.getText(), textFatos.getText());

				for (Ocorrencias ocorrencia : estacionamento.getCadastroOcorrencias()) {
=======
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarOcorrencia(Integer.parseInt(textID.getText()), textTipo.getText(), 
						Integer.parseInt(textVeículos.getText()), LocalDate.parse(textData.getText(),fmt), textHora.getText(), textFatos.getText());
				
				for (Ocorrencias ocorrencia: estacionamento.getCadastroOcorrencias()) {
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
					System.out.println(ocorrencia);
					System.out.println(ocorrencia.getVeiculosOcorrencia());
				}
			}
		});
		btnCadastrar.setBounds(245, 527, 89, 23);
		Screem.add(btnCadastrar);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 88e7b299fe131e704fa0e1e2a74065e772cf5b04
