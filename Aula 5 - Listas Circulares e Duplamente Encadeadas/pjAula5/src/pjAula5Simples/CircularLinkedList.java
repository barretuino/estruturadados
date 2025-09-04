package pjAula5Simples;

/**
 * Exemplo de Classe que implementa a lista circular
 * @autor Prof. Ms. Paulo Barreto
 * @data 04/09/2025
 */
public class CircularLinkedList {
	// O ponteiro 'last' é usado para facilitar a manipulação da lista
	// Ele sempre aponta para o último nó.
	public Node last;

	public CircularLinkedList() {
		this.last = null;
	}

	// Método para adicionar um novo nó ao final da lista
	public void addEnd(int data) {
		Node newNode = new Node(data);

		// Se a lista estiver vazia, o novo nó será o primeiro e o último
		if (last == null) {
			last = newNode;
			last.next = last; // O nó aponta para si mesmo, formando o círculo
		} else {
			// O novo nó aponta para o primeiro elemento (que é last.next)
			newNode.next = last.next;
			// O último nó atual aponta para o novo nó
			last.next = newNode;
			// O novo nó se torna o novo último nó
			last = newNode;
		}
	}

	// Método para adicionar um novo nó no início da lista
	public void addStart(int data) {
		Node newNode = new Node(data);

		// Se a lista estiver vazia
		if (last == null) {
			last = newNode;
			last.next = last;
		} else {
			// O novo nó aponta para o primeiro elemento (last.next)
			newNode.next = last.next;
			// O 'last' continua apontando para o primeiro elemento, agora o novo nó
			last.next = newNode;
		}
	}

	// Método para remover o primeiro elemento da lista
	public void removeStart() {
		// Se a lista não estiver vazia
		if (last != null) {
			// Se houver apenas um nó na lista
			if (last.next == last) {
				last = null;
			} else {
				// Remove o primeiro nó, fazendo com que last.next aponte para o segundo nó
				last.next = last.next.next;
			}
		}
	}

	// Método para remover um nó com um valor específico
	public void remove(int data) {
		if (last == null) {
			System.out.println("Lista vazia, não é possível remover.");
			return;
		}

		Node current = last.next; // Começa pelo primeiro nó
		Node previous = last; // O nó anterior ao primeiro é o último

		// Se o primeiro nó for o que queremos remover
		if (current.data == data) {
			removeStart();
			return;
		}

		// Percorre a lista para encontrar o nó a ser removido
		do {
			previous = current;
			current = current.next;
			// A condição de parada é quando current.next volta a ser o primeiro nó (last.next)
			if (current == last.next) {
				System.out.println("Elemento " + data + " não encontrado na lista.");
				return;
			}
		} while (current.data != data);

		// Se o nó a ser removido for o último
		if (current == last) {
			previous.next = last.next;
			last = previous;
		} else {
			// Remove o nó, ajustando o ponteiro do nó anterior
			previous.next = current.next;
		}
	}

	// Método para exibir todos os elementos da lista
	public void display() {
		if (last == null) {
			System.out.println("A lista está vazia.");
			return;
		}

		Node current = last.next;
		System.out.print("Lista Circular: ");
		do {
			System.out.print(current.data + " -> ");
			current = current.next;
		} while (current != last.next); // Continua até voltar ao início
		System.out.println("(volta para o início)");
	}

	// Método principal para testar a implementação
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();

		System.out.println("Adicionando 10, 20, 30, 40 no final da lista.");
		list.addEnd(10);
		list.addEnd(20);
		list.addEnd(30);
		list.addEnd(40);
		list.display();

		System.out.println("\nAdicionando 5 no início da lista.");
		list.addStart(5);
		list.display();

		System.out.println("\nRemovendo o primeiro elemento (5).");
		list.removeStart();
		list.display();

		System.out.println("\nRemovendo o elemento 30.");
		list.remove(30);
		list.display();

		System.out.println("\nTentando remover o elemento 99 (não existe).");
		list.remove(99);
	}
}