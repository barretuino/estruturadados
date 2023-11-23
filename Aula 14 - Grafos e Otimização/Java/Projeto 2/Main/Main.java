package Main;

import Algoritmo.buscaEmProfundidade;
import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

public class Main {

	public static void main(String[] args) {

		Grafo grafo = new Grafo();
		// Exemplos de grafos
		// Grafo Completo
		System.out.println("Exemplo de Grafo Completo: ");
		Vertice cacupe = new Vertice("Cacupé");
		Vertice jurere = new Vertice("Jurerê");
		Vertice canasvieiras = new Vertice("Canasvieiras");

		grafo.adicionaVertice(cacupe);
		grafo.adicionaVertice(jurere);
		grafo.adicionaVertice(canasvieiras);

		grafo.conecta(cacupe, jurere, new Aresta(5));
		grafo.conecta(cacupe, canasvieiras, new Aresta(7));
		grafo.conecta(jurere, canasvieiras, new Aresta(4));

		System.out.println(grafo.toString_info());
		buscaEmProfundidade search = new buscaEmProfundidade(grafo, jurere);
		System.out.println("Busca em Profundidade: \nOrdem de busca dos vértices partindo de Jurere: ");
		for (Vertice v : grafo.vertices()) {
			if (search.marcados(v))
				System.out.println(v + " ");
		}
		
		System.out.println(" ");
		if (search.count() != grafo.ordem())
			System.out.println("Grafo não conexo");
		else
			System.out.println("Grafo conexo");
		
		System.out.println("----------------------------------------------------\n");
		// Grafos Conexos
		System.out.println("Exemplo de Grafo Conexo: ");
		grafo.desconecta(cacupe, jurere);

		System.out.println(grafo.toString_info());
		search = new buscaEmProfundidade(grafo, jurere);
		System.out.println("Busca em Profundidade: \nOrdem de busca dos vértices partindo de Jurere: ");
		for (Vertice v : grafo.vertices()) {
			if (search.marcados(v))
				System.out.println(v + " ");
		}
		
		System.out.println(" ");
		if (search.count() != grafo.ordem())
			System.out.println("Grafo não conexo");
		else
			System.out.println("Grafo conexo");
		
		System.out.println("----------------------------------------------------\n");
		System.out.println("Exemplo de Grafo Conexo 2: ");
		grafo.conecta(cacupe, jurere, new Aresta(10));
		Vertice aeroporto = new Vertice("Aeroporto");
		Vertice campeche = new Vertice("Campeche");
		Vertice costeira = new Vertice("Costeira");
		Vertice sacodoslimoes = new Vertice("Saco dos Limões");
		Vertice centro = new Vertice("Centro");
		Vertice trindade = new Vertice("Trindade");
		Vertice agronomica = new Vertice("Agronômica");
		Vertice sambaqui = new Vertice("Sambaqui");
	    Vertice ingleses = new Vertice("Ingleses");
		Vertice corregogrande = new Vertice("Corrego Grande");

		grafo.adicionaVertice(aeroporto);
		grafo.adicionaVertice(campeche);
		grafo.adicionaVertice(costeira);
		grafo.adicionaVertice(sacodoslimoes);
		grafo.adicionaVertice(centro);
		grafo.adicionaVertice(trindade);
		grafo.adicionaVertice(agronomica);
		grafo.adicionaVertice(sambaqui);
		grafo.adicionaVertice(ingleses);
		grafo.adicionaVertice(corregogrande);
		
		grafo.conecta(aeroporto, costeira, new Aresta(4));
		grafo.conecta(costeira, campeche, new Aresta(5));
		grafo.conecta(costeira, sacodoslimoes, new Aresta(8));
		grafo.conecta(centro, sacodoslimoes, new Aresta(5));
		grafo.conecta(trindade, sacodoslimoes, new Aresta(4));
		grafo.conecta(trindade, corregogrande, new Aresta(2));
		grafo.conecta(centro, agronomica, new Aresta(5));
		grafo.conecta(trindade, agronomica, new Aresta(3));
		grafo.conecta(agronomica, cacupe, new Aresta(8));
		grafo.conecta(cacupe, sambaqui, new Aresta(5));
		grafo.conecta(canasvieiras, ingleses, new Aresta(15));
		
		System.out.println(grafo.toString_info());
		search = new buscaEmProfundidade(grafo, aeroporto);
		System.out.println("Busca em Profundidade: \n Ordem dos vértices partindo de Aeroporto:");
		for (Vertice v : grafo.vertices()) {
			if (search.marcados(v))
				System.out.println(v + " ");
		}
		
		System.out.println(" ");
		if (search.count() != grafo.ordem())
			System.out.println("Grafo não conexo");
		else
			System.out.println("Grafo conexo");
		
		System.out.println("----------------------------------------------------\n");
		System.out.println("Exemplo de Grafo Conexo 3: ");
		grafo.desconecta(jurere, canasvieiras);
		grafo.desconecta(trindade, agronomica);
		System.out.println(grafo.toString_info());
		search = new buscaEmProfundidade(grafo, ingleses);
		System.out.println("Busca em Profundidade: \n Ordem dos vértices partindo de Ingleses:");
		for (Vertice v : grafo.vertices()) {
			if (search.marcados(v))
				System.out.println(v + " ");
		}
		
		System.out.println(" ");
		if (search.count() != grafo.ordem())
			System.out.println("Grafo não conexo");
		else
			System.out.println("Grafo conexo");
		
		System.out.println("----------------------------------------------------\n");
		// Grafo Desconexo
		System.out.println("Exemplo de Grafo Desconexo: ");
		
		grafo.desconecta(corregogrande, trindade);
		grafo.desconecta(agronomica, cacupe);
		System.out.println(grafo.toString_info());
		search = new buscaEmProfundidade(grafo, aeroporto);
		System.out.println("Busca em Profundidade: \n Ordem dos vértices partindo de Aeroporto:");
		for (Vertice v : grafo.vertices()) {
			if (search.marcados(v))
				System.out.println(v + " ");
		}
		
		System.out.println(" ");
		if (search.count() != grafo.ordem())
			System.out.println("Grafo não conexo");
		else
			System.out.println("Grafo conexo");
	}
}
