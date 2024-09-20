package pjAula3;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Testes para Estrutura de Dados
 * Coleções - Lista
 * @autor Prof. Paulo Barreto
 * @data 22/08/2024
 */

public class TesteProduto {
	public static void main(String[] args) {
		List<Produto> lista = new ArrayList<Produto>();
		
		if(lista.isEmpty()) {
			System.out.println("Lista está vázia.");
		}else {
			System.out.println("A Lista possui " + lista.size() + " elementos");
		}

		//Adição de Produto à lista
		for(int i=0; i < 10; i++) {
			Produto p = new Produto();
			p.codigo = i;
			p.descricao = "Produto " + i;
			p.quantidade = System.currentTimeMillis()/1000;

			lista.add(p);
		}

		if(lista.isEmpty()) {
			System.out.println("Lista está vázia.");
		}else {
			System.out.println("A Lista possui " + lista.size() + " elementos");
		}
		
		//Ler o conteúdo da lista
		for(int i=0; i < 10; i++) {
			System.out.println(lista.get(i).imprimir());
		}
		
		if(lista.isEmpty()) {
			System.out.println("Lista está vázia.");
		}else {
			System.out.println("A Lista possui " + lista.size() + " elementos");
		}
		
		System.out.println(lista);
	}
}
