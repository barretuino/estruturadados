package pkAula5Duplamente;

/**
 * Exemplo de Classe que Modela conceitualmente um nó na lista
 * @autor Prof. Ms. Paulo Barreto
 * @data 04/09/2025
 */
class Node {
	int data;
	Node prev;
	Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}