package Model;

import java.util.ArrayList;
import java.util.List;
import Model.CatVeiculos;
import javax.swing.JOptionPane;

public class Estacionamento {

	// Attributes
	
	List<Areas> controleAreas = new ArrayList<>();
	List<Veiculo> cadastroVeiculos = new ArrayList<>(); // banco de dados ou arquivo
	List<Eventos> cadastroEventos = new ArrayList<Eventos>();
	List<Ocorrencias> cadastroOcorrencias = new ArrayList<Ocorrencias>();
	List<Usuarios> cadastroUsuario = new ArrayList<Usuarios>();

	
	// Constructors
	public Estacionamento() {
	}

	
	// Getters and Setters
	
	public List<Areas> getControleAreas() {
		return controleAreas;
	}
	public List<Veiculo> getCadastroVeiculos() {
		return cadastroVeiculos;
	}
	public List<Usuarios> getCadastroUsuario() {
		return cadastroUsuario;
	}

	// Methods

	// Registrations
	
	public void cadastrarVeiculo(Proprietario proprietario, String nome, String placa, String modelo,
			CatVeiculos categoria) {
		Veiculo veiculo = new Veiculo(proprietario, nome, placa, modelo, categoria);
		this.cadastroVeiculos.add(veiculo);
	}

	public void cadastrarArea(String nome, Integer capacidade, CatVeiculos categoria) {
		Areas area = new Areas(nome, capacidade, categoria);
		this.controleAreas.add(area);
	}

	public void cadastrarEvento(String nome, String data, int vagas, String zonas) {
		Eventos evento = new Eventos(nome, data, vagas, zonas);
		this.cadastroEventos.add(evento);
	}
	
	public void cadastrarUsuario(CatUsuario funçao, String usuario, String senha, String nome, String cpf,
			String setor) {
		Usuarios funcionario = new Usuarios(funçao, usuario, senha, nome, cpf, setor);
		this.cadastroUsuario.add(funcionario);
	}

	// Reports

	public void cadastrarOcorrencia(CatOcorrencias tipo, String data, String hora, String fatos, int quantVeiculos) {

		Ocorrencias ocorrencia = new Ocorrencias(tipo, data, hora, fatos, quantVeiculos);

		for (int i = 0; i < ocorrencia.getQuantVeiculos(); i++) {

			String placa = JOptionPane.showInputDialog("Placa: ");
			Veiculo veiculos = validarVeiculo(placa);
			ocorrencia.addVeiculos(veiculos);
		}
		this.cadastroOcorrencias.add(ocorrencia);

	}

	// Validation
	
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
		} else {
			System.out.println("Veículo não Cadastrado"); // saber se é uma pratica aceitavel...
		}
	}

	public void validarSaida(String placa) {
		Veiculo veic = this.validarVeiculo(placa);
		for (Areas area : controleAreas) {
			if (area.getCategoria() == veic.getCategoria()) {
				area.saidaVeiculo(veic);
			} else {
				System.out.println("Entrada não registrada"); // saber se é uma pratica aceitavel...
			}
		}
	}
	
	public Usuarios validarUsuario(String usuario) {
		for (Usuarios user : this.cadastroUsuario) {
			if (usuario.equals(user.getUsuario())) {
				return user;
			}
		}
		return null;
	}
	
	//Login
	
	public boolean login(String usuario, String senha) {

		Usuarios user = validarUsuario(usuario);

		if (user.getUsuario().equals(usuario) && user.getSenha().equals(senha)) {
			return true;
		} else {
			return false;
		}
	}
	

	// Temporary Methods
	
	public void mostrarCadastroVeiculos() {
		for (Veiculo veiculo : cadastroVeiculos) {
			System.out.println(veiculo);
		}
	}

	public void mostrarCadastroEventos() {
		for (Eventos evento : cadastroEventos) {
			System.out.println(evento);
		}
	}

	public void mostrarCadastroOcorrencias() {
		for (Ocorrencias ocorrencia : cadastroOcorrencias) {
			System.out.println(ocorrencia);
		}
	}

	public void ocupacaoAreas() {
		double percent = 0;
		for (Areas area : controleAreas) {
			int quantidade = area.getVeiculos().size();
			percent = (quantidade * 100 / area.getCapacidade());

			System.out.println("\n--- " + area.getNome() + " ---\n");
			System.out.println("A quantidade de " + area.getNome() + " é: " + quantidade);
			System.out.println("O percentual de ocupação é: " + String.format("%.2f", percent) + "%");
		}

	}

	// metodo total entrada
	// metodo total saída
	// metodo remover veiculo do cadastro
	// limitador de entrada dependendo da capacidade da area

}
