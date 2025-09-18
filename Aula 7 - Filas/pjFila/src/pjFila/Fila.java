package pjFila;

import java.util.LinkedList;
import java.util.Queue;

public class Fila<T> {
	private Queue<T> fila;
	private int capacidade;

	public Fila(int capacidade) {
		this.fila = new LinkedList<>();
		this.capacidade = capacidade;
	}

	public boolean enqueue(T elemento) {
		if (fila.size() < capacidade) {
			return fila.offer(elemento); // offer() retorna true se o elemento for adicionado com sucesso
		}
		return false; // Fila cheia
	}

	public T dequeue() {
		return fila.poll(); // poll() retorna null se a fila estiver vazia
	}

	public T peek() {
		return fila.peek(); // peek() retorna null se a fila estiver vazia
	}

	public boolean isEmpty() {
		return fila.isEmpty();
	}

	public int size() {
		return fila.size();
	}

	public int getCapacidade() {
		return capacidade;
	}

	// Método para obter os elementos da fila para a representação visual
	public Object[] toArray() {
		return fila.toArray();
	}
}