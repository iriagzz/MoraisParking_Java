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
	private List<Relatorios> relatorioEntradas = new ArrayList<>();
	private List<Veiculo> relatorioStatus = new ArrayList<>();
	private List<Usuario> cadastroUsuario = new ArrayList<>();
	private List<Eventos> controleEventos = new ArrayList<>();
	private List<AreasEventos> controleAreasEventos = new ArrayList<>();
	private List<Funcionario> cadastroFuncionario = new ArrayList<>();
	private List<LocalDate> diasEventos = new ArrayList<>();
	private String[] tipoOcorrencia = { "Sinistro", "Furto/Assalto", "Estacionamento Indevido", "Inundação",
			"Danos ao Veículo", "Outros" };

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Constructor
	private Estacionamento() {
	}


	/*Singleton para que apenas um objeto estacionamento seja instanciado!*/
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

	public List<AreasEventos> getControleAreasEventos() {
		return controleAreasEventos;
	}
	
	public List<LocalDate> getDiasEventos(){
		return diasEventos;
	}

	public String[] getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public List<Funcionario> getCadastroFuncionario() {
		return cadastroFuncionario;
	}

	// Methods

	// Veiculos
	/*método para cadastramento de veículo*/
	public void cadastrarVeiculo(String nome, String matricula, String curso, String placa, String modelo,
			String categoria) {
		Proprietario proprietario = new Proprietario(nome, matricula, curso);
		Veiculo veiculo = new Veiculo(proprietario, placa, modelo, categoria);
		this.cadastroVeiculos.add(veiculo);
	}

	/*método para remover de veículo*/
	public void removerVeiculo(Veiculo veiculo) {
		this.cadastroVeiculos.remove(veiculo);
	}

	/*método para validar de veículo - usado pra confirmar se o veículo com a placa utilizada está cadastrado.*/
	public Veiculo validarVeiculo(String placa) {
		for (Veiculo veiculo : this.cadastroVeiculos) {
			if (placa.equals(veiculo.getPlaca())) {
				return veiculo;
			}
		}
		return null;
	}

	/*método para permitir a entrada do veículo - só entra se tiver cadastrado*/
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

	/*método para saída do veículo - só valida se o veículo tiver a entrada registrada*/
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
		} else {
			veic = null;
		}
	}

	// Areas
	/*método para cadastramento de área*/
	public void cadastrarArea(String nome, Integer capacidade, String categoria) {
		if (this.consultarArea(categoria) == null) {
			Areas area = new Areas(nome, capacidade, categoria);
			this.controleAreas.add(area);
		}
	}

	/*método para consultar área pelo tipo da categoria*/
	public Areas consultarArea(String categoria) {
		for (Areas area : this.controleAreas) {
			if (categoria.equals(area.getCategoria())) {
				return area;
			}
		}
		return null;
	}

	/*método para remover a área*/
	public void removerArea(String categoria) {
		Areas area = this.consultarArea(categoria);
		if (area != null) {
			this.controleAreas.remove(area);
		} else {
			JOptionPane.showMessageDialog(null, "Área não cadastrada!");
		}
	}

	/*método para calcular a ocupação da área*/
	public int ocupacaoAreas(String categoria) {
		int percent = 0;
		for (Areas area : this.controleAreas) {
			if(area.getCategoria().equalsIgnoreCase(categoria)) {
				//verifica se tem evento no dia atual
				if (this.diasEventos.contains(LocalDate.now())) { 
					for(AreasEventos areaEv : this.controleAreasEventos) {
						if(areaEv.getArea().equalsIgnoreCase(categoria) && fmt.format(areaEv.getData()).equals(fmt.format(LocalDate.now()))) {
							int quantidade = area.getVeiculos().size();
							percent = (quantidade * 100 / (area.getCapacidade()- areaEv.getVagas()));
						}
					}
				}else {
					int quantidade = area.getVeiculos().size();
					percent = (quantidade * 100 / area.getCapacidade());
				}
			}
		}
		return percent;
	}

	// Ocorrências
	/*método para cadastrar ocorrência*/
	public void cadastrarOcorrencia(Integer id, String tipo, Integer quantidadeVeiculos, LocalDate data, String hora,
			String fatos) {
		Ocorrencias ocorrencia = new Ocorrencias(id, tipo, quantidadeVeiculos, data, hora, fatos);
		this.cadastroOcorrencias.add(ocorrencia);
		//solicita as placas dos veículos quando há mais de um envolvido
		for (int i = 0; i < quantidadeVeiculos; i++) {
			String placa = JOptionPane.showInputDialog(null, "Insira a placa do Veículo (XXX-####): ");
			Veiculo veiculo = validarVeiculo(placa);
			if (veiculo != null) {
				ocorrencia.adicionarVeiculo(veiculo);
			} else {
				JOptionPane.showMessageDialog(null, "Veículo não cadastrado");
			}
		}
	}

	// Eventos
	/*método para cadastramento de evento*/
	public void cadastrarEvento(String nome, LocalDate data, Integer duracao, Integer vagas) {
		if (this.consultarEventoNome(nome) == null) {
			Eventos evento = new Eventos(nome, data, duracao, vagas);
			this.controleEventos.add(evento);
		}
	}

	/*método para consulta de evento pelo nome*/
	public Eventos consultarEventoNome(String nome) {
		for (Eventos evento : this.controleEventos) {
			if (nome.equalsIgnoreCase(evento.getNome())) {
				return evento;
			}
		}
		return null;
	}

	/*método para armazenar os dias que têm eventos, de acordo com o evento*/
	public List<LocalDate> diasEventos(String nome) {
		Eventos evento = this.consultarEventoNome(nome);
		if (evento != null) {
			int duracao = evento.getDuracao();
			for (int i = 0; i < duracao; i++) {
				LocalDate data = evento.getDataInicio();
				LocalDate data_ev = data.plusDays(i);
				this.diasEventos.add(data_ev);
			}
		}
		return diasEventos;
	}
	
	/*método para reserva de vagas para eventos, por área*/
	public void cadastrarAreasEventos(String area, LocalDate data, int vagas) {
		AreasEventos areaEvento = new AreasEventos(area, data, vagas);
		this.controleAreasEventos.add(areaEvento);
	}

	// Relatorios
	/*método para armazenar as entradas de veículos, com data (e hora)*/
	public void relatorioVeiculosEntradas(LocalDate data, Veiculo veiculo) {
		Relatorios relatVeiculos = new Relatorios(data, veiculo);
		this.relatorioEntradas.add(relatVeiculos);
	}

	// Funcionarios
	/*método para cadastramento de funcionario*/
	public void cadastrarFuncionario(String nome, String cpf, String setor, String funcao, String placa) {
		Funcionario funcionario = new Funcionario(nome, cpf, setor, funcao, placa);
		this.cadastroFuncionario.add(funcionario);
	}

	/*método para consultar funcionario pelo cpf*/
	public Funcionario consultarFuncionario(String cpf) {
		for (Funcionario funcionario : this.cadastroFuncionario) {
			if (funcionario.getCpf().equals(String.valueOf(cpf))) {
				return funcionario;
			}
		}
		return null;
	}

	// Usuarios
	/*método para cadastrar usuário*/
	public void cadastrarUsuario(String nome, String cpf, String matricula, String setor, String funcao, String usuario,
			String senha) {
		Usuario user = new Usuario(nome, cpf, matricula, setor, funcao, usuario, senha);
		this.cadastroUsuario.add(user);
	}

	/*método para validar se usuario ja está cadastrado*/
	public Usuario validarUsuario(String usuario) {
		for (Usuario user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user;
			}
		}
		return null;
	}

	/*método para remover usuário*/
	public void removerUsuario(Usuario user) {
		this.cadastroUsuario.remove(user);
	}

	/*método para retornar usuário de acordo com matricula*/
	public Usuario validarMatricula(String matricula) {
		for (Usuario user : this.cadastroUsuario) {
			if (matricula.equals(user.getMatricula())) {
				return user;
			}
		}
		return null;
	}

	/*método para 'setar' a funcao do usuario, para acesso ao sistema*/
	public void editarFuncao(String matricula, String funcao) {
		for (Usuario user : this.cadastroUsuario) {
			if (matricula.equals(user.getMatricula())) {
				user.setFuncao(funcao);
			}
		}
	}

	/*método que retorna a funcao do usuario que está logando, afeta as permissões no sistema*/
	public String retornarFuncao(String usuario) {
		for (Usuario user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user.getFuncao();
			}
		}
		return null;
	}

	/*método para validar login do usuario*/
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
	/*método para armazenar itens pré-cadastrado nos arrays*/
	
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
		estacionamento.cadastrarVeiculo("Roberto Mendes", "20192007043", "SI", "BBB-1234", "Ford K", "CARRO");
		estacionamento.cadastrarVeiculo("Motô do Dominó", "N/A", "N/A", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo", "N/A", "N/A", "AAA-1234", "Ford KA", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Silvio Santos", "2015468s", "N/A", "JJJ-1234", "Ford KA", "CARRO");

		// AREAS
		estacionamento.cadastrarArea("Carros", 20, "CARRO");
		estacionamento.cadastrarArea("Vans", 10, "VAN");
		estacionamento.cadastrarArea("Preferencial", 10, "PREFERENCIAL");
		estacionamento.cadastrarArea("Motocicletas", 20, "MOTO");
		estacionamento.cadastrarArea("Ônibus", 10, "ONIBUS");

		// EVENTO

		LocalDate data = LocalDate.parse("01/07/2020", fmt);
		estacionamento.cadastrarEvento("Calourada", data, 2, 30);


		// RELATORIO ENTRADAS

		Proprietario moto = new Proprietario("Motô do Dominó", "n/a", "n/a");
		Veiculo v3 = new Veiculo(moto, "OZZ-3333", "Mercedez - Van", "CARRO");
		LocalDate date = LocalDate.now();
		estacionamento.relatorioVeiculosEntradas(date, v3);

	}

}
