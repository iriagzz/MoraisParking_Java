package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import model.Estacionamento;
import model.Memoria;

public class Principal extends javax.swing.JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {

		getContentPane().setBackground(SystemColor.window);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(43, 52, 67));
		desktopPane.setBorder(null);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JLabel labelBG = new JLabel("");
		labelBG.setIcon(new ImageIcon(Principal.class.getResource("/images/parkingbg.jpg")));
		labelBG.setBounds(-63, -105, 606, 673);
		desktopPane.add(labelBG);

		JLabel lblSystem = new JLabel("Morais' Parking System");
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setForeground(SystemColor.activeCaption);
		lblSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSystem.setBounds(599, 92, 319, 64);
		desktopPane.add(lblSystem);

		// Data e Hora
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		JLabel lblTime = new JLabel("Hora");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(SystemColor.activeCaption);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setBounds(599, 177, 319, 64);
		desktopPane.add(lblTime);
		
		// para que a hora fique atualizando
		ActionListener updateClockAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = new Date();
				lblTime.setText(sdf.format(data));
			}
		};
		Timer t = new Timer(100, updateClockAction);
		t.start();

		// Abre a tela de Login (todos os botoes estarão desativados atens do login)
		JButton btnAcesso = new JButton("Acessar o Sistema");
		btnAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin tela = new TelaLogin();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		btnAcesso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAcesso.setBounds(643, 319, 231, 56);
		desktopPane.add(btnAcesso);

		setVisible(true);
		setMaximumSize(new Dimension(0, 0));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setName("MainFrame");
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 960, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnEstacionamento = new JMenu("Estacionamento");
		mnEstacionamento.setIcon(new ImageIcon(Principal.class.getResource("/images/parking.png")));
		mnEstacionamento.setMnemonic('E');
		mnEstacionamento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnEstacionamento);

		// Abre a tela Veículos
		JMenuItem mntmVeiculos = new JMenuItem("Ve\u00EDculos");
		mntmVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVeiculos tela = new TelaVeiculos();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});

		mntmVeiculos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEstacionamento.add(mntmVeiculos);

		// Abre a tela de Controle de Acesso
		JMenuItem mntmControleAcesso = new JMenuItem("Controle de Acesso");
		mntmControleAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaControleAcesso tela = new TelaControleAcesso();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmControleAcesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEstacionamento.add(mntmControleAcesso);

		// Abre a tela de Status
		JMenuItem mntmStatus = new JMenuItem("Status");
		mntmStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaStatus tela = new TelaStatus();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmStatus.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEstacionamento.add(mntmStatus);

		JMenu mnEventos = new JMenu("Eventos");
		mnEventos.setIcon(new ImageIcon(Principal.class.getResource("/images/events.png")));
		mnEventos.setMnemonic('V');
		mnEventos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnEventos);

		JMenuItem mntmGerenciarEventos = new JMenuItem("Gerenciar Eventos");
		mntmGerenciarEventos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEventos.add(mntmGerenciarEventos);

		JMenu mnOcorrencias = new JMenu("Ocorr\u00EAncias");
		mnOcorrencias.setIcon(new ImageIcon(Principal.class.getResource("/images/crash.png")));
		mnOcorrencias.setMnemonic('O');
		mnOcorrencias.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnOcorrencias);

		JMenuItem mntmGerenciarOcorrncias = new JMenuItem("Gerenciar Ocorr\u00EAncias");
		mntmGerenciarOcorrncias.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnOcorrencias.add(mntmGerenciarOcorrncias);

		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		mnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/images/reports.png")));
		mnRelatorios.setMnemonic('R');
		mnRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatorios);

		JMenu mnGerarRelatorios = new JMenu("Gerar Relat\u00F3rios");
		mnGerarRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRelatorios.add(mnGerarRelatorios);

		JMenuItem mntmRotatividade = new JMenuItem("Rotatividade");
		mntmRotatividade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGerarRelatorios.add(mntmRotatividade);

		JMenuItem mntmEventos = new JMenuItem("Eventos");
		mntmEventos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGerarRelatorios.add(mntmEventos);

		JMenuItem mntmOcorrencias = new JMenuItem("Ocorr\u00EAncias");
		mntmOcorrencias.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGerarRelatorios.add(mntmOcorrencias);

		JMenu mnGestor = new JMenu("Gestor");
		mnGestor.setIcon(new ImageIcon(Principal.class.getResource("/images/manager.png")));
		mnGestor.setMnemonic('G');
		mnGestor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGestor.setBackground(Color.DARK_GRAY);
		menuBar.add(mnGestor);

		JMenuItem mntmPermissoesAcesso = new JMenuItem("Permiss\u00F5es Acesso");
		mntmPermissoesAcesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGestor.add(mntmPermissoesAcesso);

		JSeparator separator = new JSeparator();
		mnGestor.add(separator);

		JMenuItem mntmareas = new JMenuItem("\u00C1reas do Estacionamento");
		mntmareas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGestor.add(mntmareas);
		setTitle("Morais' Parking System");
	}
}

//metodo habilita botao
/*
 * public void habilitaBotoes(boolean estado){ if metodoLogin() --> que deve
 * retornar um logins == "func ou gest ou funrh" botao.setEnabled(estado)
 *
 * }
 */