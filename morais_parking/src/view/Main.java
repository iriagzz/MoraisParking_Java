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
		estacionamento.cadastrarVeiculo("Iria Guazzi", "20192007043","SI", "QFX-9310", "HB-20", "CARRO");
		estacionamento.cadastrarVeiculo("Roberto Mendes","20192007043","SI", "OXX-4455", "Ford K", "PREFERENCIAL");
		estacionamento.cadastrarVeiculo("Mot� do Domin�","N/A","N/A", "OZZ-3333", "Mercedez - Van", "VAN");
		estacionamento.cadastrarVeiculo("Onildo","N/A","N/A", "OFH-8830", "Ford KA", "CARRO");


	
		LocalDate data = LocalDate.parse("30/08/2020", fmt);
					
		estacionamento.cadastrarOcorrencia(1,"batida", 2, data, "14:30",
				"o ve�culo x, bateu na traseira do veiculo y");
		
		for(Ocorrencias ocorr : estacionamento.getCadastroOcorrencias()) {
			System.out.println(ocorr);
		}
		

		
		

	}

}
