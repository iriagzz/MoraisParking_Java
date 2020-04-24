package model;

public class Memoria {

	Estacionamento estacionamento = new Estacionamento();
	Relatorios relatorio = new Relatorios();

	public Memoria() {
		
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}
	
	public Relatorios getRelatorios() {
		return relatorio;
	}

	
	// Cadastrar Veiculo
	public void armazenarVeiculos() {
		estacionamento.cadastrarVeiculo("Iria Guazzi", "QFX-9310", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes", "OXX-4455", "Ford K", "ESPECIAL_PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Motô do Dominó", "OZZ-3333", "Mercedez - Van", "VAN");
	}
}
