package br.com.teste;

import br.com.controle.CarroCtrl;
import br.com.entidade.Carro;

public class Teste {
	
	public static void main (String[]args) {
		
		/*Carro c = new Carro();
		
		c.setModelo("FORD");
		c.setNome("Ka");
		
		CarroCtrl controle = new CarroCtrl();
		controle.insert(c);*/
		
		for(Carro carro : new CarroCtrl().select(Carro.CONS_CARRO_ALL)) {
			System.out.println("Id: " + carro.getId());
			System.out.println("Nome: " + carro.getNome());;
			System.out.println("Modelo: " + carro.getModelo());
		}
	}

}
