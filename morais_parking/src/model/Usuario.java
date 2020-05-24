package model;

public class Usuario extends Pessoa {
	// Attributes

	private String usuario;
	private String senha;

	// Constructor
	public Usuario() {
		super();
	}

	public Usuario(String nome, String cpf, String matricula, String setor, String funcao, String usuario,
			String senha) {
		super(nome, cpf, matricula, setor, funcao);
		this.usuario = usuario;
		this.senha = senha;
	}

	
	//Getters and Setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + nome + "\n");
		sb.append("CPF: " + cpf + "\n");
		sb.append("Matrícula: " + matricula + "\n");
		sb.append("Permissão: " + funcao + "\n");
		sb.append("Setor: " + setor + "\n");
		sb.append("Usuário: " + this.usuario + "\n");
		return sb.toString();
	}
}