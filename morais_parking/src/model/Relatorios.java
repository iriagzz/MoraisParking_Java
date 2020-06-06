package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Relatorios {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private LocalDate data;
	private Veiculo veiculo;

	public Relatorios() {
	}

	public Relatorios(LocalDate data, Veiculo veiculo) {
		this.data = data;
		this.veiculo = veiculo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data " + this.data + " | ");
		sb.append("Veiculo: " + this.veiculo);
		return sb.toString();
	}
}
