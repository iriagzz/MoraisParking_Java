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
import model.Eventos;
import model.Memoria;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TelaEventos {
	
	private Memoria memoria = new Memoria();
	private Estacionamento estacionamento = memoria.getEstacionamento();
	private JFrame frame;
	private JTextField textNome;
	private JTextField textData;
	private JTextField textDuracao;
	private JTextField textVagas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Memoria memoria = new Memoria();
		Estacionamento estacionamento = memoria.getEstacionamento();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEventos window = new TelaEventos();
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
	public TelaEventos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
				
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(43, 52, 61));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 175, 110, 30);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setToolTipText("");
		textNome.setBounds(130, 177, 268, 30);
		panel.add(textNome);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(new Color(43, 52, 61));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(10, 216, 110, 30);
		panel.add(lblData);
		
		textData = new JTextField();
		textData.setToolTipText("");
		textData.setBounds(130, 218, 268, 30);
		panel.add(textData);
		
		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o:");
		lblDuracao.setForeground(new Color(43, 52, 61));
		lblDuracao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuracao.setBounds(10, 257, 110, 30);
		panel.add(lblDuracao);
		
		textDuracao = new JTextField();
		textDuracao.setToolTipText("");
		textDuracao.setBounds(130, 259, 268, 30);
		panel.add(textDuracao);
		
		JLabel lblVagas = new JLabel("Vagas:");
		lblVagas.setForeground(new Color(43, 52, 61));
		lblVagas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVagas.setBounds(10, 298, 110, 30);
		panel.add(lblVagas);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
			private void dispose() {	
			}
			
		});
		btnFechar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/close.png")));
		btnFechar.setBounds(634, 382, 104, 41);
		panel.add(btnFechar);
		
		JButton btnCadastrarEvento = new JButton("Cadastrar Evento");
		btnCadastrarEvento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarEvento(textNome.getText(), LocalDate.parse(textData.getText(),fmt), Integer.parseInt(textDuracao.getText()), Integer.parseInt(textVagas.getText()));
					textNome.setText("");
					textData.setText("");
					textDuracao.setText("");
					textVagas.setText("");
				}
	
		});
		btnCadastrarEvento.setBounds(519, 235, 168, 44);
		panel.add(btnCadastrarEvento);
		
		textVagas = new JTextField();
		textVagas.setToolTipText("");
		textVagas.setBounds(130, 300, 268, 30);
		panel.add(textVagas);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEventos.setBounds(331, 62, 118, 30);
		panel.add(lblEventos);
	}
}
