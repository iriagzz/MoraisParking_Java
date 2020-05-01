package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Estacionamento;
import model.Eventos;
import model.Ocorrencias;
import model.Veiculo;

public class Main {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Estacionamento estacionamento = new Estacionamento();

		// VEICULOS
		estacionamento.cadastrarVeiculo("Iria Guazzi", "QFX-9310", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes", "OXX-4455", "Ford K", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Motô do Dominó", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo", "OFH-8830", "Ford KA", "CARRO");

	
		LocalDate data = LocalDate.parse("30/08/2020", fmt);
					
		estacionamento.cadastrarOcorrencia(1,"batida", 2, data, "14:30",
				"o veículo x, bateu na traseira do veiculo y");
		
		for(Ocorrencias ocorr : estacionamento.getCadastroOcorrencias()) {
			System.out.println(ocorr);
		}
		

		
		

	}

}
