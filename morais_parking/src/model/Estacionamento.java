package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Estacionamento {

	// Attributes
	private List<Areas> controleAreas = new ArrayList<>();
	private List<Veiculo> cadastroVeiculos = new ArrayList<>();
	private List<Ocorrencias> cadastroOcorrencias = new ArrayList<>();
	private List<String> categorias = new ArrayList<>();
	private List<Relatorios> relatorioEntradas = new ArrayList<>();
	private List<Veiculo> relatorioStatus = new ArrayList<>();
	private List<Usuario> cadastroUsuario = new ArrayList<>();
	private List<Eventos> controleEventos = new ArrayList<Eventos>();
	private List<Funcionario> cadastroFuncionario = new ArrayList<>();
	private String[] tipoOcorrencia = { "Batida", "Furto/Assalto", "Estacionamento Indevido", "Inundação",
			"Danos ao Veículo", "Outros" };

	// Constructor
	private Estacionamento() {
	}

	private static Estacionamento instancia = null;

	public static Estacionamento getInstancia() {
		if (instancia == null) {
			instancia = new Estacionamento();
		}
		return instancia;
	}

	// Getters and Setters
	public List<Areas> getControleAreas() {
		return controleAreas;
	}

	public List<Veiculo> getCadastroVeiculos() {
		return cadastroVeiculos;
	}

	public List<Ocorrencias> getCadastroOcorrencias() {
		return cadastroOcorrencias;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public List<Relatorios> getRelatorioEntradas() {
		return relatorioEntradas;
	}

	public List<Veiculo> getRelatorioStatus() {
		return relatorioStatus;
	}

	public List<Usuario> getCadastroUsuario() {
		return cadastroUsuario;
	}

	public List<Eventos> getControleEventos() {
		return controleEventos;
	}

	public String[] getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public List<Funcionario> getCadastroFuncionario() {
		return cadastroFuncionario;
	}

	// Methods

	// Veiculos
	public void cadastrarVeiculo(String nome, String matricula, String curso, String placa, String modelo,
			String categoria) {
		Proprietario proprietario = new Proprietario(nome, matricula, curso);
		Veiculo veiculo = new Veiculo(proprietario, placa, modelo, categoria);
		this.cadastroVeiculos.add(veiculo);
	}

	public void removerVeiculo(Veiculo veiculo) {
		this.cadastroVeiculos.remove(veiculo);
	}

	public Veiculo validarVeiculo(String placa) {
		for (Veiculo veiculo : this.cadastroVeiculos) {
			if (placa.equals(veiculo.getPlaca())) {
				return veiculo;
			}
		}
		return null;
	}

	public void validarEntrada(String placa) {
		if (this.validarVeiculo(placa) != null) {
			Veiculo veic = this.validarVeiculo(placa);
			for (Areas area : controleAreas) {
				if (area.getCategoria() == veic.getCategoria()) {
					area.entradaVeiculo(veic);
					this.relatorioStatus.add(veic);
				}
			}
		}
	}

	public void validarSaida(String placa) {
		Veiculo veic = this.validarVeiculo(placa);
		if (veic != null) {
			if (this.relatorioStatus.contains(veic)) {
				for (Areas area : controleAreas) {
					if (area.getCategoria() == veic.getCategoria()) {
						area.saidaVeiculo(veic);
						this.relatorioStatus.remove(veic);
					}
				}
			}
		}else {
			veic = null;
		}
		
	}

	// Areas
	public void cadastrarArea(String nome, Integer capacidade, String categoria) {
		Areas area = new Areas(nome, capacidade, categoria);
		this.controleAreas.add(area);
		this.categorias.add(categoria);
	}
	
	public Areas consultarArea(String categoria) {
		for (Areas area : this.controleAreas) {
			if(categoria.equals(area.getCategoria())) {
				return area;
			}
		}
		return null;
	}
	
	public void removerArea(String categoria) {
		Areas area = this.consultarArea(categoria); 
		if (area != null) {
			this.categorias.remove(categoria);
			this.controleAreas.remove(area);
		}else {
			JOptionPane.showMessageDialog(null, "Área não cadastrada!");
		}
	}
		

	public int ocupacaoAreas(String categoria) {
		int percent = 0;
		for (Areas area : this.controleAreas) {
			if (categoria.equals(area.getCategoria())) {
				int quantidade = area.getVeiculos().size();
				percent = (quantidade * 100 / area.getCapacidade());
			}
		}
		return percent;
	}

	// Ocorrências
	public void cadastrarOcorrencia(Integer id, String tipo, Integer quantidadeVeiculos, LocalDate data, String hora,
			String fatos) {
		Ocorrencias ocorrencia = new Ocorrencias(id, tipo, quantidadeVeiculos, data, hora, fatos);
		this.cadastroOcorrencias.add(ocorrencia);
		for (int i = 0; i < quantidadeVeiculos; i++) {
			String placa = JOptionPane.showInputDialog(null, "Insira a placa do Veículo: ");
			Veiculo veiculo = validarVeiculo(placa);
			if (veiculo != null) {
				ocorrencia.adicionarVeiculo(veiculo);
			} else {
				JOptionPane.showMessageDialog(null, "Veículo não cadastrado");
			}
		}
	}

	// Eventos
	public void cadastrarEvento(String nome, LocalDate data, Integer duracao, Integer vagas) {
		for (int i = 0; i < duracao; i++) {
			Eventos evento = new Eventos(nome, data.plusDays(i), duracao, vagas);
			this.controleEventos.add(evento);
		}
	}

	// Relatorios
	public void relatorioVeiculosEntradas(LocalDate data, Veiculo veiculo) {
		Relatorios relatVeiculos = new Relatorios(data, veiculo);
		this.relatorioEntradas.add(relatVeiculos);
	}

	// Funcionarios
	public void cadastrarFuncionario(String nome, String cpf, String setor, String funcao, String placa) {
		Funcionario funcionario = new Funcionario(nome, cpf, setor, funcao, placa);
		this.cadastroFuncionario.add(funcionario);
	}

	public Funcionario consultarFuncionario(String cpf) {
		for (Funcionario funcionario : this.cadastroFuncionario) {
			if (funcionario.getCpf().equals(String.valueOf(cpf))) {
				return funcionario;
			}
		}
		return null;
	}

	// Usuarios
	public void cadastrarUsuario(String nome, String cpf, String matricula, String setor, String funcao, String usuario,
			String senha) {
		Usuario user = new Usuario(nome, cpf, matricula, setor, funcao, usuario, senha);
		this.cadastroUsuario.add(user);
	}

	public Usuario validarUsuario(String usuario) {
		for (Usuario user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user;
			}
		}
		return null;
	}

	public void removerUsuario(Usuario user) {
		this.cadastroUsuario.remove(user);
	}

	public Usuario validarMatricula(String matricula) {
		for (Usuario user : this.cadastroUsuario) {
			if (matricula.equals(user.getMatricula())) {
				return user;
			}
		}
		return null;
	}

	public void editarFuncao(String matricula, String funcao) {
		for (Usuario user : this.cadastroUsuario) {
			if (matricula.equals(user.getMatricula())) {
				user.setFuncao(funcao);
			}
		}
	}

	public String retornarFuncao(String usuario) {
		for (Usuario user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user.getFuncao();
			}
		}
		return null;
	}

	public boolean login(String usuario, String senha) {
		Usuario user = validarUsuario(usuario);
		if (user != null) {
			if (user.getUsuario().equals(usuario) && user.getSenha().equals(senha)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Memória
	public void memoria() {

		Estacionamento estacionamento = Estacionamento.getInstancia();
		estacionamento.cadastrarUsuario("Arthur Lacet", "10973236418", "165a", "Setor Pessoal", "Funcionario RH",
				"Arthur", "voltas28");
		estacionamento.cadastrarUsuario("Lucelia Lacet", "10973236418", "16878a", "Estacionamento",
				"Funcionario Estacionamento", "Lucelia", "voltas17");
		estacionamento.cadastrarUsuario("Iria Guazzi", "10973236418", "13548t", "Estacionamento", "Gestor", "Iria",
				"1234");

		// VEICULOS
		estacionamento.cadastrarVeiculo("Iria Guazzi", "20192007043", "SI", "CCC-1234", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes", "20192007043", "SI", "BBB-1234", "Ford K", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Motô do Dominó", "N/A", "N/A", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo", "N/A", "N/A", "AAA-1234", "Ford KA", "CARRO");
		estacionamento.cadastrarVeiculo("Silvio Santos", "2015468s", "N/A", "JJJ-1234", "Ford KA", "CARRO");

		// AREAS
		estacionamento.cadastrarArea("Carros", 20, "CARRO");
		estacionamento.cadastrarArea("Vans", 10, "VAN");
		estacionamento.cadastrarArea("Preferencial", 10, "PREFERENCIAL");
		estacionamento.cadastrarArea("Motocicletas", 20, "MOTO");
		estacionamento.cadastrarArea("Ônibus", 10, "ONIBUS");

		//OCORRENCIA
		
		
		
		// RELATORIO (para testes)

		Proprietario moto = new Proprietario("Motô do Dominó", "n/a", "n/a");
		Veiculo v3 = new Veiculo(moto, "OZZ-3333", "Mercedez - Van", "VAN");
		LocalDate date = LocalDate.now();
		estacionamento.relatorioVeiculosEntradas(date, v3);

	}

}
