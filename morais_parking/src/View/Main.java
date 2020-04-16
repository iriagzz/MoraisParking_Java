package View;

import Model.CatOcorrencias;
import Model.CatVeiculos;
import Model.Estacionamento;
import Model.Proprietario;

public class Main {

	public static void main(String[] args) {

		Estacionamento estacionamentoIesp = new Estacionamento();
		
		//Testes
		
		estacionamentoIesp.cadastrarEvento("Inova Week", "25/05/2020", 500, "A");
		
		
		estacionamentoIesp.cadastrarArea("Carros", 5, CatVeiculos.CARRO);
		estacionamentoIesp.cadastrarArea("Vans", 2, CatVeiculos.VAN);
		estacionamentoIesp.cadastrarArea("Especial_Preferencial", 3, CatVeiculos.ESPECIAL_PREFERENCIAL);

		estacionamentoIesp.cadastrarVeiculo(Proprietario.Aluno, "Iria Guazzi", "OFX-9310", "HB-20", CatVeiculos.CARRO);
		estacionamentoIesp.cadastrarVeiculo(Proprietario.Aluno, "Roberto Mendes", "OXX-4455", "Ford K", CatVeiculos.ESPECIAL_PREFERENCIAL);
		estacionamentoIesp.cadastrarVeiculo(Proprietario.Motorista, "Motô do Dominó", "OZZ-3333", "Mercedez - Van", CatVeiculos.VAN);
		
		
		estacionamentoIesp.cadastrarOcorrencia(CatOcorrencias.Colisao, "25/04/2020", "19:30", "O veículo em questão colidiu com o portão principal", 2);

		
		// mostrar cadastro
		System.out.println("Veículos");
		estacionamentoIesp.mostrarCadastroVeiculos();
		
		System.out.println("Eventos");
		estacionamentoIesp.mostrarCadastroEventos();
		
		System.out.println("Ocorrências");
		estacionamentoIesp.mostrarCadastroOcorrencias();

		// entrada carro Iria
		String placa = "OFX-9310";
		estacionamentoIesp.validarEntrada(placa);

		// veículo n cadastrado
		String placax = "OFX-9311";
		estacionamentoIesp.validarEntrada(placax);

		System.out.println();

		// quantidade carros
		System.out.println("Controle Ocupação v.1: ");
		estacionamentoIesp.ocupacaoAreas();

		// entrada carro betinho
		String placa2 = "OXX-4455";
		estacionamentoIesp.validarEntrada(placa2);

		System.out.println("---------------------------------------------------------");

		// quantidade carros
		System.out.println("Controle Ocupação v.2: ");
		estacionamentoIesp.ocupacaoAreas();

		// saída carro Iria
		String placa3 = "OFX-9310";
		estacionamentoIesp.validarSaida(placa3);

		System.out.println("---------------------------------------------------------");
		// quantidade carros
		System.out.println("Controle Ocupação V.3: ");
		estacionamentoIesp.ocupacaoAreas();

	}

}
