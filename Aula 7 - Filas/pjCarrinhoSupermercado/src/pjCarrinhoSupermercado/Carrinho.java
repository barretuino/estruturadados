package pjCarrinhoSupermercado;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa um carrinho de supermercado que funciona como uma fila (FIFO).
 * O primeiro item a ser colocado é o primeiro a ser retirado no caixa.
 */
public class Carrinho {

	private Queue<String> itens;

	public Carrinho() {
		this.itens = new LinkedList<>();
	}

	/**
	 * Adiciona um item ao carrinho (operação de enfileirar/enqueue).
	 * @param item O nome do item a ser adicionado.
	 */
	public void adicionarItem(String item) {
		System.out.println("-> Colocando '" + item + "' no carrinho.");
		itens.offer(item); // 'offer' adiciona o item no final da fila
	}

	/**
	 * Remove o primeiro item do carrinho para passar no caixa (operação de desenfileirar/dequeue).
	 * @return O item que foi retirado do carrinho, ou null se o carrinho estiver vazio.
	 */
	public String passarItemNoCaixa() {
		if (estaVazio()) {
			System.out.println("-> Carrinho vazio! Não há itens para passar no caixa.");
			return null;
		}
		String itemRemovido = itens.poll(); // 'poll' remove o item do início da fila
		System.out.println("<- Passando '" + itemRemovido + "' no caixa.");
		return itemRemovido;
	}

	/**
	 * Espia o próximo item a ser retirado sem removê-lo (operação de peek).
	 * @return O item que está no início da fila, ou null se o carrinho estiver vazio.
	 */
	public String verProximoItem() {
		if (estaVazio()) {
			System.out.println("-> Carrinho vazio.");
			return null;
		}
		String proximoItem = itens.peek(); // 'peek' apenas retorna o item do início
		System.out.println("-> O próximo item a passar no caixa é: '" + proximoItem + "'");
		return proximoItem;
	}

	/**
	 * Verifica se o carrinho está vazio.
	 * @return true se o carrinho estiver vazio, false caso contrário.
	 */
	public boolean estaVazio() {
		return itens.isEmpty();
	}

	/**
	 * Exibe o conteúdo atual do carrinho.
	 */
	public void exibirCarrinho() {
		if (estaVazio()) {
			System.out.println("Carrinho: [vazio]");
		} else {
			System.out.println("Carrinho: " + itens);
		}
	}
}