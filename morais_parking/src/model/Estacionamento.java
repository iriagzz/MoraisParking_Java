package model;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	// Attributes
	List<Areas> controleAreas = new ArrayList<>();
	List<Veiculo> cadastroVeiculos = new ArrayList<>(); //banco de dados ou arquivo

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

	public void validarEntrada(String placa) {
		Veiculo veic = cadastroVeiculos.stream().filter(x -> x.getPlaca() == placa).findFirst().orElse(null);
		if (veic == null) {
			System.out.println("Veículo não cadastrado!");
		} else {
			Areas area = controleAreas.stream().filter(x -> x.getCategoria() == veic.getCategoria()).findFirst().orElse(null);
			if (area == null) {
				System.out.println("Área não Cadastrada!");
			} else {
				area.entradaVeiculo(veic);
			}
		}
	}

	public void validarSaida(String placa) {
		Veiculo veic = cadastroVeiculos.stream().filter(x -> x.getPlaca() == placa).findFirst().orElse(null);
		if (veic == null) {
			System.out.println("Veículo não registrado na entrada!");
		} else {
			Areas area = controleAreas.stream().filter(x -> x.getCategoria() == veic.getCategoria()).findFirst().orElse(null);
			if (area == null) {
				System.out.println("Área não Cadastrada!");
			} else {
				area.saidaVeiculo(veic);
			}
		}
	}
			
	
	
	//metodo temporario
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
			System.out.println("A quantidade de " + area.getNome() + " é: " + quantidade);
			System.out.println("O percentual de ocupação é: " + String.format("%.2f", percent) + "%");
		}

	}

	// metodo total entrada
	// metodo total saída
	
	// metodo localizar veiculo no cadastroVeiculos

}
