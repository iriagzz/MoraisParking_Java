package model;

import java.util.ArrayList;

public class Areas {

	// Attributes
	private String nome;
	private Integer capacidade;
	private String categoria;
	private ArrayList<Veiculo> veiculosArea;

	// Constructor
	public Areas(String nome, Integer capacidade, String categoria) {
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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

	//Listar Veiculos na �rea
	public Veiculo veiculosArea(Veiculo veiculo) {
		for (Veiculo veic : veiculosArea) {
			return veic;
		}
		return null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("�rea: " + this.nome + "\n");
		sb.append("Capacidade: " + this.capacidade + "\n");
		sb.append("Categoria: " + this.categoria);
		return sb.toString();
	}

}
