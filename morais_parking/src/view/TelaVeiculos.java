package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import model.Areas;
import model.Estacionamento;
import model.Veiculo;

public class TelaVeiculos extends JInternalFrame {

	private JTextField textProprietario;
	private JFormattedTextField textPlacaCad;
	private JTextField textModelo;
	private JTextField textMatricula;
	private JTextField textCurso;

	public static void main(String[] args) {

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

		Estacionamento estacionamento = Estacionamento.getInstancia();

		// Definir Máscaras
		MaskFormatter mascaraPlaca = null;

		try {
			mascaraPlaca = new MaskFormatter("UUU-####");

		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}

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
				.addComponent(panelConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(panelGerenciar, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelConsultar, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addGap(27)
						.addComponent(panelGerenciar, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panelGerenciar.setLayout(null);

		JLabel lblTitular = new JLabel("Propriet\u00E1rio:");
		lblTitular.setForeground(new Color(43, 52, 61));
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitular.setBounds(10, 25, 110, 30);
		panelGerenciar.add(lblTitular);

		textProprietario = new JTextField();
		textProprietario.setToolTipText("");
		textProprietario.setBounds(130, 25, 268, 30);
		panelGerenciar.add(textProprietario);

		JLabel lblPlacaCad = new JLabel("Placa: ");
		lblPlacaCad.setForeground(new Color(43, 52, 61));
		lblPlacaCad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlacaCad.setBounds(10, 148, 110, 30);
		panelGerenciar.add(lblPlacaCad);

		textPlacaCad = new JFormattedTextField(mascaraPlaca);
		textPlacaCad.setToolTipText("");
		textPlacaCad.setBounds(130, 148, 268, 30);
		panelGerenciar.add(textPlacaCad);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(43, 52, 61));
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblModelo.setBounds(10, 189, 110, 30);
		panelGerenciar.add(lblModelo);

		textModelo = new JTextField();
		textModelo.setToolTipText("");
		textModelo.setBounds(130, 189, 268, 30);
		panelGerenciar.add(textModelo);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(new Color(43, 52, 61));
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(10, 230, 110, 30);
		panelGerenciar.add(lblCategoria);

		JComboBox comboBoxCateg = new JComboBox();

		// caso o gestor inclua nova área, essa já será inserida no combobox do veículo
		for (Areas area : estacionamento.getControleAreas()) {
			comboBoxCateg.addItem(area.getCategoria());
		}

		comboBoxCateg.setBounds(130, 230, 268, 30);
		panelGerenciar.add(comboBoxCateg);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar Ve\u00EDculo");
		btnCadastrarVeiculo.setBounds(537, 120, 168, 44);
		panelGerenciar.add(btnCadastrarVeiculo);
		btnCadastrarVeiculo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estacionamento.cadastrarVeiculo(textProprietario.getText(), textMatricula.getText(),
						textCurso.getText(), textPlacaCad.getText(), textModelo.getText(),
						comboBoxCateg.getSelectedItem().toString());
				textProprietario.setText("");
				textPlacaCad.setText("");
				textModelo.setText("");
				textCurso.setText("");
				textMatricula.setText("");
			}
		});

		btnCadastrarVeiculo.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/add.png")));

		JLabel lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setForeground(new Color(43, 52, 61));
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMatricula.setBounds(10, 66, 110, 30);
		panelGerenciar.add(lblMatricula);

		textMatricula = new JTextField();
		textMatricula.setToolTipText("");
		textMatricula.setBounds(130, 66, 268, 30);
		panelGerenciar.add(textMatricula);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setForeground(new Color(43, 52, 61));
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurso.setBounds(10, 107, 110, 30);
		panelGerenciar.add(lblCurso);

		textCurso = new JTextField();
		textCurso.setToolTipText("");
		textCurso.setBounds(130, 107, 268, 30);
		panelGerenciar.add(textCurso);

		JEditorPane dtrpnCasoOProprietrio = new JEditorPane();
		dtrpnCasoOProprietrio.setEditable(false);
		dtrpnCasoOProprietrio.setBackground(SystemColor.activeCaption);
		dtrpnCasoOProprietrio.setText(
				"Caso o Propriet\u00E1rio n\u00E3o seja aluno ou n\u00E3o esteja vinculado a algum aluno, n\u00E3o preencher os campos \"Matr\u00EDcula\" e \"Curso\".");
		dtrpnCasoOProprietrio.setBounds(453, 25, 319, 55);
		panelGerenciar.add(dtrpnCasoOProprietrio);
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

		JFormattedTextField textPlaca = new JFormattedTextField(mascaraPlaca);
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
		btnBuscar.setBounds(64, 105, 109, 25);
		panelConsultar.add(btnBuscar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/erase.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPlaca.setText("");
				textResulBusca.setText("");
			}
		});
		btnLimpar.setBounds(64, 139, 109, 25);
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

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(TelaVeiculos.class.getResource("/images/close.png")));
		btnFechar.setBounds(686, 234, 104, 41);
		panelGerenciar.add(btnFechar);

	}
}
