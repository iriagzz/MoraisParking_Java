package model;

public class Pessoa {

	protected String nome;
	protected String cpf;
	protected String matricula;
	protected String setor;
	protected String funcao;

	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, String matricula, String setor, String funcao) {
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.setor = setor;
		this.funcao = funcao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CPF: " + this.cpf + "\n");
		sb.append("Setor: " + this.setor);
		sb.append("Função: " + this.funcao + "\n");
		sb.append("Matrícula: " + matricula + "\n");
		return sb.toString();
	}

}
