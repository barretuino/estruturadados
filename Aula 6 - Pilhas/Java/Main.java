import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um objeto Scanner para leitura de entrada do usuário
        Scanner scanner = new Scanner(System.in);

        int linhas, colunas;

        do {
            // Solicita o número de linhas e colunas da matriz
            System.out.print("Digite o número de linhas: ");
            linhas = scanner.nextInt();
            System.out.print("Digite o número de colunas: ");
            colunas = scanner.nextInt();

            if (linhas != colunas) {
                System.out.println("O número de linhas e colunas deve ser igual. Tente novamente.");
            }
        } while (linhas != colunas);

        // Cria uma instância da classe MatrizComPilha
        MatrizComPilha matrizComPilha = new MatrizComPilha(linhas, colunas);

        // Imprime a matriz original
        System.out.println("Matriz original:");
        matrizComPilha.imprimirMatriz();

        // Declara variáveis para linha e coluna, e variáveis de erro para validação
        int linha, coluna;
        int erroLinha = 0;
        int erroColuna = 0;
        int escolha;

        // Solicita uma linha válida até que o usuário forneça uma entrada válida
        do {
            erroLinha += 1;
            if (erroLinha > 1) {
                System.out.print("O valor da linha digitado é inválido,");
            }
            System.out.print(" Digite a linha (entre 0 e " + (linhas - 1) + "): ");
            linha = scanner.nextInt();
        } while (linha < 0 || linha >= linhas);

        // Solicita uma coluna válida até que o usuário forneça uma entrada válida
        do {
            erroColuna += 1;
            if (erroColuna > 1) {
                System.out.print("O valor da coluna digitado é inválido,");
            }
            System.out.print("Digite a coluna (entre 0 e " + (colunas - 1) + "): ");
            coluna = scanner.nextInt();
        } while (coluna < 0 || coluna >= colunas || linha == coluna);

        // Solicita ao usuário escolher entre flood fill com pilha ou lista
        System.out.print("Digite 1 para usar o flood fill com pilha ou 2 para escolher o flood fill com lista: ");
        escolha = scanner.nextInt();

        // Executa o flood fill com base na escolha do usuário
        if (escolha == 1) {
            matrizComPilha.fillFunction(linha, coluna);
        } else {
            matrizComPilha.fillFunctionFila(linha, coluna);
        }

        // Imprime a matriz após o preenchimento
        System.out.println("\nMatriz após preenchimento:");
        matrizComPilha.imprimirMatriz();
    }
}
