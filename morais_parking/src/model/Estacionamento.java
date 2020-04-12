package model;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	// Attributes
	List<Areas> controleAreas = new ArrayList<>();
	List<Veiculo> cadastroVeiculos = new ArrayList<>(); // banco de dados ou arquivo

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

	public void cadastrarVeiculo(String proprietario, String placa, String modelo, Categorias categoria) {
		Veiculo veiculo = new Veiculo(proprietario, placa, modelo, categoria);
		this.cadastroVeiculos.add(veiculo);
	}

	public void cadastrarArea(String nome, Integer capacidade, Categorias categoria) {
		Areas area = new Areas(nome, capacidade, categoria);
		this.controleAreas.add(area);
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
