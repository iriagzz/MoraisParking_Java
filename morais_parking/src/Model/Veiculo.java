package Model;

public class Veiculo {

	// Atributes
	private Proprietario proprietario;
	private String nome;
	private String placa;
	private String modelo;
	private CatVeiculos categoria;

	/*
	 * a preferência muda quando o gestor dá um set na categoria do veículo.
	 * 
	 */

	// Constructor
	
	public Veiculo(Proprietario proprietario, String nome, String placa, String modelo, CatVeiculos categoria) {
		this.proprietario = proprietario;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public CatVeiculos getCategoria() {
		return categoria;
	}

	public void setCategoria(CatVeiculos categoria) {
		this.categoria = categoria;
	}

	// Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Proprietário: " + proprietario + "\n");
		sb.append("Nome: " + nome + "\n");
		sb.append("Placa: " + placa + "\n");
		sb.append("Categoria: " + categoria + "\n");
		sb.append("Modelo: " + modelo + "\n");
		return sb.toString();
	}

}
