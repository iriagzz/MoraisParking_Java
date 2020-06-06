package model;

public class Veiculo {

	// Atributes
	private Proprietario proprietario;
	private String placa;
	private String modelo;
	private String categoria;

	// Constructor
	public Veiculo(Proprietario proprietario, String placa, String modelo, String categoria) {
		this.proprietario = proprietario;
		this.placa = placa;
		this.modelo = modelo;
		this.categoria = categoria;
	}

	// Getters and Setters
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	// Metodos

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(proprietario.toString() + "\n");
		sb.append("Placa: " + this.placa + "\n");
		sb.append("Categoria: " + this.categoria + "\n");
		sb.append("Modelo: " + this.modelo);
		return sb.toString();
	}
}
