package model;

public class Proprietario {
	
	private String nome;
	private String matricula;
	private String curso;
	
	public Proprietario() {
		
	}

	public Proprietario(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	// Methodo
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Nome: " + this.nome + "\n");
			sb.append("Matr�cula: " + this.matricula + "\n");
			sb.append("Curso: " + this.curso);
			return sb.toString();
		}
	
	
	

}
