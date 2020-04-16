package Model;

import java.util.ArrayList;


public class FuncionarioRH {
	//Attributes
	private Funcionario id;
	private ArrayList<Funcionario> cadastrofuncionarios;

	//Constructor
	public FuncionarioRH(Funcionario id) {
		this.id = id;
		this.cadastrofuncionarios = new ArrayList<Funcionario>();
	}
	
	
	//Gets & Sets
	public Funcionario getId() {
		return id;
	}

	public void setId(Funcionario id) {
		this.id = id;
	}


	public ArrayList<Funcionario> getFuncionarios() {
		return cadastrofuncionarios;
	}


	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.cadastrofuncionarios = funcionarios;
	}
	
	
	//Methods
	
	public void cadastrarFuncionario(String usuario, String senha, String nome, int cpf, String setor) {
		Funcionario funcionario = new Funcionario(usuario, senha, nome, cpf, setor);
		this.cadastrofuncionarios.add(funcionario);
	}
	
	public void alterarFuncionario() {
		
		
	}
	
}
