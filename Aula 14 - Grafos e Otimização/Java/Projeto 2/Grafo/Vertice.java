package Grafo;

import java.util.HashMap;

/**
 * classe que representa um vertice e suas conexões (sucessores e antecessores)
 */
public class Vertice {

	private String nomeVertice; // Nome de identificação do vertice
	private HashMap<Vertice, Aresta> adjacentes = new HashMap<Vertice, Aresta>();
	private String dados; // Dados adicionais que podem ser inseridos para
							// algoritmos personalizados

	public Vertice(String nome) {
		nomeVertice = nome;
		dados = "";
	}

	public void adicionaAresta(Aresta aresta, Vertice destino) {
		if (!Grafo.exists(destino))
			System.out.println("Vertice não mapeado.");
		else if (!adjacentes.containsKey(destino))
			adjacentes.put(destino, aresta);
		else
			System.out.println("Aresta já existe.");
	}

	public void removeAresta(Vertice vertice) {
		if (!adjacentes.containsKey(vertice)) {
			System.out.println("Vertice nao mapeado.");
			return;
		}
		adjacentes.remove(vertice);
	}

	public void setNomeVertice(String vertice) {
		this.nomeVertice = vertice;
	}

	public String getNomeVertice() {
		return nomeVertice;
	}

	public HashMap<Vertice, Aresta> getAdjacentes() {
		return adjacentes;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	public String toString() {
		return "Vertice " + nomeVertice;
	}
}
