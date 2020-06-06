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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Principal extends javax.swing.JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			private String funcao; //atributo funcao, que muda de acordo com o login do usuario (tela login)

			public void run() {
				try {
					Principal frame = new Principal(funcao);
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
	public Principal(String funcao) {

		getContentPane().setBackground(SystemColor.window);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(43, 52, 67));
		desktopPane.setBorder(null);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JLabel labelBG = new JLabel("");
		labelBG.setIcon(new ImageIcon(Principal.class.getResource("../images/parkingbg.jpg")));
		labelBG.setBounds(-63, -105, 606, 673);
		desktopPane.add(labelBG);

		JLabel lblSystem = new JLabel("Morais' Parking System");
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setForeground(SystemColor.activeCaption);
		lblSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSystem.setBounds(599, 168, 319, 64);
		desktopPane.add(lblSystem);

		// Formato Data e Hora
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		JLabel lblTime = new JLabel("Hora");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(SystemColor.activeCaption);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setBounds(599, 253, 319, 64);
		desktopPane.add(lblTime);

		/* para que a hora fique atualizando */
		ActionListener updateClockAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = new Date();
				lblTime.setText(sdf.format(data));
			}
		};
		Timer t = new Timer(100, updateClockAction);
		t.start();

		JLabel labelUsuario = new JLabel("New label");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setBounds(689, 520, 195, 14);
		desktopPane.add(labelUsuario);
		labelUsuario.setText(funcao);

		JLabel lblPermissoDeAcesso = new JLabel("Permiss\u00E3o de Acesso:");
		lblPermissoDeAcesso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermissoDeAcesso.setForeground(Color.WHITE);
		lblPermissoDeAcesso.setBounds(553, 520, 163, 14);
		desktopPane.add(lblPermissoDeAcesso);

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

		// Bot�o Estacionamento
		JMenu mnEstacionamento = new JMenu("Estacionamento");
		mnEstacionamento.setIcon(new ImageIcon(Principal.class.getResource("../images/parking.png")));
		mnEstacionamento.setMnemonic('E');
		mnEstacionamento.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnEstacionamento);
		
		// permiss�o de acesso
		if (funcao.equalsIgnoreCase("Funcionario RH")) {
			mnEstacionamento.setEnabled(false);
		} else {
			mnEstacionamento.setEnabled(true);
		}

		// Abre a tela Ve�culos
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

		// Bot�o Eventos
		JMenu mnEventos = new JMenu("Eventos");
		mnEventos.setIcon(new ImageIcon(Principal.class.getResource("../images/events.png")));
		mnEventos.setMnemonic('V');
		mnEventos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnEventos);
		
		// permiss�o de acesso
		if (funcao.equalsIgnoreCase("Funcionario RH")) {
			mnEventos.setEnabled(false);
		} else {
			mnEventos.setEnabled(true);
		}

		// Abre a tela Eventos
		JMenuItem mntmGerenciarEventos = new JMenuItem("Cadastrar");
		mntmGerenciarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEventos tela = new TelaEventos();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmGerenciarEventos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEventos.add(mntmGerenciarEventos);
		
		//Abre a tela de Reservar Area p Eventos
		JMenuItem mntmReservarrea = new JMenuItem("Reservar \u00C1rea");
		mntmReservarrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAreaEventos tela = new TelaAreaEventos();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmReservarrea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnEventos.add(mntmReservarrea);

		// Bot�o Ocorr�ncias
		JMenu mnOcorrencias = new JMenu("Ocorr\u00EAncias");
		mnOcorrencias.setIcon(new ImageIcon(Principal.class.getResource("../images/crash.png")));
		mnOcorrencias.setMnemonic('O');
		mnOcorrencias.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnOcorrencias);
		// permiss�o de acesso
		if (funcao.equalsIgnoreCase("Funcionario RH")) {
			mnOcorrencias.setEnabled(false);
		} else {
			mnOcorrencias.setEnabled(true);
		}
		// Abrir tela Ocorrencias
		JMenuItem mntmGerenciarOcorrncias = new JMenuItem("Cadastrar");
		mntmGerenciarOcorrncias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaOcorrencias tela = new TelaOcorrencias();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmGerenciarOcorrncias.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnOcorrencias.add(mntmGerenciarOcorrncias);

		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaOcorrencia tela = new TelaConsultaOcorrencia();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnOcorrencias.add(mntmConsultar);

		// Bot�o Relat�rios
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		mnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("../images/reports.png")));
		mnRelatorios.setMnemonic('R');
		mnRelatorios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatorios);
		// Permissao de Acesso
		if (funcao.equalsIgnoreCase("gestor")) {
			mnRelatorios.setEnabled(true);
		} else {
			mnRelatorios.setEnabled(false);
		}

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

		// Bot�oGestor
		JMenu mnGestor = new JMenu("Gestor");
		mnGestor.setIcon(new ImageIcon(Principal.class.getResource("../images/manager.png")));
		mnGestor.setMnemonic('G');
		mnGestor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGestor.setBackground(Color.DARK_GRAY);
		menuBar.add(mnGestor);
		// Permiss�o de acesso
		if (funcao.equalsIgnoreCase("gestor")) {
			mnGestor.setEnabled(true);
		} else {
			mnGestor.setEnabled(false);
		}

		JSeparator separator = new JSeparator();
		mnGestor.add(separator);

		//Botao Areas
		JMenuItem mntmareas = new JMenuItem("\u00C1reas do Estacionamento");
		mntmareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAreas tela = new TelaAreas();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmareas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGestor.add(mntmareas);

		JSeparator separator_1 = new JSeparator();
		mnGestor.add(separator_1);

		//Botao Cadastro Usuario
		JMenuItem mntmCadastroDeUsurios = new JMenuItem("Cadastro de Usu\u00E1rios");
		mntmCadastroDeUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaUsuario tela = new TelaUsuario();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mntmCadastroDeUsurios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGestor.add(mntmCadastroDeUsurios);

		// Bot�o RH
		JMenu mnRh = new JMenu("RH");
		mnRh.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnRh.setIcon(new ImageIcon(Principal.class.getResource("../images/profile.png")));
		mnRh.setMnemonic('h');
		menuBar.add(mnRh);
		// permiss�o de acesso
		if (funcao.equalsIgnoreCase("Funcionario RH")) {
			mnRh.setEnabled(true);
		} else {
			mnRh.setEnabled(false);
		}

		// Abrir tela Cadastrar Funcionario
		JMenuItem mntmCads = new JMenuItem("Cadastrar Funicion\u00E1rio");
		mntmCads.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario tela = new TelaFuncionario();
				desktopPane.add(tela);
				tela.setVisible(true);
			}
		});
		mnRh.add(mntmCads);
		
		//Botao Logout
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.setIcon(new ImageIcon(Principal.class.getResource("/images/exit2.png")));
		mnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnLogout);
		
		//Botao Troca Usuario
		JMenuItem mntmTrocarUsurio = new JMenuItem("Trocar Usu\u00E1rio");
		mntmTrocarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login frm = new Login();
				frm.setVisible(true);
				dispose();
			}
			
		});
		mntmTrocarUsurio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnLogout.add(mntmTrocarUsurio);
		setTitle("Morais' Parking System");
	}
}
