package model;

import java.time.LocalDate;

public class Eventos {
	// Attributes
	private String nome;
	private LocalDate dataInicio;
	private Integer duracao;
	private Integer vagas;

	// Constructor
	public Eventos(String nome, LocalDate dataInicio, Integer duracao, Integer vagas) {

		this.nome = nome;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.vagas = vagas;
	}

	// Gets & Sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}
	
	
	// Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Evento: " + this.nome + "\n");
		sb.append("Data: " + this.dataInicio + "\n");
		sb.append("Duracao: " + this.duracao + "\n");
		sb.append("Vagas: " + this.vagas);
		return sb.toString();
	}
}