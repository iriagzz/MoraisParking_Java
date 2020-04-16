package Model;

public class Gestor {
	//Attributes
	private String usuario;
	private String senha;
	private String nome;
	private int cpf;
	
	//Constructor
	public Gestor(String usuario, String senha, String nome, int cpf) {
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	//Gets & Sets
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

		public int getCpf() {
			return cpf;
		}

		public void setCpf(int cpf) {
			this.cpf = cpf;
		}

	//Methods
		public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuário: " + usuario + " || ");
		sb.append("Senha: " + senha + " || ");
		sb.append("Nome: " + nome + "||");
		sb.append("CPF: " + cpf + "||");
		return sb.toString();
		}
}
