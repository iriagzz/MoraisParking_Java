package Model;

import java.util.ArrayList;

public class Ocorrencias {
	//Attributes
	private CatOcorrencias tipo;
	private ArrayList<Veiculo> veiculosOcorrencias; // banco de dados ou arquivo
	private String data;
	private String hora;
	private String fatos;
	private int quantVeiculos;
	
	
	//Constructor
	public Ocorrencias(CatOcorrencias tipo, String data, String hora, String fatos, int quantVeiculos) {
		this.tipo = tipo;
		this.data = data;
		this.hora = hora;
		this.fatos = fatos;
		this.veiculosOcorrencias = new ArrayList<>();
		this.quantVeiculos = quantVeiculos;
	}
	
	public int getQuantVeiculos() {
		return quantVeiculos;
	}

	public void setQuantVeiculos(int quantVeiculos) {
		this.quantVeiculos = quantVeiculos;
	}

	//Gets & Sets
	public CatOcorrencias getTipo() {
		return tipo;
	}
	public void setTipo(CatOcorrencias tipo) {
		this.tipo = tipo;
	}
	
	public ArrayList<Veiculo> getVeiculos() {
		return veiculosOcorrencias;
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
			sb.append("Veículos: " + veiculosOcorrencias + "\n");
			sb.append("Data: " + data + "\n");
			sb.append("Hora: " + hora +"\n");
			sb.append("Resumo dos fatos: " + fatos +"\n");
			sb.append("Quantidade de veículos: " + quantVeiculos +"\n");
			return sb.toString();
		}
		
		public void cadastrarVeiculoOcorrencias (String proprietario, String placa, String modelo, CatVeiculos categoria) {
			Veiculo veiculo = new Veiculo(proprietario, placa, modelo, categoria);
			this.veiculosOcorrencias.add(veiculo);
		}
		
		public void addVeiculos (Veiculo veiculo) {
			this.veiculosOcorrencias.add(veiculo);
		}

}
































