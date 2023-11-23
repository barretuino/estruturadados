package Algoritmo;
import java.util.ArrayList;
import java.util.HashMap;

import Grafo.Aresta;
import Grafo.Grafo;
import Grafo.Vertice;

/**
 * classe que implementa o algoritmo de caminho de custo minimo de dikstra
 */
public class Dijkstra {

	private HashMap<Vertice, Integer> vertices = new HashMap<Vertice, Integer>();

	private Grafo grafo;
	private ArrayList<Vertice> grafoVertices;

	public Dijkstra(Grafo grafo) {
		this.grafo = grafo;
	}

	public int caminhoCustoMinimo(Vertice inicial, Vertice destino) {
		grafoVertices = grafo.vertices();
		for (int i = 0; i < grafo.ordem(); i++) { // inicializacao da lista
			vertices.put(grafoVertices.get(i), Integer.MAX_VALUE);
		}

		vertices.put(inicial, 0); // vertice inicial = 0

		int peso, pesoVertice;
		Vertice auxVertice;
		HashMap<Vertice, Aresta> arestas = null;
		Object[] adjacentes;
		do {
			auxVertice = getMenor();
			auxVertice.setDados("fechado");
			arestas = auxVertice.getAdjacentes();
			adjacentes = auxVertice.getAdjacentes().keySet().toArray();

			pesoVertice = vertices.get(auxVertice);
			for (int i = 0; i < arestas.size(); i++) {
				peso = arestas.get(adjacentes[i]).getPeso();
				//System.out.println("adj: " + vertices.get((Vertice)adjacentes[i]));

				if ((pesoVertice + peso) < vertices.get((Vertice)adjacentes[i])) {
					vertices.put((Vertice) adjacentes[i], pesoVertice + peso);
				}
			}

		} while (isFechado() == false);

		return vertices.get(destino);

	}

	/**
	 * retorna o vertice com menor caminho anotado
	 */
	private Vertice getMenor() {
		Integer menor = Integer.MAX_VALUE;
		Integer aux;
		Vertice vertMenor = null;

		for (int i = 0; i < grafo.ordem(); i++) {
			aux = vertices.get(grafoVertices.get(i));
			if (aux <= menor && grafoVertices.get(i).getDados().equals("") == true) {
				menor = aux;
				vertMenor = grafoVertices.get(i);
			}
		}

		return vertMenor;
	}

	/**
	 * retorna true se o algoritmo ja fechou todos os vertices
	 */
	private boolean isFechado() {
		for (int i = 0; i < grafo.ordem(); i++) {
			if (!grafoVertices.get(i).getDados().equals("fechado")) {
				return false;
			}
		}
		return true;
	}

}
