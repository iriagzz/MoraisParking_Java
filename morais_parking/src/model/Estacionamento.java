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
	private String[] tipoOcorrencia = { "Sinistro", "Furto/Assalto", "Estacionamento Indevido", "Inunda��o",
			"Danos ao Ve�culo", "Outros" };

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
	/*m�todo para cadastramento de ve�culo*/
	public void cadastrarVeiculo(String nome, String matricula, String curso, String placa, String modelo,
			String categoria) {
		Proprietario proprietario = new Proprietario(nome, matricula, curso);
		Veiculo veiculo = new Veiculo(proprietario, placa, modelo, categoria);
		this.cadastroVeiculos.add(veiculo);
	}

	/*m�todo para remover de ve�culo*/
	public void removerVeiculo(Veiculo veiculo) {
		this.cadastroVeiculos.remove(veiculo);
	}

	/*m�todo para validar de ve�culo - usado pra confirmar se o ve�culo com a placa utilizada est� cadastrado.*/
	public Veiculo validarVeiculo(String placa) {
		for (Veiculo veiculo : this.cadastroVeiculos) {
			if (placa.equals(veiculo.getPlaca())) {
				return veiculo;
			}
		}
		return null;
	}

	/*m�todo para permitir a entrada do ve�culo - s� entra se tiver cadastrado*/
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

	/*m�todo para sa�da do ve�culo - s� valida se o ve�culo tiver a entrada registrada*/
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
	/*m�todo para cadastramento de �rea*/
	public void cadastrarArea(String nome, Integer capacidade, String categoria) {
		if (this.consultarArea(categoria) == null) {
			Areas area = new Areas(nome, capacidade, categoria);
			this.controleAreas.add(area);
		}
	}

	/*m�todo para consultar �rea pelo tipo da categoria*/
	public Areas consultarArea(String categoria) {
		for (Areas area : this.controleAreas) {
			if (categoria.equals(area.getCategoria())) {
				return area;
			}
		}
		return null;
	}

	/*m�todo para remover a �rea*/
	public void removerArea(String categoria) {
		Areas area = this.consultarArea(categoria);
		if (area != null) {
			this.controleAreas.remove(area);
		} else {
			JOptionPane.showMessageDialog(null, "�rea n�o cadastrada!");
		}
	}

	/*m�todo para calcular a ocupa��o da �rea*/
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

	// Ocorr�ncias
	/*m�todo para cadastrar ocorr�ncia*/
	public void cadastrarOcorrencia(Integer id, String tipo, Integer quantidadeVeiculos, LocalDate data, String hora,
			String fatos) {
		Ocorrencias ocorrencia = new Ocorrencias(id, tipo, quantidadeVeiculos, data, hora, fatos);
		this.cadastroOcorrencias.add(ocorrencia);
		//solicita as placas dos ve�culos quando h� mais de um envolvido
		for (int i = 0; i < quantidadeVeiculos; i++) {
			String placa = JOptionPane.showInputDialog(null, "Insira a placa do Ve�culo (XXX-####): ");
			Veiculo veiculo = validarVeiculo(placa);
			if (veiculo != null) {
				ocorrencia.adicionarVeiculo(veiculo);
			} else {
				JOptionPane.showMessageDialog(null, "Ve�culo n�o cadastrado");
			}
		}
	}

	// Eventos
	/*m�todo para cadastramento de evento*/
	public void cadastrarEvento(String nome, LocalDate data, Integer duracao, Integer vagas) {
		if (this.consultarEventoNome(nome) == null) {
			Eventos evento = new Eventos(nome, data, duracao, vagas);
			this.controleEventos.add(evento);
		}
	}

	/*m�todo para consulta de evento pelo nome*/
	public Eventos consultarEventoNome(String nome) {
		for (Eventos evento : this.controleEventos) {
			if (nome.equalsIgnoreCase(evento.getNome())) {
				return evento;
			}
		}
		return null;
	}

	/*m�todo para armazenar os dias que t�m eventos, de acordo com o evento*/
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
	
	/*m�todo para reserva de vagas para eventos, por �rea*/
	public void cadastrarAreasEventos(String area, LocalDate data, int vagas) {
		AreasEventos areaEvento = new AreasEventos(area, data, vagas);
		this.controleAreasEventos.add(areaEvento);
	}

	// Relatorios
	/*m�todo para armazenar as entradas de ve�culos, com data (e hora)*/
	public void relatorioVeiculosEntradas(LocalDate data, Veiculo veiculo) {
		Relatorios relatVeiculos = new Relatorios(data, veiculo);
		this.relatorioEntradas.add(relatVeiculos);
	}

	// Funcionarios
	/*m�todo para cadastramento de funcionario*/
	public void cadastrarFuncionario(String nome, String cpf, String setor, String funcao, String placa) {
		Funcionario funcionario = new Funcionario(nome, cpf, setor, funcao, placa);
		this.cadastroFuncionario.add(funcionario);
	}

	/*m�todo para consultar funcionario pelo cpf*/
	public Funcionario consultarFuncionario(String cpf) {
		for (Funcionario funcionario : this.cadastroFuncionario) {
			if (funcionario.getCpf().equals(String.valueOf(cpf))) {
				return funcionario;
			}
		}
		return null;
	}

	// Usuarios
	/*m�todo para cadastrar usu�rio*/
	public void cadastrarUsuario(String nome, String cpf, String matricula, String setor, String funcao, String usuario,
			String senha) {
		Usuario user = new Usuario(nome, cpf, matricula, setor, funcao, usuario, senha);
		this.cadastroUsuario.add(user);
	}

	/*m�todo para validar se usuario ja est� cadastrado*/
	public Usuario validarUsuario(String usuario) {
		for (Usuario user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user;
			}
		}
		return null;
	}

	/*m�todo para remover usu�rio*/
	public void removerUsuario(Usuario user) {
		this.cadastroUsuario.remove(user);
	}

	/*m�todo para retornar usu�rio de acordo com matricula*/
	public Usuario validarMatricula(String matricula) {
		for (Usuario user : this.cadastroUsuario) {
			if (matricula.equals(user.getMatricula())) {
				return user;
			}
		}
		return null;
	}

	/*m�todo para 'setar' a funcao do usuario, para acesso ao sistema*/
	public void editarFuncao(String matricula, String funcao) {
		for (Usuario user : this.cadastroUsuario) {
			if (matricula.equals(user.getMatricula())) {
				user.setFuncao(funcao);
			}
		}
	}

	/*m�todo que retorna a funcao do usuario que est� logando, afeta as permiss�es no sistema*/
	public String retornarFuncao(String usuario) {
		for (Usuario user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user.getFuncao();
			}
		}
		return null;
	}

	/*m�todo para validar login do usuario*/
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

	// Mem�ria
	/*m�todo para armazenar itens pr�-cadastrado nos arrays*/
	
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
		estacionamento.cadastrarVeiculo("Mot� do Domin�", "N/A", "N/A", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo", "N/A", "N/A", "AAA-1234", "Ford KA", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Silvio Santos", "2015468s", "N/A", "JJJ-1234", "Ford KA", "CARRO");

		// AREAS
		estacionamento.cadastrarArea("Carros", 20, "CARRO");
		estacionamento.cadastrarArea("Vans", 10, "VAN");
		estacionamento.cadastrarArea("Preferencial", 10, "PREFERENCIAL");
		estacionamento.cadastrarArea("Motocicletas", 20, "MOTO");
		estacionamento.cadastrarArea("�nibus", 10, "ONIBUS");

		// EVENTO

		LocalDate data = LocalDate.parse("01/07/2020", fmt);
		estacionamento.cadastrarEvento("Calourada", data, 2, 30);


		// RELATORIO ENTRADAS

		Proprietario moto = new Proprietario("Mot� do Domin�", "n/a", "n/a");
		Veiculo v3 = new Veiculo(moto, "OZZ-3333", "Mercedez - Van", "CARRO");
		LocalDate date = LocalDate.now();
		estacionamento.relatorioVeiculosEntradas(date, v3);

	}

}
