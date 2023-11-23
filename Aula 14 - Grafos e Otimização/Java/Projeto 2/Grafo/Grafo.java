package Grafo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

/**
 * classe que representa um grafo generico
 */
public class Grafo {

	private static ArrayList<Vertice> vertices;
	private ArrayList<Vertice> fechoTransitivo, jaVisitados, visitadosArvore;
	public Grafo() {
		vertices = new ArrayList<Vertice>();
	}

	// Operações básicas em grafos
	public void adicionaVertice(Vertice vertice) {
		if (!vertices.contains(vertice)) {
			vertices.add(vertice);
			return;
		}
		System.out.println("Valor de vertice ja existente no grafo! -> "
				+ vertice.toString());
	}

	public void removeVertice(Vertice vertice) {
		if (vertices.contains(vertice)) {
			vertices.remove(vertice);
			for (Vertice vAdj : vertice.getAdjacentes().keySet())
				vertice.removeAresta(vAdj);
		}
		System.out.println("Valor de vertice inválido! -> "
				+ vertice.toString());
	}

	public void conecta(Vertice v1, Vertice v2, Aresta aresta) {
		if (!v1.getAdjacentes().containsKey(v2)){
			v1.adicionaAresta(aresta, v2);
			v2.adicionaAresta(aresta, v1);	
		}
		else
			System.out.println("Aresta " + v1.toString() + "-" + v2.toString() + "já existe.");
		
	}

	public void desconecta(Vertice v1, Vertice v2) {
		if (v1.getAdjacentes().containsKey(v2)) {
			v1.removeAresta(v2);
			v2.removeAresta(v1);
		}
		else 
			System.out.println("Não é possível remover aresta inexistente.");
	}

	public int ordem() {
		return vertices.size();
	}

	public ArrayList<Vertice> vertices() {
		return vertices;
	}

	public Vertice umVertice() {
		Random random = new Random();
		return vertices.get(random.nextInt(vertices.size()));
	}

	public Set<Vertice> adjacentes(Vertice v) {
		return v.getAdjacentes().keySet();
	}

	public int grau(Vertice v) {
		return v.getAdjacentes().size();
	}

	// Ações derivadas
	private boolean isRegular() {

		int grau = grau(vertices.get(0));
		int grauTestado;
		for (Vertice v : vertices) {
			grauTestado = grau(v);
			if (grauTestado != grau)
				return false;
		}
		return true;
	}
	
	private boolean isCompleto() {
		
		int n =  ordem() - 1;
		for (Vertice v : vertices) {
			if (grau(v) != n)
				return false;
		}
		return true;
	}
	
	private ArrayList<Vertice> fechoTransitivo(Vertice v) {
		fechoTransitivo =  new ArrayList<Vertice>();
		jaVisitados =  new ArrayList<Vertice>();
		return procuraFechoTransitivo(v);
	}
	
	private ArrayList<Vertice> procuraFechoTransitivo(Vertice v) {
		jaVisitados.add(v);
		for (Vertice vAdj : adjacentes(v)) {
			if (!jaVisitados.contains(vAdj))
				procuraFechoTransitivo(vAdj);
			if (!fechoTransitivo.contains(vAdj))
				fechoTransitivo.add(vAdj);
		}
		return fechoTransitivo;
	}
	
	private boolean isConexo() {
		
		boolean valorVerdade = false;
		for (Vertice v : vertices) {
			if (fechoTransitivo(v).size() == ordem())
				valorVerdade = true;
			else {
				valorVerdade = false;
				break;
			}
		}
		return valorVerdade;
	}
	
	private boolean isArvore() {
		Vertice v = umVertice();
		visitadosArvore = new ArrayList<Vertice>();
		return (isConexo() && !haCiclo(v, v));
	}

	private boolean haCiclo(Vertice v, Vertice vAnterior) {
		
		if (visitadosArvore.contains(v))
			return true;
		
		visitadosArvore.add(v);
		for (Vertice vAdj : adjacentes(v)) {
			if (vAdj != vAnterior)
				if (haCiclo(vAdj, v))
					return true;
		}
			
		return false;
	}
	
	// Métodos auxiliares
	public String toString() {
		return vertices.toString();
	}
	
	public String toString_info() 
	{
		String ret = "";
		ret += "Grafo\n";
		ret += "Vértices: \n";
		for ( Vertice v : vertices) ret += "\t" + v + "\n";
		ret += "Arestas: \n";
		for ( Vertice v : vertices ) ret += "\t" + v + " -> " + adjacentes(v).toString() + "\n";
		ret += "Ordem: \n" + "\t" + ordem() + "\n";
		ret += "Grau:  \n";
		for ( Vertice v : vertices) ret += "\t" + v + " -> "+ grau(v) + "\n";
		ret += "Regular: \n" + "\t" + isRegular() + "\n";
		ret += "Completo: \n" + "\t" + isCompleto() + "\n";
		ret += "Conexo: \n" + "\t" + isConexo() + "\n";
		ret += "Arvore: \n" + "\t" + isArvore() + "\n";
		ret += "Fecho Transitivo: \n";
		for ( Vertice v : vertices ) ret += "\t" + v + " -> " + fechoTransitivo(v).toString() + "\n";
		
		return ret;
	}
	
	public static boolean exists(Vertice v) {
		if (vertices.contains(v)) 
			return true;
		return false;
	}

}
