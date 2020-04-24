package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Relatorios {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private LocalDate data;
	private Veiculo veiculo;
	private Areas area;
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
		sb.append("Data " + data + " | ");
		sb.append("Veiculo: " + veiculo );
		return sb.toString();
	}
}
