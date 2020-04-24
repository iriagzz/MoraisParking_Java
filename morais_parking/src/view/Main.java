package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Estacionamento;
import model.Eventos;

public class Main {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Estacionamento estacionamentoIesp = new Estacionamento();
		LocalDate data = LocalDate.parse("30/08/2020", fmt);
		estacionamentoIesp.cadastrarEvento("Inova", data, 4, 250);
		
		for(Eventos evento : estacionamentoIesp.getControleEventos()) {
			System.out.println(evento);
		}
		
	
	
	}

}
