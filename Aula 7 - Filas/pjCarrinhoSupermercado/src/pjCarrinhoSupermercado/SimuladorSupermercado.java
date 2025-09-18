package pjCarrinhoSupermercado;

import java.util.Scanner;

public class SimuladorSupermercado {

	public static void main(String[] args) {
		Carrinho meuCarrinho = new Carrinho();
		Scanner scanner = new Scanner(System.in);
		int opcao;

		System.out.println("--- Bem-vindo ao Simulador de Carrinho de Supermercado ---");

		do {
			System.out.println("\nMenu:");
			System.out.println("1. Colocar item no carrinho");
			System.out.println("2. Passar item no caixa");
			System.out.println("3. Ver próximo item no carrinho");
			System.out.println("4. Exibir todos os itens do carrinho");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				opcao = -1; // Opção inválida
			}

			switch (opcao) {
			case 1:
				System.out.print("Digite o nome do item a ser adicionado: ");
				String item = scanner.nextLine();
				meuCarrinho.adicionarItem(item);
				break;
			case 2:
				meuCarrinho.passarItemNoCaixa();
				break;
			case 3:
				meuCarrinho.verProximoItem();
				break;
			case 4:
				meuCarrinho.exibirCarrinho();
				break;
			case 0:
				System.out.println("Saindo do simulador. Boas compras!");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 0);

		scanner.close();
	}
}