package view;

import model.Categorias;
import model.Estacionamento;
import model.Veiculo;

public class Main {

	public static void main(String[] args) {

		Estacionamento estacionamentoIesp = new Estacionamento();
		
		estacionamentoIesp.cadastrarArea("Carros", 5, Categorias.CARRO);
		estacionamentoIesp.cadastrarArea("Vans", 2, Categorias.VAN);
		estacionamentoIesp.cadastrarArea("Especial_Preferencial", 3, Categorias.ESPECIAL_PREFERENCIAL);
		
		
		estacionamentoIesp.cadastrarVeiculo("Iria Guazzi", "OFX-9310", "HB-20", Categorias.CARRO);
		estacionamentoIesp.cadastrarVeiculo("Roberto Mendes", "OXX-4455", "Ford K", Categorias.ESPECIAL_PREFERENCIAL);
		estacionamentoIesp.cadastrarVeiculo("Motô do Dominó", "OZZ-3333", "Mercedez - Van", Categorias.VAN);
		
		
		// mostrar cadastro
		System.out.println("Mostrar cadastro");
		estacionamentoIesp.mostrarCadastroVeiculos();

		// entrada carro Iria
		String placa = "OFX-9310";
		estacionamentoIesp.validarEntrada(placa);

		
		// veículo n cadastrado
		String placax = "OFX-9311";
		estacionamentoIesp.validarEntrada(placax);
		
		System.out.println();

		// quantidade carros
		System.out.println("Controle Ocupação v.1: ");
		estacionamentoIesp.mostrarControleAreas();

	
		// entrada carro betinho
		String placa2 = "OXX-4455";
		estacionamentoIesp.validarEntrada(placa2);

		System.out.println("---------------------------------------------------------");
		
		// quantidade carros
		System.out.println("Controle Ocupação v.2: ");
		estacionamentoIesp.mostrarControleAreas();
				
		// saída carro Iria
		//String placa3 = "OFX-9310";
		//area.validarSaida(placa3);

		// carros no pátio:
		//System.out.println("Carros no Pátio V.3");
		//for (Veiculo v : estacionamentoIesp.getControle()) {
		//	System.out.println(v);
		}

		// quantidade carros
		//System.out.println("Quantidade de carros no momento: " + estacionamentoIesp.getControle().size() + "\n");

	

}
