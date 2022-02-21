package application;

import java.util.List;

import dao.ContatoDao;
import entities.Contato;

public class Principal {

	public static void main(String[] args) {
		
		
		chamaSalvar();
		System.out.println("Salvo!");
		/*
		chamaPegaUm();
		System.out.println();
		chamaUpdate();
		System.out.println();
		chamaPegaUm();*/
		
		//chamaTodos();
		
		
	}
	
	static void chamaTodos() {
		List<Contato> cont = new ContatoDao().findAll();
		
		for(Contato ctd :cont) {
			System.out.println(ctd.toString());
		}
	}

	static void chamaSalvar() {
		Contato contato = new Contato();
		
		contato.setNome("Joao");
		contato.setEmail("joao@gmail.com");
		contato.setCelular("(47) 123-456");
		
		new ContatoDao().salvar(contato);
	}
	
	static void chamaPegaUm() {
		Contato contato = new ContatoDao().pegarUm(2L);
		System.out.println(contato.toString());
	}
	
	static void chamaUpdate() {
		Contato contato = new ContatoDao().pegarUm(2L);
		
		contato.setCelular("(47)852-963");
		
		if(new ContatoDao().update(contato)){
			System.out.println("Updated!");
		}
	}
}
