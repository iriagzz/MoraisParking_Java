package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Estacionamento {

	// Attributes
	List<Areas> controleAreas = new ArrayList<>();
	List<Veiculo> cadastroVeiculos = new ArrayList<>();
	List<Ocorrencias> cadastroOcorrencias = new ArrayList<>();
	List<String> categorias = new ArrayList<>();
	List<Relatorios> relatorioEntradas = new ArrayList<>();
	List<Relatorios> relatorioStatus = new ArrayList<>();
	List<Usuario> cadastroUsuario = new ArrayList<>();
	List<Eventos> controleEventos = new ArrayList<Eventos>();
	List<Funcionario> cadastroFuncionario = new ArrayList<>();
	String[] tipoOcorrencia = { "Batida", "Furto/Assalto", "Estacionamento Indevido", "Inundação", "Danos ao Veículo",
			"Outros" };

	// Constructor
	public Estacionamento() {
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

	public List<Relatorios> getRelatorioStatus() {
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
				}
			}
		}
	}

	public void validarSaida(String placa) {
		Veiculo veic = this.validarVeiculo(placa);
		for (Areas area : controleAreas) {
			if (area.getCategoria() == veic.getCategoria()) {
				area.saidaVeiculo(veic);
			} else {
				System.out.println("Entrada não registrada"); // tenho que fazer essa condição na interface? ou posso
			}
		}
	}

	// Areas
	public void cadastrarArea(String nome, Integer capacidade, String categoria) {
		Areas area = new Areas(nome, capacidade, categoria);
		this.controleAreas.add(area);
		this.categorias.add(categoria);
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
	public void cadastrarUsuario(String nome, String cpf, String matricula,String setor, String funcao, String usuario,
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
}
