package Grafo;

public class Aresta {

	private int peso;

	public Aresta(int _peso) {
		peso = _peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String toString() {
		return "Peso = " + peso;
	}
}
