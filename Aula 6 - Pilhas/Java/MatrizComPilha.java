public class MatrizComPilha {
    public static int[][] matriz; // Matriz bidimensional de inteiros.
    public static Pilha pilha;    // Instância da classe Pilha (estrutura de dados de pilha).

    // Construtor que recebe o número de linhas e colunas.
    public MatrizComPilha(int linhas, int colunas) {
        matriz = new int[linhas][colunas]; // Cria uma matriz de tamanho linhas x colunas.
        pilha = new Pilha(linhas);         // Cria uma instância da classe Pilha com um tamanho igual ao número de linhas.
        preencherMatriz();                 // Chama o método preencherMatriz para inicializar a matriz com uns.
        marcarLinhaDivisoria();            // Chama o método marcarLinhaDivisoria para estabelecer uma linha diagonal de zeros.
    }

    // Preenche a matriz com uns.
    public void preencherMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 1;
            }
        }
    }

    // Estabelece uma linha diagonal de zeros na matriz e guarda as posições na pilha.
    public void marcarLinhaDivisoria() {
        for (int i = 0; i < matriz.length; i++) {
            int j = i;
            matriz[i][j] = 0;     // Estabelece um zero na posição (i, i).
            pilha.push(i);        // Guarda a posição (i, i) na pilha.
        }
    }

    // Imprime a matriz no console.
    public void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Imprime a matriz em uma etapa específica.
    public void imprimirPassoMatriz(int passo) {
        System.out.println("Passo " + passo + ":");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Realiza um preenchimento na matriz a partir de uma posição específica usando uma pilha.
    public void fillFunction(int linha, int coluna) {
        int passo = 1;

        if (matriz[linha][coluna] != 0) {
            matriz[linha][coluna] = 2; // Marca a posição inicial como 2.

            imprimirPassoMatriz(passo++);

            Pilha positionsToCheck = new Pilha(matriz.length * matriz[0].length);
            positionsToCheck.push(linha * matriz[0].length + coluna);

            while (!positionsToCheck.isEmpty()) {
                int position = positionsToCheck.pop();
                int row = position / matriz[0].length;
                int col = position % matriz[0].length;

                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < matriz.length &&
                            newCol >= 0 && newCol < matriz[0].length &&
                            matriz[newRow][newCol] == 1) {
                        matriz[newRow][newCol] = 2;
                        positionsToCheck.push(newRow * matriz[0].length + newCol);
                        imprimirPassoMatriz(passo++);
                    }
                }
            }
        }
    }

    // Realiza um preenchimento na matriz a partir de uma posição específica usando uma fila.
    public void fillFunctionFila(int linha, int coluna) {
        int passo = 1;

        if (matriz[linha][coluna] != 0) {
            matriz[linha][coluna] = 2;

            imprimirPassoMatriz(passo++);

            Fila positionsToCheck = new Fila(matriz.length * matriz[0].length);
            positionsToCheck.insert(linha * matriz[0].length + coluna);

            while (!positionsToCheck.isEmpty()) {
                int position = positionsToCheck.remove();
                int row = position / matriz[0].length;
                int col = position % matriz[0].length;

                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < matriz.length &&
                            newCol >= 0 && newCol < matriz[0].length &&
                            matriz[newRow][newCol] == 1) {
                        matriz[newRow][newCol] = 2;
                        positionsToCheck.insert(newRow * matriz[0].length + newCol);
                        imprimirPassoMatriz(passo++);
                    }
                }
            }
        }
    }
}
