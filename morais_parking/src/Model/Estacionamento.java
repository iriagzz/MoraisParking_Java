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

	// Methods

	// Cadastros
	public void cadastrarVeiculo(Proprietario proprietario, String nome, String placa, String modelo, CatVeiculos categoria) {
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

	// Ocorr�ncias

	public void cadastrarOcorrencia(CatOcorrencias tipo, String data, String hora, String fatos, int quantVeiculos) {

		Ocorrencias ocorrencia = new Ocorrencias(tipo, data, hora, fatos, quantVeiculos);
		
		for (int i = 0; i < ocorrencia.getQuantVeiculos(); i++) {
			
			String placa = JOptionPane.showInputDialog("Placa: ");
			Veiculo veiculos = validarVeiculo(placa);
			ocorrencia.addVeiculos(veiculos);
		}
		this.cadastroOcorrencias.add(ocorrencia);

	}

	// Valida��o
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
			System.out.println("Ve�culo n�o Cadastrado"); // saber se � uma pratica aceitavel...
		}
	}

	public void validarSaida(String placa) {
		Veiculo veic = this.validarVeiculo(placa);
		for (Areas area : controleAreas) {
			if (area.getCategoria() == veic.getCategoria()) {
				area.saidaVeiculo(veic);
			} else {
				System.out.println("Entrada n�o registrada"); // saber se � uma pratica aceitavel...
			}
		}
	}

	// metodo temporario
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
			System.out.println("A quantidade de " + area.getNome() + " �: " + quantidade);
			System.out.println("O percentual de ocupa��o �: " + String.format("%.2f", percent) + "%");
		}

	}

	// metodo total entrada
	// metodo total sa�da
	// metodo remover veiculo do cadastro
	// limitador de entrada dependendo da capacidade da area

}
