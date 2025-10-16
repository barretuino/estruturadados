package pjAula10;

public class ArvoreBinariaDeBusca {
	No raiz;

	public void inserir(int valor) {
		raiz = inserirRec(raiz, valor);
	}

	private No inserirRec(No atual, int valor) {
		if (atual == null) {
			return new No(valor);
		}

		if (valor < atual.valor) {
			atual.esquerda = inserirRec(atual.esquerda, valor);
		} else if (valor > atual.valor) {
			atual.direita = inserirRec(atual.direita, valor);
		}
		// Ignora valores duplicados
		return atual;
	}

	// Outros métodos como busca, travessias, remoção (para implementar)
}