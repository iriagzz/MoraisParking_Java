package Model;

public class Eventos {
	//Attributes
	private String nome;
	private String data;
	private int vagas;
	private String zonas;
	
	//Constructor
	public Eventos(String nome, String data, int vagas, String zonas) {

		this.nome = nome;
		this.data = data;
		this.vagas = vagas;
		this.zonas = zonas;
	}
	
	//Gets & Sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getZonas() {
		return zonas;
	}

	public void setZonas(String zonas) {
		this.zonas = zonas;
	}
	
	//Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Evento: " + nome + "\n");
		sb.append("Data: " + data + "\n");
		sb.append("Vagas: " + vagas +"\n");
		sb.append("Zona: " + zonas +"\n");
		return sb.toString();
	}
	

}
