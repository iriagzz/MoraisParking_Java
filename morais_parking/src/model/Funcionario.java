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
		sb.append("Nome: " + this.nome + "\n");
		sb.append("CPF: " + this.cpf + "\n");
		sb.append("Função: " + this.funcao + "\n");
		sb.append("Setor: " + this.setor + "\n");
		sb.append("Matrícula: " + this.matricula + "\n");
		sb.append("Veículo - Placa: " + this.placa + "\n");
		return sb.toString();
	}
}
