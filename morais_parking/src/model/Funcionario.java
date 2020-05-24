package model;

public class Funcionario extends Pessoa {
	
	// Attributes
	private String placa;

	// Constructor
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf, String setor, String funcao, String placa) {
		super(nome, cpf, setor, funcao, placa);
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	// Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + nome + "\n");
		sb.append("CPF: " + cpf + "\n");
		sb.append("Fun��o: " + funcao + "\n");
		sb.append("Setor: " + setor + "\n");
		sb.append("Matr�cula: " + matricula + "\n");
		sb.append("Ve�culo - Placa: " + this.placa + "\n");
		return sb.toString();
	}
}
