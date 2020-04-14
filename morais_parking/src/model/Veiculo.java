package Model;

public class Veiculo {

	// Atributes
	private String proprietario; // criar uma classe proprietario
	private String placa;
	private String modelo;
	private Categorias categoria;

	/*
	 * a preferência muda quando o gestor dá um set na categoria do veículo.
	 * 
	 */

	// Constructor
	
	public Veiculo(String proprietario, String placa, String modelo, Categorias categoria) {
		this.proprietario = proprietario;
		this.placa = placa;
		this.modelo = modelo;
		this.categoria = categoria;
	}

	// Getters and Setters
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
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

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	// Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Placa: " + placa + "\n");
		sb.append("Proprietário: " + proprietario + "\n");
		sb.append("Categoria: " + categoria + "\n");
		sb.append("Modelo: " + modelo + "\n");
		return sb.toString();
	}

}
