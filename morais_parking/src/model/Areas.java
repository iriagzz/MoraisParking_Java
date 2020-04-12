package model;

import java.util.ArrayList;

public class Areas {

	// Attributes
	private String nome;
	private Integer capacidade;
	private Categorias categoria;
	private ArrayList<Veiculo> veiculosArea;

	// Constructor
	public Areas(String nome, Integer capacidade, Categorias categoria) {
		this.nome = nome;
		this.capacidade = capacidade;
		this.categoria = categoria;
		this.veiculosArea = new ArrayList<>();
	}

	// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculosArea;
	}

	// Methods
	public void entradaVeiculo(Veiculo veiculo) {
		this.veiculosArea.add(veiculo);
	}

	public void saidaVeiculo(Veiculo veiculo) {
		this.veiculosArea.remove(veiculo);
	}


	
	public void validarSaida(String placa) {
		Veiculo veic = veiculosArea.stream().filter(x -> x.getPlaca() == placa).findFirst().orElse(null);
		if (veic != null) {
			saidaVeiculo(veic);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Área: " + nome + " || ");
		sb.append("Capacidade: " + capacidade + " || ");
		sb.append("Categoria: " + categoria);

		return sb.toString();
	}

	public void mostrarAreas() {
		for (Veiculo veic : veiculosArea) {
			System.out.println(veic);
		}
	}
	
}
