package pjAula3;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstração da Estrutura de Dados List
 * Coleções diferem de Vetores nos seguintes aspectos
 * 	- Adição e Remoção Dinâmicas, dando elásticidade à estrutura
 *  - Não exige definição rígida de tipo
 *  - Posições dinâmicas (Comportamento alocação dinâmica)
 * Autor: Prof. Ms. Paulo Barreto
 * Data 21/08/2025
 */
public class Estoque {
	public static void main(String[] args) {
		List<Produto> lista = new ArrayList<Produto>();
		
		//Verificar o tamanho da lista
		System.out.println(lista.size());
		System.out.println(lista.isEmpty() ? "Vázia" : "Preenchida");
		
		//Instanciando um Produto
		Produto produto = new Produto();
		produto.codigo = 122;
		produto.descricao = "Lápis de Cor";
		produto.preco = 12.50f;
		
		//Adicionando um elemento na lista
		lista.add(produto);
		
		//Verificar o tamanho da lista
		System.out.println(lista.size());
		System.out.println(lista.isEmpty() ? "Vázia" : "Preenchida");
			
		//Adicionar alguns produtos
		for(int i=0; i<500; i++) {
			Produto objeto = new Produto();
			objeto.codigo = i;
			objeto.descricao = "Produto " + i;
			objeto.preco = System.currentTimeMillis() / 1_000_000_000;
			
			//Entrada na Lista
			lista.add(objeto);
		}
		//Listar conteúdo da lista
		System.out.println(lista.size());
		System.out.println(lista);

		//Vendo agora o conteúdo
		for(Produto p : lista) {
			System.out.println(p.toString());			
		}
		
		lista.removeIf(i -> (i.codigo % 3) == 0);
		lista.forEach(i -> System.out.println(i));
		
		System.out.println(lista.contains(produto));
	}
}