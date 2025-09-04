package pkAula5Duplamente;

/**
 * Exemplo de Classe que implementa a lista duplamente ligada
 * @autor Prof. Ms. Paulo Barreto
 * @data 04/09/2025
 */
class DoublyLinkedList {
	Node head; //cabeça
	Node tail; //cauda

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	// Método para obter um array com os dados da lista
	public int[] toArray() {
		if (head == null) {
			return new int[0];
		}
		int size = 0;
		Node current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		int[] result = new int[size];
		current = head;
		for (int i = 0; i < size; i++) {
			result[i] = current.data;
			current = current.next;
		}
		return result;
	}
}