package Model;

public class Ocorrencias {
	//Attributes
	private String tipo;
	private Veiculo veiculos;
	private String data;
	private String hora;
	private String fatos;
	
	//Constructor
	public Ocorrencias(String tipo, Veiculo veiculos, String data, String hora, String fatos) {
		this.tipo = tipo;
		this.veiculos = veiculos;
		this.data = data;
		this.hora = hora;
		this.fatos = fatos;
	}
	
	//Gets & Sets
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Veiculo getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Veiculo veiculos) {
		this.veiculos = veiculos;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	
	//Methods
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Ocorrência: " + tipo + "\n");
			sb.append("Veículos: " + veiculos + "\n");
			sb.append("Data: " + data + "\n");
			sb.append("Hora: " + hora +"\n");
			sb.append("Resumo dos fatos: " + fatos +"\n");
			return sb.toString();
		}
		
	
}
