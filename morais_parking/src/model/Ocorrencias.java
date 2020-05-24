package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ocorrencias {

	// Attributes
	private Integer id;
	private String tipo;
	private Integer quantidadeVeiculos;
	private ArrayList<Veiculo> veiculosOcorrencia;
	private LocalDate data;
	private String hora;
	private String fatos;

	public Ocorrencias(Integer id, String tipo, Integer quantidadeVeiculos, LocalDate data, String hora, String fatos) {
		this.id = id;
		this.tipo = tipo;
		this.quantidadeVeiculos = quantidadeVeiculos;
		this.veiculosOcorrencia = new ArrayList<>();
		this.data = data;
		this.hora = hora;
		this.fatos = fatos;
	}

	public Integer getid() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Veiculo> getVeiculosOcorrencia() {
		return veiculosOcorrencia;
	}

	public Integer getQuantidadeVeiculos() {
		return quantidadeVeiculos;
	}

	public void setQuantidadeVeiculos(Integer quantidadeVeiculos) {
		this.quantidadeVeiculos = quantidadeVeiculos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getFatos() {
		return fatos;
	}

	public void setFatos(String fatos) {
		this.fatos = fatos;
	}

	// Methods
	public void adicionarVeiculo(Veiculo veiculo) {
		this.veiculosOcorrencia.add(veiculo);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + this.id + "\n");
		sb.append("Ocorrência: " + this.tipo + "\n");
		sb.append("Veículos: " + this.veiculosOcorrencia + "\n");
		sb.append("Data: " + this.data + "\n");
		sb.append("Hora: " + this.hora + "\n");
		sb.append("Resumo dos fatos: " + this.fatos);
		return sb.toString();
	}

}
