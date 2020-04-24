package model;

public class Usuario {
	// Attributes
	private String fun�ao;
	private String usuario;
	private String senha;
	private String nome;
	private String cpf;
	private String setor;

	// Constructor
	public Usuario(String fun�ao, String usuario, String senha, String nome, String cpf, String setor) {
		this.fun�ao = fun�ao;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.setor = setor;
	}

	// Gets & Sets
	public String getFun�ao() {
		return fun�ao;
	}

	public void setFun�ao(String fun�ao) {
		this.fun�ao = fun�ao;
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

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	// Methods
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usu�rio: " + usuario + " || ");
		sb.append("Senha: " + senha + " || ");
		sb.append("Nome: " + nome + "||");
		sb.append("CPF: " + cpf + "||");
		sb.append("Setor: " + setor + "||");
		return sb.toString();
	}
}